package gameEncounter.ItemLibrary.usables;

import gameEncounter.GameEquations;
import gameEncounter.Hero;
import gameEncounter.Item;

public class ManaPotion extends ItemConsumable{


	public ManaPotion() {
		super();
		name="mana potion";
		this.setImageNumber(230);
		setGoldValue(45);
	}

	@Override
	public void mod(Hero hero) {
		hero.setMana(hero.getMana()+2);		
	}
	
}
