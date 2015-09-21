
package com.aysidisi.worldofdayum.skill.dao;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.aysidisi.worldofdayum.skill.model.Skill;

public interface SkillDao extends MongoRepository<Skill, ObjectId>
{

}
