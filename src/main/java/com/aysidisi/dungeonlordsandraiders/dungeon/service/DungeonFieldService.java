
package com.aysidisi.dungeonlordsandraiders.dungeon.service;

import java.math.BigInteger;
import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aysidisi.dungeonlordsandraiders.dungeon.dao.DungeonFieldDao;
import com.aysidisi.dungeonlordsandraiders.dungeon.model.DungeonField;
import com.aysidisi.dungeonlordsandraiders.dungeon.model.DungeonFieldPojo;
import com.aysidisi.dungeonlordsandraiders.raider.model.Raider;

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

	public List<DungeonField> findByPositionXBetweenAndPositionYBetween(
			final Integer positionXFrom, final Integer positionXTo, final Integer positionYFrom,
			final Integer positionYTo)
			{
		return this.dungeonFieldDao.findByPositionXBetweenAndPositionYBetween(positionXFrom,
				positionXTo, positionYFrom, positionYTo);
			}
	
	public DungeonField findOne(final BigInteger id)
	{
		return this.dungeonFieldDao.findOne(id);
	}
	
	public List<DungeonFieldPojo> getRelativeDungeonMapForRaider(final Raider raider)
	{
		LinkedList<DungeonFieldPojo> relativeDungeonMap = new LinkedList<DungeonFieldPojo>();
		if (raider != null)
		{
			DungeonField dungeonFieldOfRaider = this.findOne(raider.getFieldId());
			for (DungeonField currentDungeonField : this.findByPositionXBetweenAndPositionYBetween(
					dungeonFieldOfRaider.getPositionX() - 4,
					dungeonFieldOfRaider.getPositionX() + 4,
					dungeonFieldOfRaider.getPositionY() - 4,
					dungeonFieldOfRaider.getPositionY() + 4))
			{
				DungeonFieldPojo dungeonFieldPojo = new DungeonFieldPojo();
				dungeonFieldPojo.setFieldTypeId(currentDungeonField.getFieldTypeId());
				dungeonFieldPojo.setPositionX(currentDungeonField.getPositionX());
				dungeonFieldPojo.setPositionY(currentDungeonField.getPositionY());
				dungeonFieldPojo.setRelativePositionX(currentDungeonField.getPositionX()
						- dungeonFieldOfRaider.getPositionX() + 3);
				dungeonFieldPojo.setRelativePositionY(currentDungeonField.getPositionY()
						- dungeonFieldOfRaider.getPositionY() + 3);
				dungeonFieldPojo.setRaiderIds(currentDungeonField.getRaiderIds());
				relativeDungeonMap.add(dungeonFieldPojo);
			}
		}
		return relativeDungeonMap;
	}

	public void save(final DungeonField gameMapField)
	{
		this.dungeonFieldDao.save(gameMapField);
	}
}
