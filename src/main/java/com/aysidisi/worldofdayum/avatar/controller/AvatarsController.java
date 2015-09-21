
package com.aysidisi.worldofdayum.avatar.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.aysidisi.plainspringwebapp.web.account.model.Account;
import com.aysidisi.plainspringwebapp.web.core.ViewManager;
import com.aysidisi.plainspringwebapp.web.core.ViewTemplate;
import com.aysidisi.worldofdayum.avatar.model.Avatar;
import com.aysidisi.worldofdayum.avatar.service.AvatarService;

@Controller
public class AvatarsController
{
	
	@Autowired
	private AvatarService avatarService;

	@RequestMapping(value = "/avatars", method = RequestMethod.GET)
	public ModelAndView avatarList()
	{
		ModelAndView modelAndView = ViewManager.generateModelAndView(ViewTemplate.mainTemplate,
				"avatar/avatars");
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		Account account = (Account) authentication.getPrincipal();
		List<Avatar> avatars = this.avatarService.findByOwnerAccoundId(account.getId());
		if (avatars == null || avatars.isEmpty())
		{
			modelAndView = new ModelAndView("redirect:/avatars/?create");
		}
		else
		{
			modelAndView.addObject("avatars", avatars);
		}
		return modelAndView;
	}
}
