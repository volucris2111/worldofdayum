
package com.aysidisi.worldofdayum.adventure.controller.helper;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.aysidisi.worldofdayum.adventure.model.AdventureField;
import com.aysidisi.worldofdayum.avatar.model.Avatar;
import com.aysidisi.worldofdayum.avatar.service.AvatarService;
import com.aysidisi.worldofdayum.building.service.BuildingService;
import com.aysidisi.worldofdayum.field.service.FieldService;
import com.aysidisi.worldofdayum.fieldtype.service.FieldTypeService;

@Component
public class AdventureMapHelper
{

	@Autowired
	private AvatarService avatarService;
	
	@Autowired
	private BuildingService buildingService;
	
	@Autowired
	private FieldService fieldService;

	@Autowired
	private FieldTypeService fieldTypeService;
	
	public AdventureField getCurrentAdventureField(final Avatar avatar)
	{
		AdventureField adventureField = new AdventureField();
		List<Avatar> avatarsOnField = this.avatarService
				.findByPositionXBetweenAndPositionYBetweenAndAreaId(avatar.getPositionX() - 1,
						avatar.getPositionX() + 1, avatar.getPositionY() - 1,
						avatar.getPositionY() + 1, avatar.getAreaId());
		List<Avatar> removeFromList = new LinkedList<Avatar>();
		for (Avatar currentAvatar : avatarsOnField)
		{
			if (currentAvatar.getOwnerAccountId().equals(avatar.getOwnerAccountId()))
			{
				removeFromList.add(currentAvatar);
			}
		}
		avatarsOnField.removeAll(removeFromList);
		adventureField.setAvatars(avatarsOnField);
		
		adventureField.setField(this.fieldService.findByPositionXAndPositionYAndAreaId(
				avatar.getPositionX(), avatar.getPositionY(), avatar.getAreaId()));
		adventureField.setFieldType(
				this.fieldTypeService.findById(adventureField.getField().getFieldTypeId()));
		if (adventureField.getField().getBuildingId() != null)
		{
			adventureField.setBuilding(
					this.buildingService.findOne(adventureField.getField().getBuildingId()));
		}
		return adventureField;
	}

}
