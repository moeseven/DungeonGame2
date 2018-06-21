package gameEncounter.ItemLibrary;

import gameEncounter.Equipment;
import gameEncounter.Hero;
import gameEncounter.Item;
import gameEncounter.ModableHeroStats;

public class HeavySword extends ItemBiHand{

	public HeavySword() {
		super();
		name="heavy sword";
		setGoldValue(175);
		this.baseDamage=18;
		this.damageRange=15;
		this.facStr=0.1;
		this.weaponRange=3;
		this.requiredStrength=20;
		stats.getStats()[ModableHeroStats.nameResolveStat("dodge")]=-4;
		stats.getStats()[ModableHeroStats.nameResolveStat("accuracy")]=-4;
		stats.getStats()[ModableHeroStats.nameResolveStat("block")]=-4;
		stats.getStats()[ModableHeroStats.nameResolveStat("attack")]=8;
	}
}
