
package com.aysidisi.dungeonlordsandraiders.dungeon.dao;

import java.math.BigInteger;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.aysidisi.dungeonlordsandraiders.dungeon.model.DungeonField;

@Repository
public interface DungeonFieldDao extends MongoRepository<DungeonField, BigInteger>
{
	public DungeonField findByPositionXAndPositionY(Integer positionX, Integer positionY);
}
