package gameEncounter.ItemLibrary;

import gameEncounter.Equipment;
import gameEncounter.Hero;
import gameEncounter.Item;
import gameEncounter.ModableHeroStats;

public class ShortSword extends ItemHand1{

	public ShortSword() {
		super();
		name="short sword";
		stats.getStats()[ModableHeroStats.nameResolveStat("attack skill")]=3;
	}

}
