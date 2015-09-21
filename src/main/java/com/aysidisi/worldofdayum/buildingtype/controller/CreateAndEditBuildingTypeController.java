
package com.aysidisi.worldofdayum.buildingtype.controller;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.aysidisi.plainspringwebapp.web.core.ViewManager;
import com.aysidisi.plainspringwebapp.web.core.ViewTemplate;
import com.aysidisi.worldofdayum.buildingtype.model.BuildingType;
import com.aysidisi.worldofdayum.buildingtype.service.BuildingTypeService;
import com.aysidisi.worldofdayum.fieldtype.service.FieldTypeService;

@Controller
public class CreateAndEditBuildingTypeController
{
	@Autowired
	private BuildingTypeService buildingTypeService;

	@Autowired
	private FieldTypeService fieldTypeService;

	@RequestMapping(value = "/admin/buildingtypes/", method = RequestMethod.GET, params = "create")
	public ModelAndView create()
	{
		return this.initView(new BuildingType());
	}
	
	@RequestMapping(value = "/admin/buildingtypes/{buildingTypeId}", method = RequestMethod.GET, params = "edit")
	public ModelAndView edit(@PathVariable final ObjectId buildingTypeId)
	{
		BuildingType buildingType = this.buildingTypeService.findById(buildingTypeId);
		if (buildingType == null)
		{
			buildingType = new BuildingType();
		}
		return this.initView(buildingType);
	}
	
	@RequestMapping(value = "/admin/buildingtypes", method = RequestMethod.POST)
	public ModelAndView save(final BuildingType buildingType)
	{
		ModelAndView modelAndView = new ModelAndView("redirect:/admin/buildingtypes");
		if (this.validateBuildingType(buildingType))
		{
			modelAndView = this.initView(buildingType);
		}
		else
		{
			this.buildingTypeService.save(buildingType);
		}
		return modelAndView;
	}
	
	private ModelAndView initView(final BuildingType buildingType)
	{
		ModelAndView modelAndView = ViewManager.generateModelAndView(ViewTemplate.mainTemplate,
				"buildingtype/createOrEditBuildingType");
		modelAndView.addObject("buildingType", buildingType);
		modelAndView.addObject("fieldTypes", this.fieldTypeService.findAll());
		return modelAndView;
	}

	private boolean validateBuildingType(final BuildingType buildingType)
	{
		return false;
	}
}
