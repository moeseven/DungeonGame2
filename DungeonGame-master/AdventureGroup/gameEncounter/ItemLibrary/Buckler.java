package gameEncounter.ItemLibrary;

import gameEncounter.Equipment;
import gameEncounter.Hero;
import gameEncounter.Item;
import gameEncounter.ModableHeroStats;

public class Buckler extends ItemHand2{

	
	public Buckler() {
		super();
		name="buckler";
		stats.getStats()[ModableHeroStats.nameResolveStat("block")]=8;
		stats.getStats()[ModableHeroStats.nameResolveStat("armor")]=2;
	}


}
