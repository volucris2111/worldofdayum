
package com.aysidisi.worldofdayum.avatar.dao;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.aysidisi.worldofdayum.avatar.model.Avatar;

public interface AvatarDao extends MongoRepository<Avatar, ObjectId>
{
	@Override
	List<Avatar> findAll();
	
	List<Avatar> findByOwnerAccountId(ObjectId ownerAccountId);
	
	Avatar findByOwnerAccountIdAndMainAvatar(ObjectId ownerAccountId, Boolean mainAvatar);
	
	List<Avatar> findByPositionXBetweenAndPositionYBetweenAndAreaId(final Integer positionXFrom,
			final Integer positionXTo, final Integer positionYFrom, final Integer positionYTo,
			Integer areaId);
}
