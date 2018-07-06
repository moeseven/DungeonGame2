package gameEncounter.ItemLibrary;

import gameEncounter.Equipment;
import gameEncounter.Hero;
import gameEncounter.Item;
import gameEncounter.ModableHeroStats;

public class Speer extends ItemBiHand{

	public Speer() {
		super();
		name="speer";
		setGoldValue(300);
		this.baseDamage=25;
		this.damageRange=19;
		this.facStr=0.55;
		this.weaponRange=3;
		stats.getStats()[ModableHeroStats.nameResolveStat("attack")]=-6;
	}

}
