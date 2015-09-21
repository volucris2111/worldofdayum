
package com.aysidisi.worldofdayum.building.controller;

import org.bson.types.ObjectId;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.aysidisi.plainspringwebapp.web.account.model.Account;
import com.aysidisi.plainspringwebapp.web.account.service.AccountService;
import com.aysidisi.plainspringwebapp.web.core.ViewManager;
import com.aysidisi.plainspringwebapp.web.core.ViewTemplate;
import com.aysidisi.worldofdayum.avatar.service.AvatarService;
import com.aysidisi.worldofdayum.building.model.Building;
import com.aysidisi.worldofdayum.building.model.BuildingView;
import com.aysidisi.worldofdayum.building.service.BuildingService;
import com.aysidisi.worldofdayum.buildingtype.service.BuildingTypeService;
import com.aysidisi.worldofdayum.field.service.FieldService;
import com.aysidisi.worldofdayum.fieldtype.service.FieldTypeService;

@Controller
public class BuildingController
{
	@Autowired
	private AccountService accountService;

	@Autowired
	private AvatarService avatarService;

	@Autowired
	private BuildingService buildingService;
	
	@Autowired
	private BuildingTypeService buildingTypeService;
	
	@Autowired
	private FieldService fieldService;

	@Autowired
	private FieldTypeService fieldTypeService;

	@RequestMapping(value = "/building/{buildingId}/modal", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ModelAndView getBuildingModal(@PathVariable final ObjectId buildingId)
	{
		ModelAndView modelAndView = ViewManager.generateModelAndView(ViewTemplate.bodyOnly,
				"building/building");
		Account account = (Account) SecurityContextHolder.getContext().getAuthentication()
				.getPrincipal();
		Building building = this.buildingService.findOne(buildingId);
		if (building.getOwnerAccountId().equals(account.getId()))
		{
			modelAndView = ViewManager.generateModelAndView(ViewTemplate.bodyOnly,
					"building/buildingOwner");
		}
		this.initView(buildingId, modelAndView, account, building);
		return modelAndView;
	}

	private void initView(final ObjectId buildingId, final ModelAndView modelAndView,
			final Account account, final Building building)
	{
		BuildingView buildingView = new BuildingView();
		buildingView.setBuilding(building);
		buildingView
				.setBuildingType(this.buildingTypeService.findById(building.getBuildingTypeId()));
		buildingView.setField(this.fieldService.findByBuildingId(buildingId));
		buildingView.setFieldType(
				this.fieldTypeService.findById(buildingView.getField().getFieldTypeId()));

		buildingView.setOwnerAvatar(this.avatarService.findByOwnerAccountIdAndMainAvatar(
				this.accountService.findOne(building.getOwnerAccountId()).getId(), Boolean.TRUE));
		modelAndView.addObject("buildingView", buildingView);
	}

}
