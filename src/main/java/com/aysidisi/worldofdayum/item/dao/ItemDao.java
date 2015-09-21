
package com.aysidisi.worldofdayum.item.dao;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.aysidisi.worldofdayum.item.model.Item;

public interface ItemDao extends MongoRepository<Item, ObjectId>
{

}
