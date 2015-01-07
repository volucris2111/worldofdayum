
package com.aysidisi.worldofdayum.avatar.service;

import java.math.BigInteger;
import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aysidisi.worldofdayum.avatar.dao.AvatarDao;
import com.aysidisi.worldofdayum.avatar.model.Avatar;
import com.aysidisi.worldofdayum.avatar.model.AvatarPojo;

@Service
public class AvatarService
{
	@Autowired
	private AvatarDao avatarDao;

	public void delete(final Avatar avatar)
	{
		this.avatarDao.delete(avatar);
	}
	
	public List<Avatar> findByOwnerAccoundId(final BigInteger ownerAccountId)
	{
		return this.avatarDao.findByOwnerAccountId(ownerAccountId);
	}

	public List<Avatar> findByPositionXBetweenAndPositionYBetweenAndAreaId(
			final Integer positionXFrom, final Integer positionXTo, final Integer positionYFrom,
			final Integer positionYTo, final Integer areaId)
	{
		return this.avatarDao.findByPositionXBetweenAndPositionYBetweenAndAreaId(positionXFrom,
				positionXTo, positionYFrom, positionYTo, areaId);
	}

	public Avatar findOne(final BigInteger avatarId)
	{
		return this.avatarDao.findOne(avatarId);
	}
	
	public List<AvatarPojo> getAvatarPojosNearAvatar(final Avatar avatar)
	{
		LinkedList<AvatarPojo> relativeAdventureMap = new LinkedList<AvatarPojo>();
		if (avatar != null)
		{
			for (Avatar currentAvatar : this.getAvatarsNearAvatar(avatar))
			{
				AvatarPojo avatarPojo = new AvatarPojo();
				avatarPojo.setPositionX(currentAvatar.getPositionX());
				avatarPojo.setPositionY(currentAvatar.getPositionY());
				avatarPojo.setSheetPositionX(0);
				avatarPojo.setSheetPositionY(0);
				avatarPojo.setRelativePositionX(currentAvatar.getPositionX()
						- avatar.getPositionX() + 3);
				avatarPojo.setRelativePositionY(currentAvatar.getPositionY()
						- avatar.getPositionY() + 3);
				avatarPojo.setName(currentAvatar.getName());
				relativeAdventureMap.add(avatarPojo);
			}
		}
		return relativeAdventureMap;
	}
	
	public List<Avatar> getAvatarsNearAvatar(final Avatar avatar)
	{
		return this.findByPositionXBetweenAndPositionYBetweenAndAreaId(avatar.getPositionX() - 4,
				avatar.getPositionX() + 4, avatar.getPositionY() - 4, avatar.getPositionY() + 4,
				avatar.getAreaId());
	}

	public Avatar save(final Avatar avatar)
	{
		return this.avatarDao.save(avatar);
	}
	
}
