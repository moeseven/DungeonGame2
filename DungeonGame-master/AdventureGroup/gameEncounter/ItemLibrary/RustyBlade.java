package gameEncounter.ItemLibrary;

import gameEncounter.Equipment;
import gameEncounter.Hero;
import gameEncounter.Item;
import gameEncounter.ModableHeroStats;

public class RustyBlade extends ItemHand1{

	public RustyBlade() {
		super();
		name="rusty blade";
		setGoldValue(7);
		this.baseDamage=3;
		this.damageRange=10;
		this.facStr=0.06;
		this.weaponRange=2;
	}

}
