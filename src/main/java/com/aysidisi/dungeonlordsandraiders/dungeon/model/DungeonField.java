
package com.aysidisi.dungeonlordsandraiders.dungeon.model;

import java.math.BigInteger;
import java.util.List;

import javax.persistence.GeneratedValue;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class DungeonField
{
	private Integer fieldTypeId;

	@Id
	@GeneratedValue
	private BigInteger id;

	private Integer positionX;
	
	private Integer positionY;
	
	private List<BigInteger> raiderIds;
	
	public Integer getFieldTypeId()
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
	
	public List<BigInteger> getRaiderIds()
	{
		return this.raiderIds;
	}
	
	public void setFieldTypeId(final Integer fieldTypeId)
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
	
	public void setRaiderIds(final List<BigInteger> raiderIds)
	{
		this.raiderIds = raiderIds;
	}
	
}
