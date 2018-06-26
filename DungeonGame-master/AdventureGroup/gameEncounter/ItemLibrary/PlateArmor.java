package gameEncounter.ItemLibrary;

import gameEncounter.Equipment;
import gameEncounter.Hero;
import gameEncounter.Item;
import gameEncounter.ModableHeroStats;

public class PlateArmor extends ItemBody{

	
	public PlateArmor() {
		super();
		name="plate armor";
		requiredStrength=17;
		setGoldValue(400);
		stats.getStats()[ModableHeroStats.nameResolveStat("armor")]=12;
		stats.getStats()[ModableHeroStats.nameResolveStat("dodge")]=-1;
	}	
}
