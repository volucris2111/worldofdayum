
package com.aysidisi.worldofdayum.skill.service;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

import org.springframework.stereotype.Service;

import com.aysidisi.worldofdayum.skill.model.Skill;

@Service
public class SkillService
{
	public LinkedList<Skill> getSkillListSortedByName()
	{
		LinkedList<Skill> sortedSkills = new LinkedList<Skill>();
		for (Skill skill : Skill.values())
		{
			sortedSkills.add(skill);
		}
		Comparator<Skill> skillComparator = new Comparator<Skill>()
		{
			@Override
			public int compare(final Skill skill1, final Skill skill2)
			{
				return skill1.getName().compareTo(skill2.getName());
			}
		};
		Collections.sort(sortedSkills, skillComparator);
		return sortedSkills;
	}
}
