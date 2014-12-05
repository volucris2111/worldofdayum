
package com.aysidisi.dungeonlordsandraiders.dungeon.service;

import java.math.BigInteger;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aysidisi.dungeonlordsandraiders.dungeon.dao.DungeonFieldDao;
import com.aysidisi.dungeonlordsandraiders.dungeon.model.DungeonField;

@Service
public class DungeonFieldService
{
	@Autowired
	private DungeonFieldDao dungeonFieldDao;

	public void deletAll()
	{
		this.dungeonFieldDao.deleteAll();
	}

	public List<DungeonField> findAll()
	{
		return this.dungeonFieldDao.findAll();
	}
	
	public DungeonField findByPositionXAndPositionY(final Integer positionX, final Integer positionY)
	{
		return this.dungeonFieldDao.findByPositionXAndPositionY(positionX, positionY);
	}
	
	public DungeonField findOne(final BigInteger id)
	{
		return this.dungeonFieldDao.findOne(id);
	}
	
	public void save(final DungeonField gameMapField)
	{
		this.dungeonFieldDao.save(gameMapField);
	}
}
