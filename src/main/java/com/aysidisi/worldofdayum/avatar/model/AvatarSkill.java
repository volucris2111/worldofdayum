
package com.aysidisi.worldofdayum.avatar.model;

import com.aysidisi.worldofdayum.skill.model.Skill;


public class AvatarSkill
{
	private int exp;
	
	private Skill skill;
	
	private boolean specialized;
	
	public int getExp()
	{
		return this.exp;
	}
	
	public Skill getSkill()
	{
		return this.skill;
	}
	
	public boolean isSpecialized()
	{
		return this.specialized;
	}
	
	public void setExp(final int exp)
	{
		this.exp = exp;
	}
	
	public void setSkill(final Skill skill)
	{
		this.skill = skill;
	}
	
	public void setSpecialized(final boolean specialized)
	{
		this.specialized = specialized;
	}
}
