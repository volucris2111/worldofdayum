
package com.aysidisi.worldofdayum.avatar.controller;

import java.util.LinkedList;
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
import com.aysidisi.worldofdayum.avatar.model.AvatarView;
import com.aysidisi.worldofdayum.avatar.service.AvatarService;
import com.aysidisi.worldofdayum.avatarclass.service.AvatarClassService;

@Controller
public class AvatarsController
{
	@Autowired
	private AvatarClassService avatarClassService;

	@Autowired
	private AvatarService avatarService;
	
	@RequestMapping(value = "/avatars", method = RequestMethod.GET)
	public ModelAndView avatarList()
	{
		ModelAndView modelAndView = new ModelAndView(ViewManager.generateViewName(
				ViewTemplate.mainTemplate, "avatar/avatars"));
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		Account account = (Account) authentication.getPrincipal();
		List<Avatar> avatars = this.avatarService.findByOwnerAccoundId(account.getId());
		LinkedList<AvatarView> avatarViews = new LinkedList<AvatarView>();
		if (avatars == null || avatars.isEmpty())
		{
			modelAndView = new ModelAndView("redirect:/avatars/?create");
		}
		else
		{
			for (Avatar currentAvatar : avatars)
			{
				AvatarView avatarView = new AvatarView();
				avatarView.setAvatar(currentAvatar);
				avatarView.setAvatarClass(this.avatarClassService.findById(currentAvatar
						.getAvatarClassId()));
				avatarViews.add(avatarView);
			}
		}
		modelAndView.addObject("avatarViews", avatarViews);
		return modelAndView;
	}
}
