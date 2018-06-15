package gameEncounter.ItemLibrary;

import gameEncounter.Equipment;
import gameEncounter.Hero;
import gameEncounter.Item;
import gameEncounter.ModableHeroStats;

public class ArmorThinLeather extends ItemBody{

	
	public ArmorThinLeather() {
		super();
		name="thin leather";
		stats.getStats()[ModableHeroStats.nameResolveStat("armor")]=1;
	}	
}
