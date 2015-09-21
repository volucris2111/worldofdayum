
package com.aysidisi.worldofdayum.skill.model;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Skill
{
	private List<Integer> advancePointsThresholds;

	@Id
	private ObjectId id;
	
	private String name;

	private SkillType skillType;

	public List<Integer> getAdvancePointsThresholds()
	{
		return this.advancePointsThresholds;
	}

	public ObjectId getId()
	{
		return this.id;
	}
	
	public String getName()
	{
		return this.name;
	}
	
	public SkillType getSkillType()
	{
		return this.skillType;
	}

	public void setAdvancePointsThresholds(final List<Integer> advancePointsThresholds)
	{
		this.advancePointsThresholds = advancePointsThresholds;
	}

	public void setId(final ObjectId id)
	{
		this.id = id;
	}

	public void setName(final String name)
	{
		this.name = name;
	}

	public void setSkillType(final SkillType skillType)
	{
		this.skillType = skillType;
	}
}
