
package com.aysidisi.worldofdayum.buildingtype.service;

import java.math.BigInteger;
import java.util.LinkedList;

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
	
	public BuildingType findById(final BigInteger id)
	{
		return this.buildingTypeDao.findOne(id);
	}

	public BuildingType save(final BuildingType buildingType)
	{
		return this.buildingTypeDao.save(buildingType);
	}
}
