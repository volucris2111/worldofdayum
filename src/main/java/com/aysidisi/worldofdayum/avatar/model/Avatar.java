
package com.aysidisi.worldofdayum.avatar.model;

import java.util.HashMap;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Avatar
{

	private HashMap<ObjectId, Integer> abilities;

	private Integer areaId = 0;

	private Integer charisma = 1;

	private Integer constitution = 1;

	private Integer dexterity = 1;
	
	@Id
	private ObjectId id;
	
	private Integer intelligence = 1;

	private Integer knowledge = 1;

	private Boolean mainAvatar;

	private Boolean male;

	private String name;
	
	private ObjectId ownerAccountId;
	
	private Integer positionX = 0;

	private Integer positionY = 0;
	
	private HashMap<ObjectId, Integer> skills;
	
	private Integer strength = 1;
	
	private Integer willpower = 1;
	
	public HashMap<ObjectId, Integer> getAbilities()
	{
		return this.abilities;
	}

	public Integer getAreaId()
	{
		return this.areaId;
	}

	public Integer getCharisma()
	{
		return this.charisma;
	}

	public Integer getConstitution()
	{
		return this.constitution;
	}

	public Integer getDexterity()
	{
		return this.dexterity;
	}
	
	public ObjectId getId()
	{
		return this.id;
	}
	
	public Integer getIntelligence()
	{
		return this.intelligence;
	}
	
	public Integer getKnowledge()
	{
		return this.knowledge;
	}
	
	public Boolean getMainAvatar()
	{
		return this.mainAvatar;
	}

	public Boolean getMale()
	{
		return this.male;
	}

	public String getName()
	{
		return this.name;
	}

	public ObjectId getOwnerAccountId()
	{
		return this.ownerAccountId;
	}

	public Integer getPositionX()
	{
		return this.positionX;
	}
	
	public Integer getPositionY()
	{
		return this.positionY;
	}
	
	public HashMap<ObjectId, Integer> getSkills()
	{
		return this.skills;
	}

	public Integer getStrength()
	{
		return this.strength;
	}

	public Integer getWillpower()
	{
		return this.willpower;
	}

	public void setAbilities(final HashMap<ObjectId, Integer> abilities)
	{
		this.abilities = abilities;
	}

	public void setAreaId(final Integer areaId)
	{
		this.areaId = areaId;
	}

	public void setCharisma(final Integer charisma)
	{
		this.charisma = charisma;
	}
	
	public void setConstitution(final Integer constitution)
	{
		this.constitution = constitution;
	}

	public void setDexterity(final Integer dexterity)
	{
		this.dexterity = dexterity;
	}

	public void setId(final ObjectId id)
	{
		this.id = id;
	}

	public void setIntelligence(final Integer intelligence)
	{
		this.intelligence = intelligence;
	}

	public void setKnowledge(final Integer knowledge)
	{
		this.knowledge = knowledge;
	}
	
	public void setMainAvatar(final Boolean mainAvatar)
	{
		this.mainAvatar = mainAvatar;
	}
	
	public void setMale(final Boolean male)
	{
		this.male = male;
	}
	
	public void setName(final String name)
	{
		this.name = name;
	}
	
	public void setOwnerAccountId(final ObjectId ownerAccountId)
	{
		this.ownerAccountId = ownerAccountId;
	}
	
	public void setPositionX(final Integer positionX)
	{
		this.positionX = positionX;
	}
	
	public void setPositionY(final Integer positionY)
	{
		this.positionY = positionY;
	}
	
	public void setSkills(final HashMap<ObjectId, Integer> skills)
	{
		this.skills = skills;
	}
	
	public void setStrength(final Integer strength)
	{
		this.strength = strength;
	}
	
	public void setWillpower(final Integer willpower)
	{
		this.willpower = willpower;
	}
}
