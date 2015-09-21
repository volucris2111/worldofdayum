
package com.aysidisi.worldofdayum.ability.service;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aysidisi.worldofdayum.ability.dao.AbilityDao;
import com.aysidisi.worldofdayum.ability.model.Ability;

@Service
public class AbilityService
{
	@Autowired
	private AbilityDao abilityDao;

	public Ability findOne(final ObjectId abilityId)
	{
		return this.abilityDao.findOne(abilityId);
	}
	
	public List<Ability> getAbilityListSortedByNameAndAbilityType()
	{
		List<Ability> sortedAbilities = this.abilityDao.findAll();
		sortedAbilities.sort((e1, e2) -> e1.getName().compareTo(e2.getName()));
		return sortedAbilities;
	}

	public void save(final Ability ability)
	{
		this.abilityDao.save(ability);
		
	}
}
