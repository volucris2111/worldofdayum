
package com.aysidisi.worldofdayum.avatar.model;

import org.bson.types.ObjectId;

public class AvatarPojo
{
	private Integer areaId;

	private ObjectId id;
	
	private String name;
	
	private ObjectId ownerAccountId;
	
	private Integer positionX;
	
	private Integer positionY;

	private Integer relativePositionX;
	
	private Integer relativePositionY;
	
	private Integer sheetPositionX;
	
	private Integer sheetPositionY;
	
	public Integer getAreaId()
	{
		return this.areaId;
	}

	public ObjectId getId()
	{
		return this.id;
	}

	public String getName()
	{
		return this.name;
	}

	public ObjectId getOwnerAccountId()
	{
		return this.ownerAccountId;
	}

	public Integer getPositionX()
	{
		return this.positionX;
	}
	
	public Integer getPositionY()
	{
		return this.positionY;
	}
	
	public Integer getRelativePositionX()
	{
		return this.relativePositionX;
	}
	
	public Integer getRelativePositionY()
	{
		return this.relativePositionY;
	}
	
	public Integer getSheetPositionX()
	{
		return this.sheetPositionX;
	}
	
	public Integer getSheetPositionY()
	{
		return this.sheetPositionY;
	}
	
	public void setAreaId(final Integer areaId)
	{
		this.areaId = areaId;
	}
	
	public void setId(final ObjectId id)
	{
		this.id = id;
	}
	
	public void setName(final String name)
	{
		this.name = name;
	}
	
	public void setOwnerAccountId(final ObjectId ownerAccountId)
	{
		this.ownerAccountId = ownerAccountId;
	}
	
	public void setPositionX(final Integer positionX)
	{
		this.positionX = positionX;
	}
	
	public void setPositionY(final Integer positionY)
	{
		this.positionY = positionY;
	}
	
	public void setRelativePositionX(final Integer relativePositionX)
	{
		this.relativePositionX = relativePositionX;
	}
	
	public void setRelativePositionY(final Integer relativePositionY)
	{
		this.relativePositionY = relativePositionY;
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
