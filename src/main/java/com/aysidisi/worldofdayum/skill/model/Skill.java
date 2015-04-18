
package com.aysidisi.worldofdayum.skill.model;

public enum Skill
{
	alchemy("Alchemie", SkillType.working);
	// axes("Äxte", SkillType.fighting),
	// blacksmithing("Schmieden", SkillType.working),
	// blunt("Stumpfe Waffen", SkillType.fighting),
	// boats("Boote", SkillType.working),
	// bow("Bögen", SkillType.fighting),
	// bowyer("Bogenherstellung", SkillType.working),
	// butcher("Schlachten", SkillType.working),
	// carpenter("Schreinern", SkillType.fighting),
	// crossbow("Armbrüste", SkillType.fighting),
	// dagger("Dolche", SkillType.fighting),
	// farming("Ackerbau", SkillType.working),
	// fishing("Fischen", SkillType.working),
	// furriery("Kürschnern", SkillType.working),
	// heavyArmor("Schwere Rüstung", SkillType.fighting),
	// hide("Verstecken", SkillType.working),
	// hunting("Jagen", SkillType.working),
	// husbandry("Viehzucht", SkillType.working),
	// leatherArmor("Lederrüstung", SkillType.fighting),
	// leathercraft("Lederverarbeitung", SkillType.working),
	// lightArmor("Leichte Rüstung", SkillType.fighting),
	// lumbering("Holzfällen", SkillType.working),
	// mining("Bergbau", SkillType.working),
	// picklocking("Schlösser knacken", SkillType.working),
	// seafaring("Seefahren", SkillType.working),
	// shield("Schilde", SkillType.fighting),
	// spying("Spionage", SkillType.working),
	// steal("Stehlen", SkillType.working),
	// stonecutting("Steinmetzen", SkillType.working),
	// sword("Schwerter", SkillType.fighting),
	// tailor("Schneidern", SkillType.working),
	// trainAnimal("Tiere abrichten", SkillType.working),
	// treatPoisen("Heilen: Gifte", SkillType.working),
	// treatWounds("Heilen: Wunden", SkillType.working),
	// twohandedaxes("Zweihandige Äxte", SkillType.fighting),
	// twohandedblunt("Zweihändige Stumpfe Waffen", SkillType.fighting),
	// twohandedsword("Zweihändige Schwerter", SkillType.fighting),
	// unarmed("Waffenlos", SkillType.fighting);

	private String name;
	
	private SkillType skillType;
	
	Skill(final String name, final SkillType skillType)
	{
		this.name = name;
		this.skillType = skillType;
	}
	
	public String getName()
	{
		return this.name;
	}
	
	public SkillType getSkillType()
	{
		return this.skillType;
	}
	
	public void setName(final String name)
	{
		this.name = name;
	}
	
	public void setSkillType(final SkillType skillType)
	{
		this.skillType = skillType;
	}
}
