package gameEncounter.ItemLibrary.usables;

import gameEncounter.Hero;
import gameEncounter.Item;

public class PotionOfHealth extends ItemConsumable{


	public PotionOfHealth() {
		super();
		name="potion of health";
		setImageNumber(221);
		setGoldValue(700);
	}

	@Override
	public void mod(Hero hero) {
		hero.setBaseHp(hero.getBaseHp()+10);
	}
	
}
