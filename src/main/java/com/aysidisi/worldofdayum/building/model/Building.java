
package com.aysidisi.worldofdayum.building.model;

import java.math.BigInteger;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Building
{
	private BigInteger buildingTypeId;

	private String description;
	
	@Id
	private BigInteger id;
	
	private BigInteger ownerAccountId;

	public BigInteger getBuildingTypeId()
	{
		return this.buildingTypeId;
	}

	public String getDescription()
	{
		return this.description;
	}
	
	public BigInteger getId()
	{
		return this.id;
	}
	
	public BigInteger getOwnerAccountId()
	{
		return this.ownerAccountId;
	}
	
	public void setBuildingTypeId(final BigInteger buildingTypeId)
	{
		this.buildingTypeId = buildingTypeId;
	}
	
	public void setDescription(final String description)
	{
		this.description = description;
	}
	
	public void setId(final BigInteger id)
	{
		this.id = id;
	}

	public void setOwnerAccountId(final BigInteger ownerAccountId)
	{
		this.ownerAccountId = ownerAccountId;
	}

}
