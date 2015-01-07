
package com.aysidisi.worldofdayum.adventure.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.aysidisi.plainspringwebapp.web.account.model.Account;
import com.aysidisi.plainspringwebapp.web.core.ViewManager;
import com.aysidisi.plainspringwebapp.web.core.ViewTemplate;
import com.aysidisi.worldofdayum.avatar.model.Avatar;
import com.aysidisi.worldofdayum.avatar.model.AvatarPojo;
import com.aysidisi.worldofdayum.avatar.service.AvatarService;
import com.aysidisi.worldofdayum.field.model.FieldPojo;
import com.aysidisi.worldofdayum.field.service.FieldService;

@Controller
public class AdventureMapController
{

	@Autowired
	private AvatarService avatarService;

	@Autowired
	private FieldService fieldService;
	
	@RequestMapping(value = "/adventure/mapcluster", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<FieldPojo> getAdventureMap()
	{
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		Account account = (Account) authentication.getPrincipal();
		return this.fieldService.getRelativeAdventureMapForAvatar(this.avatarService
				.findOne(account.getCurrentAvatarId()));
	}
	
	@RequestMapping(value = "/adventure", method = RequestMethod.GET)
	public ModelAndView getAdventureView()
	{
		ModelAndView modelAndView = new ModelAndView(ViewManager.generateViewName(
				ViewTemplate.mainTemplate, "adventure/adventure"));
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		Account account = (Account) authentication.getPrincipal();
		Avatar avatar = this.avatarService.findOne(account.getCurrentAvatarId());
		List<Avatar> avatars = this.avatarService.getAvatarsNearAvatar(avatar);
		modelAndView.addObject("avatars", avatars);
		return modelAndView;
	}
	
	@RequestMapping(value = "/adventure/avatars", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<AvatarPojo> getAvatars()
	{
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		Account account = (Account) authentication.getPrincipal();
		return this.avatarService.getAvatarPojosNearAvatar(this.avatarService.findOne(account
				.getCurrentAvatarId()));
	}
}
