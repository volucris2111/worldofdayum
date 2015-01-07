
package com.aysidisi.worldofdayum.group.model;

import java.math.BigInteger;
import java.util.List;

import javax.persistence.GeneratedValue;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Group
{

	@Id
	@GeneratedValue
	private BigInteger id;
	
	private BigInteger leaderId;

	private List<BigInteger> memberIds;
	
	public BigInteger getId()
	{
		return this.id;
	}
	
	public BigInteger getLeaderId()
	{
		return this.leaderId;
	}
	
	public List<BigInteger> getMemberIds()
	{
		return this.memberIds;
	}
	
	public void setId(final BigInteger id)
	{
		this.id = id;
	}
	
	public void setLeaderId(final BigInteger leaderId)
	{
		this.leaderId = leaderId;
	}
	
	public void setMemberIds(final List<BigInteger> memberIds)
	{
		this.memberIds = memberIds;
	}
}
