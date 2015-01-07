
package com.aysidisi.worldofdayum.avatarclass.service;

import java.math.BigInteger;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aysidisi.worldofdayum.avatarclass.dao.AvatarClassDao;
import com.aysidisi.worldofdayum.avatarclass.model.AvatarClass;

@Service
public class AvatarClassService
{
	@Autowired
	private AvatarClassDao avatarClassDao;

	public List<AvatarClass> findAll()
	{
		return this.avatarClassDao.findAll();
	}
	
	public AvatarClass findById(final BigInteger avatarClassId)
	{
		return this.avatarClassDao.findOne(avatarClassId);
	}

	public List<AvatarClass> findByStarterClass(final Boolean starterClass)
	{
		return this.avatarClassDao.findByStarterClass(starterClass);
	}
	
	public AvatarClass save(final AvatarClass avatarClass)
	{
		return this.avatarClassDao.save(avatarClass);
	}
}
