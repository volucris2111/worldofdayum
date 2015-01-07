
package com.aysidisi.worldofdayum.avatar.model;

import java.math.BigInteger;

public class AvatarPojo
{
	private Integer areaId;
	
	private BigInteger id;

	private String name;

	private BigInteger ownerAccountId;

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
	
	public BigInteger getId()
	{
		return this.id;
	}
	
	public String getName()
	{
		return this.name;
	}
	
	public BigInteger getOwnerAccountId()
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

	public void setId(final BigInteger id)
	{
		this.id = id;
	}

	public void setName(final String name)
	{
		this.name = name;
	}

	public void setOwnerAccountId(final BigInteger ownerAccountId)
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
