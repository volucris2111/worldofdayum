
package com.aysidisi.worldofdayum.fieldtype.controller;

import java.math.BigInteger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.aysidisi.plainspringwebapp.web.core.ViewManager;
import com.aysidisi.plainspringwebapp.web.core.ViewTemplate;
import com.aysidisi.worldofdayum.fieldtype.model.FieldType;
import com.aysidisi.worldofdayum.fieldtype.service.FieldTypeService;

@Controller
public class CreateAndEditFieldTypeController
{
	@Autowired
	private FieldTypeService fieldTypeService;
	
	@RequestMapping(value = "/admin/fieldtypes/", method = RequestMethod.GET, params = "create")
	public ModelAndView create()
	{
		return this.initView(new FieldType());
	}
	
	@RequestMapping(value = "/admin/fieldtypes/{fieldTypeId}", method = RequestMethod.GET, params = "edit")
	public ModelAndView edit(@PathVariable final BigInteger fieldTypeId)
	{
		FieldType fieldType = this.fieldTypeService.findById(fieldTypeId);
		if (fieldType == null)
		{
			fieldType = new FieldType();
		}
		return this.initView(fieldType);
	}

	@RequestMapping(value = "/admin/fieldtypes", method = RequestMethod.POST)
	public ModelAndView save(final FieldType fieldType)
	{
		ModelAndView modelAndView = new ModelAndView("redirect:/admin/fieldtypes");
		if (this.validateFieldType(fieldType))
		{
			modelAndView = this.initView(fieldType);
		}
		else
		{
			this.fieldTypeService.save(fieldType);
		}
		return modelAndView;
	}

	private ModelAndView initView(final FieldType fieldType)
	{
		ModelAndView modelAndView = ViewManager.generateModelAndView(ViewTemplate.mainTemplate,
				"fieldtype/createOrEditFieldType");
		modelAndView.addObject("fieldType", fieldType);
		return modelAndView;
	}
	
	private boolean validateFieldType(final FieldType fieldType)
	{
		return false;
	}
	
}
