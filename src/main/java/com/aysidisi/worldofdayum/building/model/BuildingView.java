
package com.aysidisi.worldofdayum.building.model;

import com.aysidisi.worldofdayum.avatar.model.Avatar;
import com.aysidisi.worldofdayum.buildingtype.model.BuildingType;
import com.aysidisi.worldofdayum.field.model.Field;
import com.aysidisi.worldofdayum.fieldtype.model.FieldType;

public class BuildingView
{
	
	Building building;
	
	BuildingType buildingType;
	
	Field field;
	
	FieldType fieldType;
	
	Avatar ownerAvatar;
	
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
	
	public Avatar getOwnerAvatar()
	{
		return this.ownerAvatar;
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
	
	public void setOwnerAvatar(final Avatar ownerAvatar)
	{
		this.ownerAvatar = ownerAvatar;
	}
}
