
package com.aysidisi.worldofdayum.ability.dao;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.aysidisi.worldofdayum.ability.model.Ability;

public interface AbilityDao extends MongoRepository<Ability, ObjectId>
{

}
