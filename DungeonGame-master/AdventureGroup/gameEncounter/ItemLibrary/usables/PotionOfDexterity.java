package gameEncounter.ItemLibrary.usables;

import gameEncounter.Hero;
import gameEncounter.Item;

public class PotionOfDexterity extends ItemConsumable{


	public PotionOfDexterity() {
		super();
		name="potion of dexterity";
		setGoldValue(700);
	}

	@Override
	public void mod(Hero hero) {
		hero.setDexterity(hero.getDexterity()+1);
	}
	
}
