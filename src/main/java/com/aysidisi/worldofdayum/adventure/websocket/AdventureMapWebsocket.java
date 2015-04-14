
package com.aysidisi.worldofdayum.adventure.websocket;

import java.math.BigInteger;
import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Controller;

import com.aysidisi.plainspringwebapp.config.cache.WebSocketSessionCache;
import com.aysidisi.plainspringwebapp.web.account.model.Account;
import com.aysidisi.worldofdayum.adventure.model.MovementPojo;
import com.aysidisi.worldofdayum.avatar.model.Avatar;
import com.aysidisi.worldofdayum.avatar.service.AvatarService;
import com.aysidisi.worldofdayum.field.model.Field;
import com.aysidisi.worldofdayum.field.service.FieldService;
import com.aysidisi.worldofdayum.fieldtype.service.FieldTypeService;

@Controller
public class AdventureMapWebsocket
{
	@Autowired
	private AvatarService avatarService;
	
	@Autowired
	private FieldService fieldService;

	@Autowired
	private FieldTypeService fieldTypeService;
	
	@Autowired
	private SimpMessageSendingOperations messagingTemplate;

	@MessageMapping("/move/keyboard")
	public void movement(final Integer key, final SimpMessageHeaderAccessor headerAccessor)
	{
		UsernamePasswordAuthenticationToken token = (UsernamePasswordAuthenticationToken) headerAccessor
				.getUser();
		Account account = (Account) token.getPrincipal();
		HashSet<BigInteger> avatars = new HashSet<BigInteger>();
		Avatar avatar = this.avatarService.findOne(account.getCurrentAvatarId());
		if (avatar != null)
		{
			Field dungeonFieldMovedTo = null;
			if (key == 38)
			{
				// up
				dungeonFieldMovedTo = this.fieldService.findByPositionXAndPositionYAndAreaId(
						avatar.getPositionX(), avatar.getPositionY() - 1, avatar.getAreaId());
			}
			else if (key == 40)
			{
				// down
				dungeonFieldMovedTo = this.fieldService.findByPositionXAndPositionYAndAreaId(
						avatar.getPositionX(), avatar.getPositionY() + 1, avatar.getAreaId());
			}
			else if (key == 37)
			{
				// left
				dungeonFieldMovedTo = this.fieldService.findByPositionXAndPositionYAndAreaId(
						avatar.getPositionX() - 1, avatar.getPositionY(), avatar.getAreaId());
			}
			else if (key == 39)
			{
				// right
				dungeonFieldMovedTo = this.fieldService.findByPositionXAndPositionYAndAreaId(
						avatar.getPositionX() + 1, avatar.getPositionY(), avatar.getAreaId());
			}
			if (dungeonFieldMovedTo != null
					&& this.fieldTypeService.findById(dungeonFieldMovedTo.getFieldTypeId())
					.getWalkable())
			{
				for (Avatar currentAvatar : this.avatarService.getAvatarsNearAvatar(avatar))
				{
					avatars.add(currentAvatar.getId());
				}
				avatar.setPositionX(dungeonFieldMovedTo.getPositionX());
				avatar.setPositionY(dungeonFieldMovedTo.getPositionY());
				this.avatarService.save(avatar);
				for (Avatar currentAvatar : this.avatarService.getAvatarsNearAvatar(avatar))
				{
					avatars.add(currentAvatar.getId());
				}
				this.updateMap(account, avatar);
				this.updateAvatars(avatars);
			}
		}
	}

	@MessageMapping("/move/mouse")
	public void movement(final MovementPojo movement, final SimpMessageHeaderAccessor headerAccessor)
	{
		UsernamePasswordAuthenticationToken token = (UsernamePasswordAuthenticationToken) headerAccessor
				.getUser();
		Account account = (Account) token.getPrincipal();
		Avatar avatar = this.avatarService.findOne(account.getCurrentAvatarId());
		HashSet<BigInteger> avatars = new HashSet<BigInteger>();
		Field dungeonFieldMovedTo = this.fieldService.findByPositionXAndPositionYAndAreaId(
				avatar.getPositionX() + (movement.getX() - 3),
				avatar.getPositionY() + (movement.getY() - 3), avatar.getAreaId());
		if (dungeonFieldMovedTo != null
				&& this.fieldTypeService.findById(dungeonFieldMovedTo.getFieldTypeId())
				.getWalkable())
		{
			for (Avatar currentAvatar : this.avatarService.getAvatarsNearAvatar(avatar))
			{
				avatars.add(currentAvatar.getId());
			}
			avatar.setPositionX(dungeonFieldMovedTo.getPositionX());
			avatar.setPositionY(dungeonFieldMovedTo.getPositionY());
			this.avatarService.save(avatar);
			for (Avatar currentAvatar : this.avatarService.getAvatarsNearAvatar(avatar))
			{
				avatars.add(currentAvatar.getId());
			}
			this.updateMap(account, avatar);
			this.updateAvatars(avatars);
		}
	}

	public void updateAvatars(final HashSet<BigInteger> avatarIdsToUpdate)
	{
		for (Account account : WebSocketSessionCache.getInstance()
				.getWebSocketSessionCacheBySubject("/user/adventure/updateavatars").values())
		{
			if (avatarIdsToUpdate.contains(account.getCurrentAvatarId()))
			{
				this.messagingTemplate.convertAndSendToUser(account.getName(),
						"/adventure/updateavatars", this.avatarService
								.getAvatarPojosNearAvatar(this.avatarService.findOne(account
										.getCurrentAvatarId())));
			}
		}
	}
	
	public void updateMap(final Account account, final Avatar avatar)
	{
		this.messagingTemplate.convertAndSendToUser(account.getName(), "/adventure/updatemap",
				this.fieldService.getRelativeAdventureMapForAvatar(avatar));
	}
}
