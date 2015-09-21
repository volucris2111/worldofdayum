
package com.aysidisi.worldofdayum.ability.model;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.aysidisi.worldofdayum.item.model.Item;
import com.aysidisi.worldofdayum.skill.model.Skill;

@Document
public class Ability
{
	private List<Integer> advancePointsThresholds;
	
	private List<Skill> dependentSkills;
	
	@Id
	private ObjectId id;
	
	private String name;
	
	private List<Item> requiredEquipment;
	
	public List<Integer> getAdvancePointsThresholds()
	{
		return this.advancePointsThresholds;
	}
	
	public List<Skill> getDependentSkills()
	{
		return this.dependentSkills;
	}
	
	public ObjectId getId()
	{
		return this.id;
	}

	public String getName()
	{
		return this.name;
	}

	public List<Item> getRequiredEquipment()
	{
		return this.requiredEquipment;
	}
	
	public void setAdvancePointsThresholds(final List<Integer> advancePointsThresholds)
	{
		this.advancePointsThresholds = advancePointsThresholds;
	}
	
	public void setDependentSkills(final List<Skill> dependentSkills)
	{
		this.dependentSkills = dependentSkills;
	}

	public void setId(final ObjectId id)
	{
		this.id = id;
	}
	
	public void setName(final String name)
	{
		this.name = name;
	}
	
	public void setRequiredEquipment(final List<Item> requiredEquipment)
	{
		this.requiredEquipment = requiredEquipment;
	}
	
}
