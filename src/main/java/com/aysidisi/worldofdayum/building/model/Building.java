
package com.aysidisi.worldofdayum.building.model;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Building
{
	private ObjectId buildingTypeId;
	
	private String description;

	@Id
	private ObjectId id;

	private ObjectId ownerAccountId;
	
	public ObjectId getBuildingTypeId()
	{
		return this.buildingTypeId;
	}
	
	public String getDescription()
	{
		return this.description;
	}

	public ObjectId getId()
	{
		return this.id;
	}

	public ObjectId getOwnerAccountId()
	{
		return this.ownerAccountId;
	}

	public void setBuildingTypeId(final ObjectId buildingTypeId)
	{
		this.buildingTypeId = buildingTypeId;
	}

	public void setDescription(final String description)
	{
		this.description = description;
	}

	public void setId(final ObjectId id)
	{
		this.id = id;
	}
	
	public void setOwnerAccountId(final ObjectId ownerAccountId)
	{
		this.ownerAccountId = ownerAccountId;
	}
	
}
