
package com.aysidisi.worldofdayum.field.service;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aysidisi.worldofdayum.adventure.model.MapTilePojo;
import com.aysidisi.worldofdayum.avatar.model.Avatar;
import com.aysidisi.worldofdayum.building.model.Building;
import com.aysidisi.worldofdayum.building.service.BuildingService;
import com.aysidisi.worldofdayum.buildingtype.model.BuildingType;
import com.aysidisi.worldofdayum.buildingtype.service.BuildingTypeService;
import com.aysidisi.worldofdayum.field.dao.FieldDao;
import com.aysidisi.worldofdayum.field.model.Field;
import com.aysidisi.worldofdayum.fieldtype.model.FieldType;
import com.aysidisi.worldofdayum.fieldtype.service.FieldTypeService;

@Service
public class FieldService
{
	@Autowired
	private BuildingService buildingService;
	
	@Autowired
	private BuildingTypeService buildingTypeService;

	@Autowired
	private FieldDao fieldDao;
	
	@Autowired
	private FieldTypeService fieldTypeService;
	
	public void deletAll()
	{
		this.fieldDao.deleteAll();
	}

	public List<Field> findAll()
	{
		return this.fieldDao.findAll();
	}
	
	public Field findByBuildingId(final BigInteger buildingId)
	{
		return this.fieldDao.findByBuildingId(buildingId);
	}

	public Field findByPositionXAndPositionYAndAreaId(final Integer positionX,
			final Integer positionY, final Integer areaId)
	{
		return this.fieldDao.findByPositionXAndPositionYAndAreaId(positionX, positionY, areaId);
	}

	public List<Field> findByPositionXBetweenAndPositionYBetweenAndAreaId(
			final Integer positionXFrom, final Integer positionXTo, final Integer positionYFrom,
			final Integer positionYTo, final Integer areaId)
	{
		return this.fieldDao.findByPositionXBetweenAndPositionYBetweenAndAreaId(positionXFrom,
				positionXTo, positionYFrom, positionYTo, areaId);
	}
	
	public Field findOne(final BigInteger id)
	{
		return this.fieldDao.findOne(id);
	}

	public LinkedList<MapTilePojo> getAreaClusterByPositionOfSize(final Integer positionX,
			final Integer positionY, final Integer areaId, final Integer size)
			{
		LinkedList<MapTilePojo> areaCluster = new LinkedList<MapTilePojo>();
		HashMap<BigInteger, FieldType> fieldTypeCache = new HashMap<BigInteger, FieldType>();
		HashMap<BigInteger, BuildingType> buildingTypeCache = new HashMap<BigInteger, BuildingType>();
		for (Field currentField : this.findByPositionXBetweenAndPositionYBetweenAndAreaId(positionX
				- size - 1, positionX + size + 1, positionY - size - 1, positionY + size + 1,
				areaId))
		{
			if (fieldTypeCache.get(currentField.getFieldTypeId()) == null)
			{
				fieldTypeCache.put(currentField.getFieldTypeId(),
						this.fieldTypeService.findById(currentField.getFieldTypeId()));
			}
			MapTilePojo mapTilePojo = new MapTilePojo();
			mapTilePojo.setPositionX(currentField.getPositionX());
			mapTilePojo.setPositionY(currentField.getPositionY());
			mapTilePojo.setRelativePositionX(currentField.getPositionX() - positionX + size);
			mapTilePojo.setRelativePositionY(currentField.getPositionY() - positionY + size);
			if (currentField.getBuildingId() != null)
			{
				Building building = this.buildingService.findOne(currentField.getBuildingId());
				if (buildingTypeCache.get(building.getBuildingTypeId()) == null)
				{
					buildingTypeCache.put(building.getBuildingTypeId(),
							this.buildingTypeService.findById(building.getBuildingTypeId()));
				}
				BuildingType buildingType = buildingTypeCache.get(building.getBuildingTypeId());
				mapTilePojo.setSheetPositionX(buildingType.getSheetPositionX());
				mapTilePojo.setSheetPositionY(buildingType.getSheetPositionY());
				mapTilePojo.setSheetName("buildingSheet");
			}
			else
			{
				FieldType fieldType = fieldTypeCache.get(currentField.getFieldTypeId());
				mapTilePojo.setSheetPositionX(fieldType.getSheetPositionX());
				mapTilePojo.setSheetPositionY(fieldType.getSheetPositionY());
				mapTilePojo.setSheetName("terrainSheet");
			}
			areaCluster.add(mapTilePojo);

		}
		return areaCluster;
			}

	public LinkedList<MapTilePojo> getRelativeAdventureMapForAvatar(final Avatar avatar)
	{
		LinkedList<MapTilePojo> relativeAdventureMap = new LinkedList<MapTilePojo>();
		if (avatar != null)
		{
			relativeAdventureMap = this.getAreaClusterByPositionOfSize(avatar.getPositionX(),
					avatar.getPositionY(), avatar.getAreaId(), 3);
			
		}
		return relativeAdventureMap;
	}

	public void save(final Field gameMapField)
	{
		this.fieldDao.save(gameMapField);
	}
}
