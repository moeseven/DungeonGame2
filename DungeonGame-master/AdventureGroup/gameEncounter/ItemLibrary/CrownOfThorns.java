package gameEncounter.ItemLibrary;

import gameEncounter.Equipment;
import gameEncounter.Hero;
import gameEncounter.Item;
import gameEncounter.ModableHeroStats;

public class CrownOfThorns extends ItemHead{

	
	public CrownOfThorns() {
		super();
		name="crown of thorns";
		setGoldValue(300);
		stats.getStats()[ModableHeroStats.nameResolveStat("armor")]=1;
		stats.getStats()[ModableHeroStats.nameResolveStat("thorns")]=10;
	}

}
