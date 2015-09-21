
package com.aysidisi.worldofdayum.skill.service;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aysidisi.worldofdayum.skill.dao.SkillDao;
import com.aysidisi.worldofdayum.skill.model.Skill;

@Service
public class SkillService
{
	@Autowired
	private SkillDao skillDao;

	public Skill findOne(final ObjectId skillId)
	{
		return this.skillDao.findOne(skillId);
	}
	
	public List<Skill> getSkillListSortedByNameAndSkillType()
	{
		List<Skill> sortedSkills = this.skillDao.findAll();
		sortedSkills.sort((e1, e2) -> e1.getName().compareTo(e2.getName()));
		sortedSkills.sort((e1, e2) -> e2.getSkillType().name().compareTo(e1.getSkillType().name()));
		return sortedSkills;
	}

	public void save(final Skill skill)
	{
		this.skillDao.save(skill);
		
	}
}
