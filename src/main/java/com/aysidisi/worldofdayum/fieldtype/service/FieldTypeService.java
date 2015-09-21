
package com.aysidisi.worldofdayum.fieldtype.service;

import java.util.LinkedList;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aysidisi.worldofdayum.fieldtype.dao.FieldTypeDao;
import com.aysidisi.worldofdayum.fieldtype.model.FieldType;

@Service
public class FieldTypeService
{
	
	@Autowired
	private FieldTypeDao fieldTypeDao;
	
	public LinkedList<FieldType> findAll()
	{
		return this.fieldTypeDao.findAll();
	}

	public FieldType findById(final ObjectId id)
	{
		return this.fieldTypeDao.findOne(id);
	}
	
	public FieldType save(final FieldType fieldType)
	{
		return this.fieldTypeDao.save(fieldType);
	}

}
