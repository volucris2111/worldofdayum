
package com.aysidisi.dungeonlordsandraiders.dungeon.model;

import java.math.BigInteger;

public class MovementPojo
{
	private Integer x;

	private Integer y;
	
	private BigInteger selectedAvatar;
	
	public Integer getX()
	{
		return this.x;
	}
	
	public BigInteger getSelectedAvatar()
	{
		return selectedAvatar;
	}

	public void setSelectedAvatar(BigInteger selectedAvatar)
	{
		this.selectedAvatar = selectedAvatar;
	}

	public Integer getY()
	{
		return this.y;
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
