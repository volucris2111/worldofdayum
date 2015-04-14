
package com.aysidisi.worldofdayum.buildingtype.dao;

import java.math.BigInteger;
import java.util.LinkedList;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.aysidisi.worldofdayum.buildingtype.model.BuildingType;

public interface BuildingTypeDao extends MongoRepository<BuildingType, BigInteger>
{
	@Override
	public LinkedList<BuildingType> findAll();
}
