package gameEncounter.ItemLibrary;

import gameEncounter.Equipment;
import gameEncounter.Hero;
import gameEncounter.Item;
import gameEncounter.ModableHeroStats;

public class MagicStaff extends ItemBiHand{

	public MagicStaff() {
		super();
		name="magic staff";
		setGoldValue(475);
		this.baseDamage=9;
		this.damageRange=9;
		this.facStr=0.55;
		this.weaponRange=2;
		this.requiredIntelligence=19;
		stats.getStats()[ModableHeroStats.nameResolveStat("mana")]=1;
	}
}
