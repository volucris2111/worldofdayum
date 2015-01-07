
package com.aysidisi.worldofdayum.avatarclass.controller;

import java.math.BigInteger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.aysidisi.plainspringwebapp.web.core.ViewManager;
import com.aysidisi.plainspringwebapp.web.core.ViewTemplate;
import com.aysidisi.worldofdayum.avatarclass.model.AvatarClass;
import com.aysidisi.worldofdayum.avatarclass.service.AvatarClassService;
import com.aysidisi.worldofdayum.skill.service.SkillService;

@Controller
public class CreateAndEditAvatarClassController
{
	@Autowired
	private AvatarClassService avatarClassService;

	@Autowired
	private SkillService skillService;

	@RequestMapping(value = "/admin/avatarclasses/", method = RequestMethod.GET, params = "create")
	public ModelAndView create()
	{
		return this.initView(new AvatarClass());
	}

	@RequestMapping(value = "/admin/avatarclasses/{avatarClassId}", method = RequestMethod.GET, params = "edit")
	public ModelAndView edit(@PathVariable final BigInteger avatarClassId)
	{
		AvatarClass avatarClass = this.avatarClassService.findById(avatarClassId);
		if (avatarClass == null)
		{
			avatarClass = new AvatarClass();
		}
		return this.initView(avatarClass);
	}
	
	@RequestMapping(value = "/admin/avatarclasses", method = RequestMethod.POST)
	public ModelAndView save(final AvatarClass avatarClass)
	{
		ModelAndView modelAndView = new ModelAndView("redirect:/admin/avatarclasses");
		if (this.validateAvatarClass(avatarClass))
		{
			modelAndView = this.initView(avatarClass);
		}
		else
		{
			this.avatarClassService.save(avatarClass);
		}
		return modelAndView;
	}
	
	private ModelAndView initView(final AvatarClass avatarClass)
	{
		ModelAndView modelAndView = new ModelAndView(ViewManager.generateViewName(
				ViewTemplate.mainTemplate, "avatarclass/createOrEditAvatarClass"));
		modelAndView.addObject("avatarClass", avatarClass);
		modelAndView.addObject("skills", this.skillService.getSkillListSortedByName());
		return modelAndView;
	}
	
	private boolean validateAvatarClass(final AvatarClass avatarClass)
	{
		boolean error = false;
		return error;
	}

}
