
package com.aysidisi.worldofdayum.skill.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.aysidisi.plainspringwebapp.web.core.ViewManager;
import com.aysidisi.plainspringwebapp.web.core.ViewTemplate;
import com.aysidisi.worldofdayum.skill.service.SkillService;

@Controller
public class SkillsController
{

	@Autowired
	private SkillService skillService;

	@RequestMapping(value = "/admin/skills", method = RequestMethod.GET)
	public ModelAndView getView()
	{
		ModelAndView modelAndView = new ModelAndView(ViewManager.generateViewName(
				ViewTemplate.mainTemplate, "skill/skills"));
		modelAndView.addObject("skills", this.skillService.getSkillListSortedByNameAndSkillType());
		return modelAndView;
	}
}