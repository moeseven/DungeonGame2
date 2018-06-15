package gameEncounter.ItemLibrary;

import gameEncounter.Equipment;
import gameEncounter.Hero;
import gameEncounter.Item;
import gameEncounter.ModableHeroStats;

public class HeavySword extends ItemBiHand{

	public HeavySword() {
		super();
		name="heavy sword";
		this.baseDamage=15;
		this.damageRange=12;
		this.facStr=0.1;
		this.weaponRange=3;
		this.requiredStrength=20;
		stats.getStats()[ModableHeroStats.nameResolveStat("dexterity")]=-4;
	}
}
