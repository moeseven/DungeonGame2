package gameEncounter.ItemLibrary;

import gameEncounter.Equipment;
import gameEncounter.Hero;
import gameEncounter.Item;

public class Buckler extends ItemHand2{

	
	public Buckler() {
		super();
		name="buckler";
		// TODO Auto-generated constructor stub
	}

	@Override
	public void mod(Hero hero) {
		// TODO Auto-generated method stub
		hero.setBlockBonus(hero.getBlockBonus()+2);
	}

	@Override
	public void demod(Hero hero) {
		// TODO Auto-generated method stub
		hero.setBlockBonus(hero.getBlockBonus()-2);
	}


}
