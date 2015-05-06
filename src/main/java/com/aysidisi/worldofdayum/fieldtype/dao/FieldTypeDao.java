
package com.aysidisi.worldofdayum.fieldtype.dao;

import java.math.BigInteger;
import java.util.LinkedList;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.aysidisi.worldofdayum.fieldtype.model.FieldType;

public interface FieldTypeDao extends MongoRepository<FieldType, BigInteger>
{
	@Override
	public LinkedList<FieldType> findAll();
}
