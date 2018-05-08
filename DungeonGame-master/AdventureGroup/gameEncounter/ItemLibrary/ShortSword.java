package gameEncounter.ItemLibrary;

import gameEncounter.Equipment;
import gameEncounter.Hero;
import gameEncounter.Item;

public class ShortSword extends Item{

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

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Short Sword";
	}

	@Override
	public boolean equip(Equipment e) {
		// TODO Auto-generated method stub
		e.equipHand1(this);
		return false;
	}

	@Override
	public boolean unequip(Equipment e) {
		// TODO Auto-generated method stub
		return false;
	}


}
