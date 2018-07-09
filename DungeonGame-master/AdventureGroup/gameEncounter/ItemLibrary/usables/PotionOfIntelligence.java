package gameEncounter.ItemLibrary.usables;

import gameEncounter.Hero;
import gameEncounter.Item;

public class PotionOfIntelligence extends ItemConsumable{


	public PotionOfIntelligence() {
		super();
		name="potion of intelligence";
		setGoldValue(700);
	}

	@Override
	public void mod(Hero hero) {
		hero.setIntelligence(hero.getIntelligence()+1);
	}
	
}
