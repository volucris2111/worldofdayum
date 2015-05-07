
package com.aysidisi.worldofdayum.fieldtype.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.aysidisi.plainspringwebapp.web.core.ViewManager;
import com.aysidisi.plainspringwebapp.web.core.ViewTemplate;
import com.aysidisi.worldofdayum.fieldtype.service.FieldTypeService;

@Controller
public class FieldTypesController
{

	@Autowired
	private FieldTypeService fieldTypeService;

	@RequestMapping(value = "/admin/fieldtypes", method = RequestMethod.GET)
	public ModelAndView getView()
	{
		ModelAndView modelAndView = ViewManager.generateModelAndView(ViewTemplate.mainTemplate,
				"fieldtype/fieldTypes");
		modelAndView.addObject("fieldTypes", this.fieldTypeService.findAll());
		return modelAndView;
	}
}
