package gameEncounter.ItemLibrary.usables;

import gameEncounter.Hero;
import gameEncounter.Item;

public class PotionOfStrength extends ItemConsumable{


	public PotionOfStrength() {
		super();
		name="potion of strength";
		setGoldValue(700);
	}

	@Override
	public void mod(Hero hero) {
		hero.setStrength(hero.getStrength()+1);
	}
	
}
