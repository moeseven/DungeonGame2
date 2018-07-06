package gameEncounter.ItemLibrary;

import gameEncounter.Equipment;
import gameEncounter.Hero;
import gameEncounter.Item;
import gameEncounter.ModableHeroStats;

public class MorningStar extends ItemHand1{

	public MorningStar() {
		super();
		name="morning star";
		setGoldValue(210);
		this.baseDamage=12;
		this.damageRange=14;
		this.facStr=0.85;
		this.weaponRange=2;
		stats.getStats()[ModableHeroStats.nameResolveStat("accuracy")]=-1;
		stats.getStats()[ModableHeroStats.nameResolveStat("attack")]=7;
	}

}
