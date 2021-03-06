package gameEncounter.ItemLibrary;

import gameEncounter.Equipment;
import gameEncounter.Hero;
import gameEncounter.Item;
import gameEncounter.ModableHeroStats;

public class ShortBow extends ItemBiHand{

	public ShortBow() {
		super();
		name="short bow";
		setGoldValue(190);
		this.baseDamage=12;
		this.damageRange=18;
		this.facStr=0.1;
		this.weaponRange=10;
		stats.getStats()[ModableHeroStats.nameResolveStat("accuracy")]=-1;
		stats.getStats()[ModableHeroStats.nameResolveStat("block")]=-1;
	}

}
