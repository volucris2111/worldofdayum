
package com.aysidisi.worldofdayum.field.controller;

import java.math.BigInteger;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.aysidisi.plainspringwebapp.web.core.ViewManager;
import com.aysidisi.plainspringwebapp.web.core.ViewTemplate;
import com.aysidisi.worldofdayum.adventure.model.MapTilePojo;
import com.aysidisi.worldofdayum.field.model.Field;
import com.aysidisi.worldofdayum.field.service.FieldService;
import com.aysidisi.worldofdayum.fieldtype.service.FieldTypeService;

@Controller
public class AreaEditorController
{
	@Autowired
	private FieldTypeService fFieldTypeService;

	@Autowired
	private FieldService fieldService;

	@RequestMapping(value = "/admin/areaeditor", method = RequestMethod.GET)
	public ModelAndView areaEditor()
	{

		ModelAndView modelAndView = ViewManager.generateModelAndView(ViewTemplate.mainTemplate,
				"areaeditor/areaEditor");
		modelAndView.addObject("fieldTypes", this.fFieldTypeService.findAll());
		modelAndView.addObject("fields",
				this.fieldService.getAreaClusterByPositionOfSize(0, 0, 0, 5));
		return modelAndView;
	}

	@RequestMapping(value = "/admin/areaeditor", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE, params =
	{ "x", "y", "areaId", "size" })
	@ResponseBody
	public List<MapTilePojo> getAreaCluster(@RequestParam final Integer x,
			@RequestParam final Integer y, @RequestParam final Integer areaId,
			@RequestParam final Integer size)
	{
		return this.fieldService.getAreaClusterByPositionOfSize(x, y, areaId, size);
	}

	@RequestMapping(value = "/admin/areaeditor", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE, params =
	{ "x", "y", "areaId", "fieldTypeId" })
	@ResponseBody
	public void setFieldType(@RequestParam final Integer x, @RequestParam final Integer y,
			@RequestParam final Integer areaId, @RequestParam final String fieldTypeId)
	{
		Field field = this.fieldService.findByPositionXAndPositionYAndAreaId(x, y, areaId);
		if (field == null)
		{
			field = new Field();
			field.setPositionX(x);
			field.setPositionY(y);
			field.setAreaId(areaId);
		}
		field.setFieldTypeId(new BigInteger(fieldTypeId));
		this.fieldService.save(field);
	}
}
