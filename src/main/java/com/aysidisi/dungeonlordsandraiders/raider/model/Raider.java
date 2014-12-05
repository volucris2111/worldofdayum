
package com.aysidisi.dungeonlordsandraiders.raider.model;

import java.math.BigInteger;

import javax.persistence.GeneratedValue;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Raider
{
	
	private BigInteger fieldId;

	@Id
	@GeneratedValue
	private BigInteger id;

	private String name;

	private BigInteger ownerAccountId;
	
	public BigInteger getFieldId()
	{
		return this.fieldId;
	}
	
	public BigInteger getId()
	{
		return this.id;
	}
	
	public String getName()
	{
		return this.name;
	}
	
	public BigInteger getOwnerAccountId()
	{
		return this.ownerAccountId;
	}
	
	public void setFieldId(final BigInteger fieldId)
	{
		this.fieldId = fieldId;
	}
	
	public void setId(final BigInteger id)
	{
		this.id = id;
	}
	
	public void setName(final String name)
	{
		this.name = name;
	}
	
	public void setOwnerAccountId(final BigInteger ownerAccountId)
	{
		this.ownerAccountId = ownerAccountId;
	}
}
