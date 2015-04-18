
package com.aysidisi.worldofdayum.avatar.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.aysidisi.plainspringwebapp.web.account.model.Account;
import com.aysidisi.plainspringwebapp.web.account.service.AccountService;
import com.aysidisi.plainspringwebapp.web.core.ViewManager;
import com.aysidisi.plainspringwebapp.web.core.ViewTemplate;
import com.aysidisi.worldofdayum.adventure.websocket.AdventureMapWebsocket;
import com.aysidisi.worldofdayum.avatar.model.Avatar;
import com.aysidisi.worldofdayum.avatar.service.AvatarService;
import com.aysidisi.worldofdayum.field.service.FieldService;

@Controller
public class CreateAvatarController
{
	@Autowired
	private AccountService accountService;
	
	@Autowired
	private AvatarService avatarService;

	@Autowired
	private FieldService dungeonFieldService;
	
	@Autowired
	private AdventureMapWebsocket dungeonWebsocket;

	@RequestMapping(value = "/avatars", method = RequestMethod.GET, params = "create")
	public ModelAndView create()
	{
		return this.initView(new Avatar());
	}

	@RequestMapping(value = "/avatars", method = RequestMethod.POST)
	public ModelAndView save(final Avatar avatar)
	{
		ModelAndView modelAndView;
		if (this.validate(avatar))
		{
			modelAndView = this.initView(new Avatar());
		}
		else
		{
			Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
			Account account = (Account) authentication.getPrincipal();
			avatar.setOwnerAccountId(account.getId());
			avatar.setMainAvatar(this.avatarService.findByOwnerAccountIdAndMainAvatar(
					account.getId(), true) == null);
			Avatar savedAvatar = this.avatarService.save(avatar);
			modelAndView = new ModelAndView("redirect:/avatars/" + savedAvatar.getId());
			account.setCurrentAvatarId(savedAvatar.getId());
			this.accountService.save(account);
		}
		return modelAndView;
	}

	private ModelAndView initView(final Avatar avatar)
	{
		ModelAndView modelAndView = new ModelAndView(ViewManager.generateViewName(
				ViewTemplate.mainTemplate, "avatar/createAvatar"));
		modelAndView.addObject("avatar", avatar);
		return modelAndView;
	}

	private boolean validate(final Avatar avatar)
	{
		boolean errors = false;
		return errors;
	}
}
