
package com.aysidisi.worldofdayum.building.service;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aysidisi.worldofdayum.building.dao.BuildingDao;
import com.aysidisi.worldofdayum.building.model.Building;

@Service
public class BuildingService
{
	@Autowired
	private BuildingDao buildingDao;

	public Building findOne(final ObjectId buildingId)
	{
		return this.buildingDao.findOne(buildingId);
	}
	
	public Building save(final Building building)
	{
		return this.buildingDao.save(building);
	}

	List<Building> findByOwnerAccountId(final ObjectId ownerAccountId)
	{
		return this.buildingDao.findByOwnerAccountId(ownerAccountId);
	}
}
