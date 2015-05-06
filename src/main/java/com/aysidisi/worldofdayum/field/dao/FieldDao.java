
package com.aysidisi.worldofdayum.field.dao;

import java.math.BigInteger;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.aysidisi.worldofdayum.field.model.Field;

public interface FieldDao extends MongoRepository<Field, BigInteger>
{
	Field findByBuildingId(BigInteger buildingId);
	
	Field findByPositionXAndPositionYAndAreaId(Integer positionX, Integer positionY, Integer areaId);

	List<Field> findByPositionXBetweenAndPositionYBetweenAndAreaId(final Integer positionXFrom,
			final Integer positionXTo, final Integer positionYFrom, final Integer positionYTo,
			Integer areaId);

}
