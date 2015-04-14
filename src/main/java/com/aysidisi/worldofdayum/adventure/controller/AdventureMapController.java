
package com.aysidisi.worldofdayum.adventure.controller;

import java.math.BigInteger;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.aysidisi.plainspringwebapp.web.core.ViewManager;
import com.aysidisi.plainspringwebapp.web.core.ViewTemplate;
import com.aysidisi.worldofdayum.adventure.controller.helper.AdventureMapHelper;
import com.aysidisi.worldofdayum.avatar.model.Avatar;
import com.aysidisi.worldofdayum.avatar.model.AvatarPojo;
import com.aysidisi.worldofdayum.avatar.service.AvatarService;
import com.aysidisi.worldofdayum.field.model.FieldPojo;
import com.aysidisi.worldofdayum.field.service.FieldService;

@Controller
public class AdventureMapController
{
	
	@Autowired
	private AdventureMapHelper adventureMapHelper;

	@Autowired
	private AvatarService avatarService;

	@Autowired
	private FieldService fieldService;
	
	@RequestMapping(value = "/adventure/mapcluster", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<FieldPojo> getAdventureMap()
	{
		return this.fieldService.getRelativeAdventureMapForAvatar(this.avatarService
				.getCurrentAvatar());
	}
	
	@RequestMapping(value = "/adventure", method = RequestMethod.GET)
	public ModelAndView getAdventureView()
	{
		ModelAndView modelAndView = new ModelAndView(ViewManager.generateViewName(
				ViewTemplate.mainTemplate, "adventure/adventure"));
		if (this.avatarService.getCurrentAvatar() == null)
		{
			modelAndView = new ModelAndView("redirect:/avatars/?create");
		}
		return modelAndView;
	}
	
	@RequestMapping(value = "/adventure/avatars/{avatarId}/", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ModelAndView getAvatar(@PathVariable final BigInteger avatarId)
	{
		ModelAndView modelAndView = new ModelAndView(ViewManager.generateViewName(
				ViewTemplate.bodyOnly, "adventure/avatarmodal"));
		Avatar currentAvatar = this.avatarService.getCurrentAvatar();
		Avatar avatarForView = this.avatarService.findOne(avatarId);
		if (currentAvatar.getAreaId().equals(avatarForView.getAreaId())
				&& currentAvatar.getPositionX().equals(avatarForView.getPositionX())
				&& currentAvatar.getPositionY().equals(avatarForView.getPositionY()))
		{
			modelAndView.addObject("avatarForView", avatarForView);
		}
		return modelAndView;
	}
	
	@RequestMapping(value = "/adventure/avatars", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<AvatarPojo> getAvatars()
	{
		return this.avatarService.getAvatarPojosNearAvatar(this.avatarService.getCurrentAvatar());
	}

	@RequestMapping(value = "/adventure/currentfield", method = RequestMethod.GET)
	@ResponseBody
	public ModelAndView getCurrentActions()
	{
		ModelAndView modelAndView = new ModelAndView(ViewManager.generateViewName(
				ViewTemplate.bodyOnly, "adventure/currentactions"));
		modelAndView.addObject("currentField", this.adventureMapHelper
				.getCurrentAdventureField(this.avatarService.getCurrentAvatar()));
		return modelAndView;
	}
}
