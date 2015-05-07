
package com.aysidisi.worldofdayum.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.aysidisi.plainspringwebapp.web.core.ViewManager;
import com.aysidisi.plainspringwebapp.web.core.ViewTemplate;

@Controller
public class AdminController
{
	@RequestMapping(value = "/admin", method = RequestMethod.GET)
	public ModelAndView getView()
	{
		return ViewManager.generateModelAndView(ViewTemplate.mainTemplate, "admin/admin");
	}
}
