
package com.aysidisi.worldofdayum.field.model;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Field
{
	private Integer areaId;

	private ObjectId buildingId;

	private ObjectId fieldTypeId;
	
	@Id
	private ObjectId id;
	
	private Integer positionX;
	
	private Integer positionY;

	public Integer getAreaId()
	{
		return this.areaId;
	}

	public ObjectId getBuildingId()
	{
		return this.buildingId;
	}

	public ObjectId getFieldTypeId()
	{
		return this.fieldTypeId;
	}

	public ObjectId getId()
	{
		return this.id;
	}
	
	public Integer getPositionX()
	{
		return this.positionX;
	}
	
	public Integer getPositionY()
	{
		return this.positionY;
	}

	public void setAreaId(final Integer areaId)
	{
		this.areaId = areaId;
	}

	public void setBuildingId(final ObjectId buildingId)
	{
		this.buildingId = buildingId;
	}
	
	public void setFieldTypeId(final ObjectId fieldTypeId)
	{
		this.fieldTypeId = fieldTypeId;
	}

	public void setId(final ObjectId id)
	{
		this.id = id;
	}

	public void setPositionX(final Integer positionX)
	{
		this.positionX = positionX;
	}

	public void setPositionY(final Integer positionY)
	{
		this.positionY = positionY;
	}

}
