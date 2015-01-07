
package com.aysidisi.worldofdayum.avatarclass.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.aysidisi.plainspringwebapp.web.core.ViewManager;
import com.aysidisi.plainspringwebapp.web.core.ViewTemplate;
import com.aysidisi.worldofdayum.avatarclass.service.AvatarClassService;

@Controller
public class AvatarClassesController
{
	
	@Autowired
	private AvatarClassService avatarClassService;
	
	@RequestMapping(value = "/admin/avatarclasses", method = RequestMethod.GET)
	public ModelAndView getView()
	{
		ModelAndView modelAndView = new ModelAndView(ViewManager.generateViewName(
				ViewTemplate.mainTemplate, "avatarclass/avatarClasses"));
		modelAndView.addObject("avatarClasses", this.avatarClassService.findAll());
		return modelAndView;
	}
}
