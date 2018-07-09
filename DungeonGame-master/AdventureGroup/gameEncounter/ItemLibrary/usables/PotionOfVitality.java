package gameEncounter.ItemLibrary.usables;

import gameEncounter.Hero;
import gameEncounter.Item;

public class PotionOfVitality extends ItemConsumable{


	public PotionOfVitality() {
		super();
		name="potion of vitality";
		setGoldValue(700);
	}

	@Override
	public void mod(Hero hero) {
		hero.setVitality(hero.getVitality()+1);
	}
	
}
