package gameEncounter.ItemLibrary;

import gameEncounter.Equipment;
import gameEncounter.Hero;
import gameEncounter.Item;

public class HeavySword extends ItemBiHand{

	public HeavySword() {
		super();
		name="heavy sword";
		// TODO Auto-generated constructor stub
	}

	@Override
	public void mod(Hero hero) {
		// TODO Auto-generated method stub
		hero.setDamageBonus(hero.getDamageBonus()+9);
		hero.setBlockBonus(hero.getBlockBonus()-2);
	}

	@Override
	public void demod(Hero hero) {
		// TODO Auto-generated method stub
		hero.setDamageBonus(hero.getDamageBonus()-9);
		hero.setBlockBonus(hero.getBlockBonus()+2);
	}

}
