
package com.aysidisi.worldofdayum.adventure.model;

public class MapTilePojo
{
	private Integer positionX;

	private Integer positionY;

	private Integer relativePositionX;

	private Integer relativePositionY;

	private String sheetName;

	private Integer sheetPositionX;

	private Integer sheetPositionY;
	
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

	public String getSheetName()
	{
		return this.sheetName;
	}

	public Integer getSheetPositionX()
	{
		return this.sheetPositionX;
	}

	public Integer getSheetPositionY()
	{
		return this.sheetPositionY;
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
	
	public void setSheetName(final String sheetName)
	{
		this.sheetName = sheetName;
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
