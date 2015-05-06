
package com.aysidisi.worldofdayum.adventure.controller;

import java.math.BigInteger;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.aysidisi.plainspringwebapp.config.cache.WebSocketSessionCache;
import com.aysidisi.plainspringwebapp.web.account.model.Account;
import com.aysidisi.plainspringwebapp.web.core.ViewManager;
import com.aysidisi.plainspringwebapp.web.core.ViewTemplate;
import com.aysidisi.worldofdayum.adventure.controller.helper.AdventureMapHelper;
import com.aysidisi.worldofdayum.adventure.model.MapTilePojo;
import com.aysidisi.worldofdayum.avatar.model.Avatar;
import com.aysidisi.worldofdayum.avatar.model.AvatarPojo;
import com.aysidisi.worldofdayum.avatar.service.AvatarService;
import com.aysidisi.worldofdayum.building.model.Building;
import com.aysidisi.worldofdayum.building.service.BuildingService;
import com.aysidisi.worldofdayum.buildingtype.service.BuildingTypeService;
import com.aysidisi.worldofdayum.field.model.Field;
import com.aysidisi.worldofdayum.field.service.FieldService;

@Controller
public class AdventureMapController
{
	
	@Autowired
	private AdventureMapHelper adventureMapHelper;

	@Autowired
	private AvatarService avatarService;

	@Autowired
	private BuildingService buildingService;
	
	@Autowired
	private BuildingTypeService buildingTypeService;

	@Autowired
	private FieldService fieldService;
	
	@Autowired
	private SimpMessageSendingOperations messagingTemplate;
	
	@RequestMapping(value = "/adventure/build/{buildingTypeId}", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.ALL_VALUE)
	@ResponseBody
	public ModelAndView build(@PathVariable final BigInteger buildingTypeId)
	{
		ModelAndView modelAndView = new ModelAndView(ViewManager.generateViewName(
				ViewTemplate.bodyOnly, "adventure/builModal"));
		Avatar selectedAvatar = this.avatarService.getCurrentAvatar();
		Field field = this.fieldService.findByPositionXAndPositionYAndAreaId(
				selectedAvatar.getPositionX(), selectedAvatar.getPositionY(),
				selectedAvatar.getAreaId());
		if (field.getBuildingId() == null)
		{
			Building building = new Building();
			building.setBuildingTypeId(buildingTypeId);
			building.setOwnerAccountId(((Account) SecurityContextHolder.getContext()
					.getAuthentication().getPrincipal()).getId());
			building = this.buildingService.save(building);
			field.setBuildingId(building.getId());
			this.fieldService.save(field);
			for (Avatar currentAvatar : this.avatarService.getAvatarsNearAvatar(selectedAvatar))
			{
				for (Account account : WebSocketSessionCache.getInstance()
						.getWebSocketSessionCacheBySubject("/user/adventure/updateavatars")
						.values())
				{
					if (currentAvatar.getId().equals(account.getCurrentAvatarId()))
					{
						this.messagingTemplate.convertAndSendToUser(account.getName(),
								"/adventure/updatemap",
								this.fieldService.getRelativeAdventureMapForAvatar(currentAvatar));
						break;
					}
				}
				
			}
			modelAndView = new ModelAndView("redirect:/building/" + building.getId() + "/modal");
		}
		return modelAndView;
	}
	
	@RequestMapping(value = "/adventure/mapcluster", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<MapTilePojo> getAdventureMap()
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
	public ModelAndView getAvatarModal(@PathVariable final BigInteger avatarId)
	{
		ModelAndView modelAndView = new ModelAndView(ViewManager.generateViewName(
				ViewTemplate.bodyOnly, "adventure/avatarModal"));
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

	@RequestMapping(value = "/adventure/build", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ModelAndView getBuildModal()
	{
		ModelAndView modelAndView = new ModelAndView(ViewManager.generateViewName(
				ViewTemplate.bodyOnly, "adventure/buildModal"));
		Avatar currentAvatar = this.avatarService.getCurrentAvatar();
		Field field = this.fieldService.findByPositionXAndPositionYAndAreaId(
				currentAvatar.getPositionX(), currentAvatar.getPositionY(),
				currentAvatar.getAreaId());
		modelAndView.addObject("buildingTypes",
				this.buildingTypeService.findByRequiredFieldTypeId(field.getFieldTypeId()));
		return modelAndView;
	}

	@RequestMapping(value = "/adventure/currentfield", method = RequestMethod.GET)
	@ResponseBody
	public ModelAndView getCurrentActions()
	{
		ModelAndView modelAndView = new ModelAndView(ViewManager.generateViewName(
				ViewTemplate.bodyOnly, "adventure/currentActions"));
		modelAndView.addObject("currentField", this.adventureMapHelper
				.getCurrentAdventureField(this.avatarService.getCurrentAvatar()));
		return modelAndView;
	}
}
