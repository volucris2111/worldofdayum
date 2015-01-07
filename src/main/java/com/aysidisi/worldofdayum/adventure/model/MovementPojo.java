
package com.aysidisi.worldofdayum.adventure.model;

import java.math.BigInteger;

public class MovementPojo
{
	private BigInteger selectedAvatar;

	private Integer x;

	private Integer y;

	public BigInteger getSelectedAvatar()
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
	
	public void setSelectedAvatar(final BigInteger selectedAvatar)
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
