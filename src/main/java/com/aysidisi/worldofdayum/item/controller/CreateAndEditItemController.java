
package com.aysidisi.worldofdayum.item.controller;

import javax.servlet.http.HttpServletRequest;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.aysidisi.plainspringwebapp.web.core.ViewManager;
import com.aysidisi.plainspringwebapp.web.core.ViewTemplate;
import com.aysidisi.worldofdayum.item.model.Item;
import com.aysidisi.worldofdayum.item.model.ItemType;
import com.aysidisi.worldofdayum.item.service.ItemService;

@Controller
public class CreateAndEditItemController
{
	@Autowired
	private ItemService itemService;
	
	@RequestMapping(value = "/admin/items/", method = RequestMethod.GET, params = "create")
	public ModelAndView create()
	{
		return this.initView(new Item());
	}
	
	@RequestMapping(value = "/admin/items/{itemId}", method = RequestMethod.GET, params = "edit")
	public ModelAndView edit(@PathVariable final ObjectId itemId)
	{
		Item item = this.itemService.findOne(itemId);
		if (item == null)
		{
			item = new Item();
		}
		return this.initView(item);
	}
	
	@RequestMapping(value = "/admin/items", method = RequestMethod.POST)
	public ModelAndView save(final Item item, final HttpServletRequest request)
	{
		ModelAndView modelAndView = new ModelAndView("redirect:/admin/items");
		if (this.validateItem(item))
		{
			modelAndView = this.initView(item);
		}
		else
		{
			this.itemService.save(item);
		}
		return modelAndView;
	}

	private ModelAndView initView(final Item item)
	{
		ModelAndView modelAndView = ViewManager.generateModelAndView(ViewTemplate.mainTemplate,
				"item/createOrEditItem");
		modelAndView.addObject("item", item);
		modelAndView.addObject("itemTypes", ItemType.values());
		return modelAndView;
	}
	
	private boolean validateItem(final Item item)
	{
		return false;
	}
}
