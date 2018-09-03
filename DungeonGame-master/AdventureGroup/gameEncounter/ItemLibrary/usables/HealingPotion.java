package gameEncounter.ItemLibrary.usables;

import gameEncounter.GameEquations;
import gameEncounter.Hero;
import gameEncounter.Item;

public class HealingPotion extends ItemConsumable{


	public HealingPotion() {
		super();
		name="healing potion";
		setGoldValue(20);
	}

	@Override
	public void mod(Hero hero) {
		hero.heal((int)(GameEquations.maxHealthCalc(hero)/4.0));		
	}
	
}
