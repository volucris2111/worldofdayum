
package com.aysidisi.worldofdayum.skill.controller;

import java.math.BigInteger;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.aysidisi.plainspringwebapp.web.core.ViewManager;
import com.aysidisi.plainspringwebapp.web.core.ViewTemplate;
import com.aysidisi.worldofdayum.skill.model.Skill;
import com.aysidisi.worldofdayum.skill.model.SkillType;
import com.aysidisi.worldofdayum.skill.service.SkillService;

@Controller
public class CreateAndEditSkillController
{
	@Autowired
	private SkillService skillService;

	@RequestMapping(value = "/admin/skills/", method = RequestMethod.GET, params = "create")
	public ModelAndView create()
	{
		return this.initView(new Skill());
	}

	@RequestMapping(value = "/admin/skills/{skillId}", method = RequestMethod.GET, params = "edit")
	public ModelAndView edit(@PathVariable final BigInteger skillId)
	{
		Skill skill = this.skillService.findOne(skillId);
		if (skill == null)
		{
			skill = new Skill();
		}
		return this.initView(skill);
	}

	@RequestMapping(value = "/admin/skills", method = RequestMethod.POST)
	public ModelAndView save(final Skill skill, final HttpServletRequest request)
	{
		ModelAndView modelAndView = new ModelAndView("redirect:/admin/skills");
		if (this.validateSkill(skill))
		{
			modelAndView = this.initView(skill);
		}
		else
		{
			this.skillService.save(skill);
		}
		return modelAndView;
	}

	private ModelAndView initView(final Skill skill)
	{
		ModelAndView modelAndView = new ModelAndView(ViewManager.generateViewName(
				ViewTemplate.mainTemplate, "skill/createOrEditSkill"));
		skill.getAdvancePointsThresholds().sort((e1, e2) -> e1.compareTo(e2));
		
		modelAndView.addObject("skill", skill);
		modelAndView.addObject("skillTypes", SkillType.values());
		return modelAndView;
	}
	
	private boolean validateSkill(final Skill skill)
	{
		return false;
	}
}
