
package com.aysidisi.worldofdayum.item.service;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aysidisi.worldofdayum.item.dao.ItemDao;
import com.aysidisi.worldofdayum.item.model.Item;

@Service
public class ItemService
{
	@Autowired
	private ItemDao itemDao;

	public Item findOne(final ObjectId itemId)
	{
		return this.itemDao.findOne(itemId);
	}
	
	public List<Item> getItemListSortedByNameAndItemType()
	{
		List<Item> sortedItems = this.itemDao.findAll();
		sortedItems.sort((e1, e2) -> e1.getName().compareTo(e2.getName()));
		return sortedItems;
	}

	public void save(final Item item)
	{
		this.itemDao.save(item);
		
	}
}
