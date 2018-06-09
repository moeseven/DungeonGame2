package gameEncounter.ItemLibrary;

import gameEncounter.Equipment;
import gameEncounter.Hero;
import gameEncounter.Item;
import gameEncounter.ModableHeroStats;

public class HeavySword extends ItemBiHand{

	public HeavySword() {
		super();
		name="heavy sword";
		stats.getStats()[ModableHeroStats.nameResolveStat("block")]=-2;
		stats.getStats()[ModableHeroStats.nameResolveStat("attack skill")]=9;
	}
}
