
package com.aysidisi.worldofdayum.fieldtype.dao;

import java.util.LinkedList;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.aysidisi.worldofdayum.fieldtype.model.FieldType;

public interface FieldTypeDao extends MongoRepository<FieldType, ObjectId>
{
	@Override
	public LinkedList<FieldType> findAll();
}
