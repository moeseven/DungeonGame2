package gameEncounter.ItemLibrary;

import gameEncounter.Equipment;
import gameEncounter.Hero;
import gameEncounter.Item;

public class ShortSword extends ItemHand1{

	public ShortSword() {
		super();
		name="short sword";
		// TODO Auto-generated constructor stub
	}

	@Override
	public void mod(Hero hero) {
		// TODO Auto-generated method stub
		hero.setDamageBonus(hero.getDamageBonus()+3);
	}

	@Override
	public void demod(Hero hero) {
		// TODO Auto-generated method stub
		hero.setDamageBonus(hero.getDamageBonus()-3);
	}

}
