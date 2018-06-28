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
		this.baseDamage=10;
		this.damageRange=12;
		this.facStr=0.75;
		this.weaponRange=4;
	}

}
