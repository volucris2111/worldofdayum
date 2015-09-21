
package com.aysidisi.worldofdayum.ability.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.aysidisi.plainspringwebapp.web.core.ViewManager;
import com.aysidisi.plainspringwebapp.web.core.ViewTemplate;
import com.aysidisi.worldofdayum.ability.service.AbilityService;

@Controller
public class AbilitiesController
{
	
	@Autowired
	private AbilityService abilityService;
	
	@RequestMapping(value = "/admin/abilities", method = RequestMethod.GET)
	public ModelAndView getView()
	{
		ModelAndView modelAndView = ViewManager.generateModelAndView(ViewTemplate.mainTemplate,
				"ability/abilities");
		modelAndView.addObject("abilities",
				this.abilityService.getAbilityListSortedByNameAndAbilityType());
		return modelAndView;
	}
}