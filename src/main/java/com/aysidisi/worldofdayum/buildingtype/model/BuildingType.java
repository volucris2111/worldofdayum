
package com.aysidisi.worldofdayum.buildingtype.model;

import java.math.BigInteger;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class BuildingType
{
	@Id
	private BigInteger id;

	private String name;
	
	private BigInteger requiredFieldTypeId;
	
	private Integer sheetPositionX;
	
	private Integer sheetPositionY;
	
	public BigInteger getId()
	{
		return this.id;
	}

	public String getName()
	{
		return this.name;
	}

	public BigInteger getRequiredFieldTypeId()
	{
		return this.requiredFieldTypeId;
	}
	
	public Integer getSheetPositionX()
	{
		return this.sheetPositionX;
	}
	
	public Integer getSheetPositionY()
	{
		return this.sheetPositionY;
	}
	
	public void setId(final BigInteger id)
	{
		this.id = id;
	}
	
	public void setName(final String name)
	{
		this.name = name;
	}
	
	public void setRequiredFieldTypeId(final BigInteger requiredFieldTypeId)
	{
		this.requiredFieldTypeId = requiredFieldTypeId;
	}
	
	public void setSheetPositionX(final Integer sheetPositionX)
	{
		this.sheetPositionX = sheetPositionX;
	}

	public void setSheetPositionY(final Integer sheetPositionY)
	{
		this.sheetPositionY = sheetPositionY;
	}
	
}
