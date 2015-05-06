
package com.aysidisi.worldofdayum.adventure.model;

import java.util.List;

import com.aysidisi.worldofdayum.avatar.model.Avatar;
import com.aysidisi.worldofdayum.building.model.Building;
import com.aysidisi.worldofdayum.buildingtype.model.BuildingType;
import com.aysidisi.worldofdayum.field.model.Field;
import com.aysidisi.worldofdayum.fieldtype.model.FieldType;

public class AdventureField
{
	private List<Avatar> avatars;

	private Building building;
	
	private BuildingType buildingType;
	
	private Field field;

	private FieldType fieldType;

	public List<Avatar> getAvatars()
	{
		return this.avatars;
	}
	
	public Building getBuilding()
	{
		return this.building;
	}
	
	public BuildingType getBuildingType()
	{
		return this.buildingType;
	}

	public Field getField()
	{
		return this.field;
	}

	public FieldType getFieldType()
	{
		return this.fieldType;
	}
	
	public void setAvatars(final List<Avatar> avatars)
	{
		this.avatars = avatars;
	}
	
	public void setBuilding(final Building building)
	{
		this.building = building;
	}
	
	public void setBuildingType(final BuildingType buildingType)
	{
		this.buildingType = buildingType;
	}
	
	public void setField(final Field field)
	{
		this.field = field;
	}
	
	public void setFieldType(final FieldType fieldType)
	{
		this.fieldType = fieldType;
	}
}
