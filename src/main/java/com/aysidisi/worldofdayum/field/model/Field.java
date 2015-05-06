
package com.aysidisi.worldofdayum.field.model;

import java.math.BigInteger;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Field
{
	private Integer areaId;
	
	private BigInteger buildingId;
	
	private BigInteger fieldTypeId;

	@Id
	private BigInteger id;

	private Integer positionX;

	private Integer positionY;
	
	public Integer getAreaId()
	{
		return this.areaId;
	}
	
	public BigInteger getBuildingId()
	{
		return this.buildingId;
	}
	
	public BigInteger getFieldTypeId()
	{
		return this.fieldTypeId;
	}
	
	public BigInteger getId()
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
	
	public void setBuildingId(final BigInteger buildingId)
	{
		this.buildingId = buildingId;
	}

	public void setFieldTypeId(final BigInteger fieldTypeId)
	{
		this.fieldTypeId = fieldTypeId;
	}
	
	public void setId(final BigInteger id)
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
