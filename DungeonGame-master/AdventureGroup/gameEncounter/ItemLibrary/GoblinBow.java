package gameEncounter.ItemLibrary;

import gameEncounter.Equipment;
import gameEncounter.Hero;
import gameEncounter.Item;
import gameEncounter.ModableHeroStats;

public class GoblinBow extends ItemBiHand{

	public GoblinBow() {
		super();
		name="goblin bow";
		setGoldValue(10);
		this.baseDamage=4;
		this.damageRange=8;
		this.facStr=0.01;
		this.weaponRange=10;
		stats.getStats()[ModableHeroStats.nameResolveStat("accuracy")]=-1;
		stats.getStats()[ModableHeroStats.nameResolveStat("block")]=-1;
		stats.getStats()[ModableHeroStats.nameResolveStat("attack")]=2;
	}

}
