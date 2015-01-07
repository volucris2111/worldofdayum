
package com.aysidisi.worldofdayum.fieldtype.dao;

import java.math.BigInteger;
import java.util.LinkedList;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.aysidisi.worldofdayum.fieldtype.model.FieldType;

@Repository
public interface FieldTypeDao extends MongoRepository<FieldType, BigInteger>
{
	@Override
	public LinkedList<FieldType> findAll();
}
