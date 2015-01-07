
package com.aysidisi.worldofdayum.field.dao;

import java.math.BigInteger;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.aysidisi.worldofdayum.field.model.Field;

@Repository
public interface FieldDao extends MongoRepository<Field, BigInteger>
{
	public Field findByPositionXAndPositionYAndAreaId(Integer positionX, Integer positionY,
			Integer areaId);

	public List<Field> findByPositionXBetweenAndPositionYBetweenAndAreaId(
			final Integer positionXFrom, final Integer positionXTo, final Integer positionYFrom,
			final Integer positionYTo, Integer areaId);
}
