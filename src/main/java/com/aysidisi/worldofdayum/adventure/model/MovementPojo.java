
package com.aysidisi.worldofdayum.adventure.model;

import org.bson.types.ObjectId;

public class MovementPojo
{
	private ObjectId selectedAvatar;
	
	private Integer x;
	
	private Integer y;
	
	public ObjectId getSelectedAvatar()
	{
		return this.selectedAvatar;
	}
	
	public Integer getX()
	{
		return this.x;
	}
	
	public Integer getY()
	{
		return this.y;
	}

	public void setSelectedAvatar(final ObjectId selectedAvatar)
	{
		this.selectedAvatar = selectedAvatar;
	}
	
	public void setX(final Integer x)
	{
		this.x = x;
	}
	
	public void setY(final Integer y)
	{
		this.y = y;
	}
}
