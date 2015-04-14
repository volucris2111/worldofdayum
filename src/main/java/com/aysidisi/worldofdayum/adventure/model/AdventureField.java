
package com.aysidisi.worldofdayum.adventure.model;

import java.util.List;

import com.aysidisi.worldofdayum.avatar.model.Avatar;
import com.aysidisi.worldofdayum.building.model.Building;
import com.aysidisi.worldofdayum.field.model.Field;

public class AdventureField
{
	private List<Avatar> avatars;

	private Building building;
	
	private Field field;
	
	public List<Avatar> getAvatars()
	{
		return this.avatars;
	}
	
	public Building getBuilding()
	{
		return this.building;
	}
	
	public Field getField()
	{
		return this.field;
	}
	
	public void setAvatars(final List<Avatar> avatars)
	{
		this.avatars = avatars;
	}
	
	public void setBuilding(final Building building)
	{
		this.building = building;
	}
	
	public void setField(final Field field)
	{
		this.field = field;
	}
}
