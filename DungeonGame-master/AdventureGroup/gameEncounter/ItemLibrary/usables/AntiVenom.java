package gameEncounter.ItemLibrary.usables;

import gameEncounter.GameEquations;
import gameEncounter.Hero;
import gameEncounter.Item;

public class AntiVenom extends ItemConsumable{


	public AntiVenom() {
		super();
		name="anti venom";
		this.setImageNumber(221);
		setGoldValue(25);
	}

	@Override
	public void mod(Hero hero) {
		hero.setPoison(0);		
	}
	
}
