
package com.aysidisi.worldofdayum.building.service;

import java.math.BigInteger;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aysidisi.worldofdayum.building.dao.BuildingDao;
import com.aysidisi.worldofdayum.building.model.Building;

@Service
public class BuildingService
{
	@Autowired
	private BuildingDao buildingDao;
	
	public Building findOne(final BigInteger buildingId)
	{
		return this.buildingDao.findOne(buildingId);
	}

	public Building save(final Building building)
	{
		return this.buildingDao.save(building);
	}
	
	List<Building> findByOwnerAccountId(final BigInteger ownerAccountId)
	{
		return this.buildingDao.findByOwnerAccountId(ownerAccountId);
	}
}
