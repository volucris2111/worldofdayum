
package com.aysidisi.dungeonlordsandraiders.dungeon.controller;

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

import com.aysidisi.dungeonlordsandraiders.dungeon.model.DungeonField;
import com.aysidisi.dungeonlordsandraiders.dungeon.model.DungeonFieldPojo;
import com.aysidisi.dungeonlordsandraiders.dungeon.service.DungeonFieldService;
import com.aysidisi.dungeonlordsandraiders.raider.service.RaiderService;
import com.aysidisi.plainspringwebapp.web.account.model.Account;
import com.aysidisi.plainspringwebapp.web.core.ViewManager;
import com.aysidisi.plainspringwebapp.web.core.ViewTemplate;

@Controller
public class DungeonController
{
	
	@Autowired
	private DungeonFieldService dungeonFieldService;
	
	@Autowired
	private RaiderService raiderService;

	@RequestMapping(value = "/generatedungeon", method = RequestMethod.GET)
	public void generatedungeon()
	{
		this.dungeonFieldService.deletAll();
		for (int x = 0; x <= 10; x++)
		{
			for (int y = 0; y <= 10; y++)
			{
				DungeonField dungeonField = new DungeonField();
				dungeonField.setPositionX(x);
				dungeonField.setPositionY(y);
				if (x == 0 || y == 0 || x == 10 || y == 10)
				{
					dungeonField.setFieldTypeId(2);
				}
				else
				{
					dungeonField.setFieldTypeId(1);
				}
				this.dungeonFieldService.save(dungeonField);
			}
		}
		System.out.println("Dungeon Generated!");

	}

	@RequestMapping(value = "/dungeon/plaindungeon", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<DungeonFieldPojo> getDungeon()
	{
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		Account account = (Account) authentication.getPrincipal();
		return this.dungeonFieldService.getRelativeDungeonMapForRaider(this.raiderService
				.findByOwnerAccoundId(account.getId()));
	}

	@RequestMapping(value = "/dungeon", method = RequestMethod.GET)
	public ModelAndView home()
	{
		return new ModelAndView(ViewManager.generateViewName(ViewTemplate.mainTemplate,
				"dungeon/dungeon"));
	}
}
