
package com.aysidisi.worldofdayum.building.dao;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.aysidisi.worldofdayum.building.model.Building;

public interface BuildingDao extends MongoRepository<Building, ObjectId>
{
	List<Building> findByOwnerAccountId(ObjectId ownerAccountId);
}
