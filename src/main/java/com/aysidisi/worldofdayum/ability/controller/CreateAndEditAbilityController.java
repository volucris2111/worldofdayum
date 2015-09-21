
package com.aysidisi.worldofdayum.ability.controller;

import java.util.LinkedList;

import javax.servlet.http.HttpServletRequest;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.aysidisi.plainspringwebapp.web.core.ViewManager;
import com.aysidisi.plainspringwebapp.web.core.ViewTemplate;
import com.aysidisi.worldofdayum.ability.model.Ability;
import com.aysidisi.worldofdayum.ability.service.AbilityService;
import com.aysidisi.worldofdayum.skill.service.SkillService;

@Controller
public class CreateAndEditAbilityController
{
	@Autowired
	private AbilityService abilityService;
	
	@Autowired
	private SkillService skillService;
	
	@RequestMapping(value = "/admin/abilities/", method = RequestMethod.GET, params = "create")
	public ModelAndView create()
	{
		return this.initView(new Ability());
	}
	
	@RequestMapping(value = "/admin/abilities/{abilityId}", method = RequestMethod.GET, params = "edit")
	public ModelAndView edit(@PathVariable final ObjectId abilityId)
	{
		Ability ability = this.abilityService.findOne(abilityId);
		if (ability == null)
		{
			ability = new Ability();
		}
		return this.initView(ability);
	}
	
	@RequestMapping(value = "/admin/abilities", method = RequestMethod.POST)
	public ModelAndView save(final Ability ability, final HttpServletRequest request)
	{
		ModelAndView modelAndView = new ModelAndView("redirect:/admin/abilities");
		if (ability.getAdvancePointsThresholds() != null)
		{
			while (ability.getAdvancePointsThresholds().contains(null))
			{
				ability.getAdvancePointsThresholds().remove(null);
			}
		}
		if (this.validateAbility(ability))
		{
			modelAndView = this.initView(ability);
		}
		else
		{
			this.abilityService.save(ability);
		}
		return modelAndView;
	}

	private ModelAndView initView(final Ability ability)
	{
		ModelAndView modelAndView = ViewManager.generateModelAndView(ViewTemplate.mainTemplate,
				"ability/createOrEditAbility");
		if (ability.getAdvancePointsThresholds() == null)
		{
			ability.setAdvancePointsThresholds(new LinkedList<Integer>());
		}
		ability.getAdvancePointsThresholds().sort((e1, e2) -> e1.compareTo(e2));
		modelAndView.addObject("ability", ability);
		modelAndView.addObject("skills", this.skillService.getSkillListSortedByNameAndSkillType());
		return modelAndView;
	}
	
	private boolean validateAbility(final Ability ability)
	{
		return false;
	}
}
