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
		this.baseDamage=12;
		this.damageRange=8;
		this.facStr=0.06;
		this.weaponRange=4;
	}

}
