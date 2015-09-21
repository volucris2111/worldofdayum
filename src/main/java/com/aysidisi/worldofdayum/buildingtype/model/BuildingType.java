
package com.aysidisi.worldofdayum.buildingtype.model;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class BuildingType
{
	@Id
	private ObjectId id;
	
	private String name;

	private ObjectId requiredFieldTypeId;

	private Integer sheetPositionX;

	private Integer sheetPositionY;

	public ObjectId getId()
	{
		return this.id;
	}
	
	public String getName()
	{
		return this.name;
	}
	
	public ObjectId getRequiredFieldTypeId()
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

	public void setId(final ObjectId id)
	{
		this.id = id;
	}

	public void setName(final String name)
	{
		this.name = name;
	}

	public void setRequiredFieldTypeId(final ObjectId requiredFieldTypeId)
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
