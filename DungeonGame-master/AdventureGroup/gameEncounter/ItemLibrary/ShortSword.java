package gameEncounter.ItemLibrary;

import gameEncounter.Equipment;
import gameEncounter.Hero;
import gameEncounter.Item;
import gameEncounter.ModableHeroStats;

public class ShortSword extends ItemHand1{

	public ShortSword() {
		super();
		name="short sword";
		setGoldValue(150);
		this.baseDamage=10;
		this.damageRange=10;
		this.facStr=0.85;
		this.weaponRange=2;
		stats.getStats()[ModableHeroStats.nameResolveStat("accuracy")]=1;
	}

}
