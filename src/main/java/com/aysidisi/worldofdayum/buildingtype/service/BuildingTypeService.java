
package com.aysidisi.worldofdayum.buildingtype.service;

import java.util.LinkedList;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aysidisi.worldofdayum.buildingtype.dao.BuildingTypeDao;
import com.aysidisi.worldofdayum.buildingtype.model.BuildingType;

@Service
public class BuildingTypeService
{
	@Autowired
	private BuildingTypeDao buildingTypeDao;

	public LinkedList<BuildingType> findAll()
	{
		return this.buildingTypeDao.findAll();
	}

	public BuildingType findById(final ObjectId id)
	{
		return this.buildingTypeDao.findOne(id);
	}

	public LinkedList<BuildingType> findByRequiredFieldTypeId(final ObjectId fieldTypeId)
	{
		return this.buildingTypeDao.findByRequiredFieldTypeId(fieldTypeId);
	}
	
	public BuildingType save(final BuildingType buildingType)
	{
		return this.buildingTypeDao.save(buildingType);
	}
}
