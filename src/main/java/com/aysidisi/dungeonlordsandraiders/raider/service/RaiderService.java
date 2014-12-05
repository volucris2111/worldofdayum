
package com.aysidisi.dungeonlordsandraiders.raider.service;

import java.math.BigInteger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aysidisi.dungeonlordsandraiders.raider.dao.RaiderDao;
import com.aysidisi.dungeonlordsandraiders.raider.model.Raider;

@Service
public class RaiderService
{
	@Autowired
	private RaiderDao raiderDao;

	public void delete(final Raider raider)
	{
		this.raiderDao.delete(raider);
	}
	
	public Raider findByOwnerAccoundId(final BigInteger ownerAccountId)
	{
		return this.raiderDao.findByOwnerAccountId(ownerAccountId);
	}

	public Raider save(final Raider raider)
	{
		return this.raiderDao.save(raider);
	}
}
