
package com.aysidisi.worldofdayum.ability.model;

import java.util.List;
import java.util.Map;

import org.bson.types.ObjectId;

import com.aysidisi.worldofdayum.buildingtype.model.BuildingType;

public class CraftAbility extends Ability
{
	private List<BuildingType> dependentBuldingTypes;
	
	private Map<ObjectId, Integer> producedItems;

	private Map<ObjectId, Integer> requiredItems;
	
	public List<BuildingType> getDependentBuldingTypes()
	{
		return this.dependentBuldingTypes;
	}
	
	public Map<ObjectId, Integer> getProducedItems()
	{
		return this.producedItems;
	}

	public Map<ObjectId, Integer> getRequiredItems()
	{
		return this.requiredItems;
	}

	public void setDependentBuldingTypes(final List<BuildingType> dependentBuldingTypes)
	{
		this.dependentBuldingTypes = dependentBuldingTypes;
	}

	public void setProducedItems(final Map<ObjectId, Integer> producedItems)
	{
		this.producedItems = producedItems;
	}
	
	public void setRequiredItems(final Map<ObjectId, Integer> requiredItems)
	{
		this.requiredItems = requiredItems;
	}
}
