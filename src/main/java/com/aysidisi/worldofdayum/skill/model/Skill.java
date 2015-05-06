
package com.aysidisi.worldofdayum.skill.model;

import java.math.BigInteger;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Skill
{
	private List<Integer> advancePointsThresholds;
	
	@Id
	
	private BigInteger id;

	private String name;
	
	private SkillType skillType;
	
	public List<Integer> getAdvancePointsThresholds()
	{
		return this.advancePointsThresholds;
	}
	
	public BigInteger getId()
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
	
	public void setId(final BigInteger id)
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
