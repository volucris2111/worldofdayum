
package com.aysidisi.worldofdayum.avatarclass.model;

import java.math.BigInteger;
import java.util.HashMap;

import javax.persistence.GeneratedValue;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.aysidisi.worldofdayum.avatar.model.AvatarSkill;
import com.aysidisi.worldofdayum.skill.model.Skill;

@Document
public class AvatarClass
{
	private String description;

	@Id
	@GeneratedValue
	private BigInteger id;

	private String nameFemale;
	
	private String nameMale;

	private HashMap<Skill, AvatarSkill> skills;
	
	private Boolean starterClass;
	
	public String getDescription()
	{
		return this.description;
	}
	
	public BigInteger getId()
	{
		return this.id;
	}

	public String getNameFemale()
	{
		return this.nameFemale;
	}

	public String getNameMale()
	{
		return this.nameMale;
	}

	public HashMap<Skill, AvatarSkill> getSkills()
	{
		return this.skills;
	}

	public Boolean getStarterClass()
	{
		return this.starterClass;
	}

	public void setDescription(final String description)
	{
		this.description = description;
	}

	public void setId(final BigInteger id)
	{
		this.id = id;
	}

	public void setNameFemale(final String nameFemale)
	{
		this.nameFemale = nameFemale;
	}
	
	public void setNameMale(final String nameMale)
	{
		this.nameMale = nameMale;
	}
	
	public void setSkills(final HashMap<Skill, AvatarSkill> skills)
	{
		this.skills = skills;
	}

	public void setStarterClass(final Boolean starterClass)
	{
		this.starterClass = starterClass;
	}

}
