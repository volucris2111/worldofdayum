
package com.aysidisi.worldofdayum.avatarclass.dao;

import java.math.BigInteger;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.aysidisi.worldofdayum.avatarclass.model.AvatarClass;

@Repository
public interface AvatarClassDao extends MongoRepository<AvatarClass, BigInteger>
{
	@Override
	List<AvatarClass> findAll();

	List<AvatarClass> findByStarterClass(Boolean starterClass);
}
