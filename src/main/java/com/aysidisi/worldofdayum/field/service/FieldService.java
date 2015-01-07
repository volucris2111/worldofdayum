
package com.aysidisi.worldofdayum.field.service;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aysidisi.worldofdayum.avatar.model.Avatar;
import com.aysidisi.worldofdayum.field.dao.FieldDao;
import com.aysidisi.worldofdayum.field.model.Field;
import com.aysidisi.worldofdayum.field.model.FieldPojo;
import com.aysidisi.worldofdayum.fieldtype.model.FieldType;
import com.aysidisi.worldofdayum.fieldtype.service.FieldTypeService;

@Service
public class FieldService
{
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
	
	public LinkedList<FieldPojo> getAreaClusterByPositionOfSize(final Integer positionX,
			final Integer positionY, final Integer areaId, final Integer size)
	{
		LinkedList<FieldPojo> areaCluster = new LinkedList<FieldPojo>();
		HashMap<BigInteger, FieldType> fieldTypeCache = new HashMap<BigInteger, FieldType>();
		for (Field currentField : this.findByPositionXBetweenAndPositionYBetweenAndAreaId(positionX
				- size - 1, positionX + size + 1, positionY - size - 1, positionY + size + 1,
				areaId))
		{
			if (fieldTypeCache.get(currentField.getFieldTypeId()) == null)
			{
				fieldTypeCache.put(currentField.getFieldTypeId(),
						this.fieldTypeService.findById(currentField.getFieldTypeId()));
			}
			FieldPojo fieldPojo = new FieldPojo();
			fieldPojo.setPositionX(currentField.getPositionX());
			fieldPojo.setPositionY(currentField.getPositionY());
			fieldPojo.setRelativePositionX(currentField.getPositionX() - positionX + size);
			fieldPojo.setRelativePositionY(currentField.getPositionY() - positionY + size);
			fieldPojo.setSheetPositionX(fieldTypeCache.get(currentField.getFieldTypeId())
					.getSheetPositionX());
			fieldPojo.setSheetPositionY(fieldTypeCache.get(currentField.getFieldTypeId())
					.getSheetPositionY());
			areaCluster.add(fieldPojo);
		}
		return areaCluster;
	}
	
	public LinkedList<FieldPojo> getRelativeAdventureMapForAvatar(final Avatar avatar)
	{
		LinkedList<FieldPojo> relativeAdventureMap = new LinkedList<FieldPojo>();
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
