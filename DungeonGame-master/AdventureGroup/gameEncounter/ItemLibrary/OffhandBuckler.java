package gameEncounter.ItemLibrary;

import gameEncounter.Equipment;
import gameEncounter.Hero;
import gameEncounter.Item;

public class OffhandBuckler extends Item{

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

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Buckler";
	}

	@Override
	public boolean equip(Equipment e) {
		// TODO Auto-generated method stub
		e.equipHand2(this);
		return false;
	}

	@Override
	public boolean unequip(Equipment e) {
		// TODO Auto-generated method stub
		return false;
	}


}
