
package com.aysidisi.worldofdayum.item.model;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

public class Item
{
	@Id
	private ObjectId id;

	private ItemType itemType;
	
	private String name;
	
	private int stackSize;
	
	private int weight;
	
	public ObjectId getId()
	{
		return this.id;
	}
	
	public ItemType getItemType()
	{
		return this.itemType;
	}
	
	public String getName()
	{
		return this.name;
	}
	
	public int getStackSize()
	{
		return this.stackSize;
	}
	
	public int getWeight()
	{
		return this.weight;
	}
	
	public void setId(final ObjectId id)
	{
		this.id = id;
	}
	
	public void setItemType(final ItemType itemType)
	{
		this.itemType = itemType;
	}

	public void setName(final String name)
	{
		this.name = name;
	}

	public void setStackSize(final int stackSize)
	{
		this.stackSize = stackSize;
	}

	public void setWeight(final int weight)
	{
		this.weight = weight;
	}
}
