
package com.aysidisi.worldofdayum.avatar.controller;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.aysidisi.plainspringwebapp.web.account.model.Account;
import com.aysidisi.plainspringwebapp.web.account.service.AccountService;
import com.aysidisi.worldofdayum.avatar.model.Avatar;
import com.aysidisi.worldofdayum.avatar.service.AvatarService;

@Controller
public class AvatarSelectController
{
	@Autowired
	private AccountService accountService;
	
	@Autowired
	private AvatarService avatarService;

	@RequestMapping(value = "/avatars/select/{avatarId}", method = RequestMethod.GET)
	public ModelAndView select(@PathVariable final ObjectId avatarId)
	{
		ModelAndView modelAndView;
		Avatar avatar = this.avatarService.findOne(avatarId);
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		Account account = (Account) authentication.getPrincipal();
		if (!avatar.getOwnerAccountId().equals(account.getId()))
		{
			modelAndView = new ModelAndView("redirect:/avatars/");
		}
		else
		{
			account.setCurrentAvatarId(avatarId);
			this.accountService.save(account);
			modelAndView = new ModelAndView("redirect:/adventure/");
		}
		return modelAndView;
	}
}
