
package com.aysidisi.worldofdayum.building.model;

import java.math.BigInteger;

import javax.persistence.GeneratedValue;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Building
{
	private BigInteger buildingTypeId;

	@Id
	@GeneratedValue
	private BigInteger id;
	
	private BigInteger ownerAccountId;
	
	public BigInteger getBuildingTypeId()
	{
		return this.buildingTypeId;
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
	
	public void setId(final BigInteger id)
	{
		this.id = id;
	}

	public void setOwnerAccountId(final BigInteger ownerAccountId)
	{
		this.ownerAccountId = ownerAccountId;
	}

}
