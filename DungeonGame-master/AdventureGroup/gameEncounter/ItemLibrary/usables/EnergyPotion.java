package gameEncounter.ItemLibrary.usables;

import gameEncounter.GameEquations;
import gameEncounter.Hero;
import gameEncounter.Item;

public class EnergyPotion extends ItemConsumable{


	public EnergyPotion() {
		super();
		name="healing potion";
		this.setImageNumber(230);
		setGoldValue(45);
	}

	@Override
	public void mod(Hero hero) {
		hero.setMana(hero.getMana()+1);		
	}
	
}
