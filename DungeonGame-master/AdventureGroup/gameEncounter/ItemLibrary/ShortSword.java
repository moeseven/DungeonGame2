package gameEncounter.ItemLibrary;

import gameEncounter.Equipment;
import gameEncounter.Hero;
import gameEncounter.Item;
import gameEncounter.ModableHeroStats;

public class ShortSword extends ItemHand1{

	public ShortSword() {
		super();
		name="short sword";
		this.baseDamage=12;
		this.damageRange=8;
		this.facStr=0.05;
		this.weaponRange=2;
	}

}
