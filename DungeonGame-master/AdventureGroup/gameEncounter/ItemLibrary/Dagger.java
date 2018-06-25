package gameEncounter.ItemLibrary;

import gameEncounter.Equipment;
import gameEncounter.Hero;
import gameEncounter.Item;
import gameEncounter.ModableHeroStats;

public class Dagger extends ItemHand1{

	public Dagger() {
		super();
		name="dagger";
		setGoldValue(110);
		this.baseDamage=7;
		this.damageRange=8;
		this.facStr=0.35;
		this.weaponRange=1;
	}

}
