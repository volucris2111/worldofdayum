
package com.aysidisi.worldofdayum.buildingtype.dao;

import java.util.LinkedList;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.aysidisi.worldofdayum.buildingtype.model.BuildingType;

public interface BuildingTypeDao extends MongoRepository<BuildingType, ObjectId>
{
	@Override
	public LinkedList<BuildingType> findAll();
	
	public LinkedList<BuildingType> findByRequiredFieldTypeId(ObjectId fieldTypeId);
}
