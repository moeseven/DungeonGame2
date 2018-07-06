package gameEncounter.ItemLibrary;

import gameEncounter.Equipment;
import gameEncounter.Hero;
import gameEncounter.Item;
import gameEncounter.ModableHeroStats;

public class Helmet extends ItemHead{

	
	public Helmet() {
		super();
		name="helmet";
		setGoldValue(230);
		stats.getStats()[ModableHeroStats.nameResolveStat("armor")]=2;
	}

}
