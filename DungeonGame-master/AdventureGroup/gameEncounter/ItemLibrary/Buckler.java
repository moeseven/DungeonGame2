package gameEncounter.ItemLibrary;

import gameEncounter.Equipment;
import gameEncounter.Hero;
import gameEncounter.Item;
import gameEncounter.ModableHeroStats;

public class Buckler extends ItemHand2{

	
	public Buckler() {
		super();
		name="buckler";
		setGoldValue(120);
		stats.getStats()[ModableHeroStats.nameResolveStat("block")]=8;
	}


}
