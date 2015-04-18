
package com.aysidisi.worldofdayum.building.dao;

import java.math.BigInteger;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.aysidisi.worldofdayum.building.model.Building;

public interface BuildingDao extends MongoRepository<Building, BigInteger>
{
	List<Building> findByOwnerAccountId(BigInteger ownerAccountId);
}
