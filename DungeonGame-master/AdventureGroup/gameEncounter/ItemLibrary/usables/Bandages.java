package gameEncounter.ItemLibrary.usables;

import gameEncounter.GameEquations;
import gameEncounter.Hero;
import gameEncounter.Item;

public class Bandages extends ItemConsumable{


	public Bandages() {
		super();
		name="bandages";
		setGoldValue(20);
	}

	@Override
	public void mod(Hero hero) {
		hero.setBleed(0);	
	}
	
}
