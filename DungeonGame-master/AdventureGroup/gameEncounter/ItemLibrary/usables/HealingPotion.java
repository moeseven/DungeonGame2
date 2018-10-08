package gameEncounter.ItemLibrary.usables;

import gameEncounter.GameEquations;
import gameEncounter.Hero;
import gameEncounter.Item;

public class HealingPotion extends ItemConsumable{


	public HealingPotion() {
		super();
		name="healing potion";
		this.setImageNumber(220);
		setGoldValue(20);
	}

	@Override
	public void mod(Hero hero) {
		hero.heal((50));		
	}
	
}
