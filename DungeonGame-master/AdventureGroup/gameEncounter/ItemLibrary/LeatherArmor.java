package gameEncounter.ItemLibrary;

import gameEncounter.Equipment;
import gameEncounter.Hero;
import gameEncounter.Item;
import gameEncounter.ModableHeroStats;

public class LeatherArmor extends ItemBody{

	
	public LeatherArmor() {
		super();
		name="thin leather";
		setGoldValue(255);
		stats.getStats()[ModableHeroStats.nameResolveStat("armor")]=3;
	}	
}
