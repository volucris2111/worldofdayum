
package com.aysidisi.worldofdayum.buildingtype.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.aysidisi.plainspringwebapp.web.core.ViewManager;
import com.aysidisi.plainspringwebapp.web.core.ViewTemplate;
import com.aysidisi.worldofdayum.buildingtype.service.BuildingTypeService;

@Controller
public class BuldingTypesController
{

	@Autowired
	private BuildingTypeService buildingTypeService;

	@RequestMapping(value = "/admin/buildingtypes", method = RequestMethod.GET)
	public ModelAndView getView()
	{
		ModelAndView modelAndView = ViewManager.generateModelAndView(ViewTemplate.mainTemplate,
				"buildingtype/buildingTypes");
		modelAndView.addObject("buildingTypes", this.buildingTypeService.findAll());
		return modelAndView;
	}
}