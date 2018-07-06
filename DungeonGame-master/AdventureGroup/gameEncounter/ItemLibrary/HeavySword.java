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
		this.baseDamage=20;
		this.damageRange=18;
		this.facStr=0.95;
		this.weaponRange=2;
		this.requiredStrength=20;
		stats.getStats()[ModableHeroStats.nameResolveStat("dodge")]=-1;
		stats.getStats()[ModableHeroStats.nameResolveStat("accuracy")]=-1;
		stats.getStats()[ModableHeroStats.nameResolveStat("block")]=-1;
		stats.getStats()[ModableHeroStats.nameResolveStat("attack")]=2;
	}
}
