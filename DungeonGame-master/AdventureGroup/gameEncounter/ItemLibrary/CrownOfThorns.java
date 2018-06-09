package gameEncounter.ItemLibrary;

import gameEncounter.Equipment;
import gameEncounter.Hero;
import gameEncounter.Item;
import gameEncounter.ModableHeroStats;

public class CrownOfThorns extends ItemHead{

	
	public CrownOfThorns() {
		super();
		name="crown of thorns";
		stats.getStats()[ModableHeroStats.nameResolveStat("armor")]=2;
		stats.getStats()[ModableHeroStats.nameResolveStat("thorns")]=5;
	}

}
