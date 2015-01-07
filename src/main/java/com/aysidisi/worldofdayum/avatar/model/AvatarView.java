
package com.aysidisi.worldofdayum.avatar.model;

import com.aysidisi.worldofdayum.avatarclass.model.AvatarClass;

public class AvatarView
{
	private Avatar avatar;
	
	private AvatarClass avatarClass;
	
	public Avatar getAvatar()
	{
		return this.avatar;
	}
	
	public AvatarClass getAvatarClass()
	{
		return this.avatarClass;
	}
	
	public void setAvatar(final Avatar avatar)
	{
		this.avatar = avatar;
	}
	
	public void setAvatarClass(final AvatarClass avatarClass)
	{
		this.avatarClass = avatarClass;
	}
}
