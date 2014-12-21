
package com.aysidisi.dungeonlordsandraiders.dungeon.websocket;

import java.math.BigInteger;
import java.util.LinkedList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Controller;

import com.aysidisi.dungeonlordsandraiders.dungeon.model.DungeonField;
import com.aysidisi.dungeonlordsandraiders.dungeon.model.MovementPojo;
import com.aysidisi.dungeonlordsandraiders.dungeon.service.DungeonFieldService;
import com.aysidisi.dungeonlordsandraiders.raider.model.Raider;
import com.aysidisi.dungeonlordsandraiders.raider.service.RaiderService;
import com.aysidisi.plainspringwebapp.config.cache.WebSocketSessionCache;
import com.aysidisi.plainspringwebapp.web.account.model.Account;

@Controller
public class DungeonWebsocket
{
	@Autowired
	private DungeonFieldService dungeonFieldService;
	
	@Autowired
	private SimpMessageSendingOperations messagingTemplate;

	@Autowired
	private RaiderService raiderService;
	
	@MessageMapping("/move/keyboard")
	public void movement(final Integer key, final SimpMessageHeaderAccessor headerAccessor)
	{
		UsernamePasswordAuthenticationToken token = (UsernamePasswordAuthenticationToken) headerAccessor
				.getUser();
		Account account = (Account) token.getPrincipal();
		Raider raider = this.raiderService.findByOwnerAccoundId(account.getId());
		if (raider != null)
		{
			DungeonField dungeonFieldMovedFrom = this.dungeonFieldService.findOne(raider
					.getFieldId());
			DungeonField dungeonFieldMovedTo = null;
			if (key == 38)
			{
				// up
				dungeonFieldMovedTo = this.dungeonFieldService.findByPositionXAndPositionY(
						dungeonFieldMovedFrom.getPositionX(),
						dungeonFieldMovedFrom.getPositionY() - 1);
			}
			else if (key == 40)
			{
				// down
				dungeonFieldMovedTo = this.dungeonFieldService.findByPositionXAndPositionY(
						dungeonFieldMovedFrom.getPositionX(),
						dungeonFieldMovedFrom.getPositionY() + 1);
			}
			else if (key == 37)
			{
				// left
				dungeonFieldMovedTo = this.dungeonFieldService.findByPositionXAndPositionY(
						dungeonFieldMovedFrom.getPositionX() - 1,
						dungeonFieldMovedFrom.getPositionY());
			}
			else if (key == 39)
			{
				// right
				dungeonFieldMovedTo = this.dungeonFieldService.findByPositionXAndPositionY(
						dungeonFieldMovedFrom.getPositionX() + 1,
						dungeonFieldMovedFrom.getPositionY());
			}
			if (dungeonFieldMovedTo != null && dungeonFieldMovedTo.getFieldTypeId() != 2)
			{
				raider.setFieldId(dungeonFieldMovedTo.getId());
				dungeonFieldMovedFrom.getRaiderIds().remove(raider.getId());
				if (dungeonFieldMovedTo.getRaiderIds() == null)
				{
					dungeonFieldMovedTo.setRaiderIds(new LinkedList<BigInteger>());
				}
				dungeonFieldMovedTo.getRaiderIds().add(raider.getId());
				this.raiderService.save(raider);
				this.dungeonFieldService.save(dungeonFieldMovedTo);
				this.dungeonFieldService.save(dungeonFieldMovedFrom);
				this.updateGameMap();
			}
		}
	}
	
	@MessageMapping("/move/mouse")
	public void movement(final MovementPojo movement, final SimpMessageHeaderAccessor headerAccessor)
	{
		UsernamePasswordAuthenticationToken token = (UsernamePasswordAuthenticationToken) headerAccessor
				.getUser();
		Account account = (Account) token.getPrincipal();
		Raider raider = this.raiderService.findByOwnerAccoundId(account.getId());
		DungeonField dungeonFieldMovedFrom = this.dungeonFieldService.findOne(raider.getFieldId());
		DungeonField dungeonFieldMovedTo = this.dungeonFieldService.findByPositionXAndPositionY(
				dungeonFieldMovedFrom.getPositionX() + (movement.getX() - 3),
				dungeonFieldMovedFrom.getPositionY() + (movement.getY() - 3));
		if (dungeonFieldMovedTo != null && dungeonFieldMovedTo.getFieldTypeId() != 2)
		{
			raider.setFieldId(dungeonFieldMovedTo.getId());
			dungeonFieldMovedFrom.getRaiderIds().remove(raider.getId());
			if (dungeonFieldMovedTo.getRaiderIds() == null)
			{
				dungeonFieldMovedTo.setRaiderIds(new LinkedList<BigInteger>());
			}
			dungeonFieldMovedTo.getRaiderIds().add(raider.getId());
			this.raiderService.save(raider);
			this.dungeonFieldService.save(dungeonFieldMovedTo);
			this.dungeonFieldService.save(dungeonFieldMovedFrom);
			this.updateGameMap();
		}
	}

	public void updateGameMap()
	{
		for (Account account : WebSocketSessionCache.getInstance()
				.getWebSocketSessionCacheBySubject("/user/dungeon/updatedungeon").values())
		{
			this.messagingTemplate.convertAndSendToUser(account.getName(),
					"/dungeon/updatedungeon", this.dungeonFieldService
							.getRelativeDungeonMapForRaider(this.raiderService
									.findByOwnerAccoundId(account.getId())));
		}
		
	}
}
