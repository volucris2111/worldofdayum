
package com.aysidisi.worldofdayum.item.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.aysidisi.plainspringwebapp.web.core.ViewManager;
import com.aysidisi.plainspringwebapp.web.core.ViewTemplate;
import com.aysidisi.worldofdayum.item.service.ItemService;

@Controller
public class ItemsController
{

	@Autowired
	private ItemService itemService;

	@RequestMapping(value = "/admin/items", method = RequestMethod.GET)
	public ModelAndView getView()
	{
		ModelAndView modelAndView = ViewManager.generateModelAndView(ViewTemplate.mainTemplate,
				"item/items");
		modelAndView.addObject("items", this.itemService.getItemListSortedByNameAndItemType());
		return modelAndView;
	}
}