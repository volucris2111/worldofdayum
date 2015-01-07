
package com.aysidisi.worldofdayum.avatar.controller;

import java.math.BigInteger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.aysidisi.plainspringwebapp.web.core.ViewManager;
import com.aysidisi.plainspringwebapp.web.core.ViewTemplate;
import com.aysidisi.worldofdayum.avatar.model.Avatar;
import com.aysidisi.worldofdayum.avatar.model.AvatarView;
import com.aysidisi.worldofdayum.avatar.service.AvatarService;
import com.aysidisi.worldofdayum.avatarclass.service.AvatarClassService;

@Controller
public class AvatarController
{

	@Autowired
	private AvatarClassService avatarClassService;

	@Autowired
	private AvatarService avatarService;

	@RequestMapping(value = "/avatars/{avatarId}", method = RequestMethod.GET)
	public ModelAndView details(@PathVariable final BigInteger avatarId)
	{
		ModelAndView modelAndView = new ModelAndView(ViewManager.generateViewName(
				ViewTemplate.mainTemplate, "avatar/avatar"));
		Avatar avatar = this.avatarService.findOne(avatarId);
		AvatarView avatarView = new AvatarView();
		if (avatar == null)
		{
			modelAndView = new ModelAndView("redirect:/avatars/");
		}
		else
		{
			avatarView.setAvatar(avatar);
			avatarView.setAvatarClass(this.avatarClassService.findById(avatar.getAvatarClassId()));
			modelAndView.addObject("avatarView", avatarView);
		}
		return modelAndView;

	}
}
