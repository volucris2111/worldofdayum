
package com.aysidisi.worldofdayum.group.model;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Group
{
	
	@Id

	private ObjectId id;

	private ObjectId leaderId;
	
	private List<ObjectId> memberIds;

	public ObjectId getId()
	{
		return this.id;
	}

	public ObjectId getLeaderId()
	{
		return this.leaderId;
	}

	public List<ObjectId> getMemberIds()
	{
		return this.memberIds;
	}

	public void setId(final ObjectId id)
	{
		this.id = id;
	}

	public void setLeaderId(final ObjectId leaderId)
	{
		this.leaderId = leaderId;
	}

	public void setMemberIds(final List<ObjectId> memberIds)
	{
		this.memberIds = memberIds;
	}
}
