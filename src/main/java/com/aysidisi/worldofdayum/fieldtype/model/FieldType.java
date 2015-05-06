
package com.aysidisi.worldofdayum.fieldtype.model;

import java.math.BigInteger;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class FieldType
{
	@Id
	
	private BigInteger id;

	private Integer movementSpeed;

	private String name;
	
	private Integer sheetPositionX;
	
	private Integer sheetPositionY;
	
	private Boolean walkable;

	public BigInteger getId()
	{
		return this.id;
	}

	public Integer getMovementSpeed()
	{
		return this.movementSpeed;
	}

	public String getName()
	{
		return this.name;
	}
	
	public Integer getSheetPositionX()
	{
		return this.sheetPositionX;
	}

	public Integer getSheetPositionY()
	{
		return this.sheetPositionY;
	}
	
	public Boolean getWalkable()
	{
		return this.walkable;
	}
	
	public void setId(final BigInteger id)
	{
		this.id = id;
	}
	
	public void setMovementSpeed(final Integer movementSpeed)
	{
		this.movementSpeed = movementSpeed;
	}
	
	public void setName(final String name)
	{
		this.name = name;
	}
	
	public void setSheetPositionX(final Integer sheetPositionX)
	{
		this.sheetPositionX = sheetPositionX;
	}
	
	public void setSheetPositionY(final Integer sheetPositionY)
	{
		this.sheetPositionY = sheetPositionY;
	}
	
	public void setWalkable(final Boolean walkable)
	{
		this.walkable = walkable;
	}

}
