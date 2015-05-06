
package com.aysidisi.worldofdayum.avatar.dao;

import java.math.BigInteger;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.aysidisi.worldofdayum.avatar.model.Avatar;

public interface AvatarDao extends MongoRepository<Avatar, BigInteger>
{
	@Override
	List<Avatar> findAll();

	List<Avatar> findByOwnerAccountId(BigInteger ownerAccountId);

	Avatar findByOwnerAccountIdAndMainAvatar(BigInteger ownerAccountId, Boolean mainAvatar);

	List<Avatar> findByPositionXBetweenAndPositionYBetweenAndAreaId(final Integer positionXFrom,
			final Integer positionXTo, final Integer positionYFrom, final Integer positionYTo,
			Integer areaId);
}
