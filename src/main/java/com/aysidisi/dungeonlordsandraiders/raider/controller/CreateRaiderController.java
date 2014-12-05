
package com.aysidisi.dungeonlordsandraiders.raider.controller;

import java.math.BigInteger;
import java.util.LinkedList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.aysidisi.dungeonlordsandraiders.dungeon.model.DungeonField;
import com.aysidisi.dungeonlordsandraiders.dungeon.service.DungeonFieldService;
import com.aysidisi.dungeonlordsandraiders.dungeon.websocket.DungeonWebsocket;
import com.aysidisi.dungeonlordsandraiders.raider.model.Raider;
import com.aysidisi.dungeonlordsandraiders.raider.service.RaiderService;
import com.aysidisi.plainspringwebapp.web.account.model.Account;
import com.aysidisi.plainspringwebapp.web.core.ViewManager;
import com.aysidisi.plainspringwebapp.web.core.ViewTemplate;

@Controller
public class CreateRaiderController
{
	@Autowired
	private DungeonFieldService dungeonFieldService;

	@Autowired
	private DungeonWebsocket dungeonWebsocket;
	
	@Autowired
	private RaiderService raiderService;

	@RequestMapping(value = "/raider", method = RequestMethod.GET, params = "create")
	public ModelAndView create()
	{
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		Account account = (Account) authentication.getPrincipal();
		Raider storedRaider = this.raiderService.findByOwnerAccoundId(account.getId());
		if (storedRaider != null)
		{
			this.raiderService.delete(storedRaider);
			storedRaider = null;
		}
		if (storedRaider == null)
		{
			Raider raider = new Raider();
			raider.setName(account.getName());
			raider.setOwnerAccountId(account.getId());
			DungeonField dungeonField = this.dungeonFieldService.findByPositionXAndPositionY(1, 1);
			raider.setFieldId(dungeonField.getId());
			raider = this.raiderService.save(raider);
			if (dungeonField.getRaiderIds() == null)
			{
				dungeonField.setRaiderIds(new LinkedList<BigInteger>());
			}
			dungeonField.getRaiderIds().add(raider.getId());
			this.dungeonFieldService.save(dungeonField);
			this.dungeonWebsocket.updateGameMap();

		}
		return new ModelAndView(ViewManager.generateViewName(ViewTemplate.mainTemplate,
				"raider/createRaider"));
	}
}
