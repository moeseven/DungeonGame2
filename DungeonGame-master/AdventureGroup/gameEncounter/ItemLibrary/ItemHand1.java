package gameEncounter.ItemLibrary;

import gameEncounter.Equipment;
import gameEncounter.Hero;
import gameEncounter.Item;

public abstract class ItemHand1 extends Item{


	public ItemHand1() {
		super();
		category=1;
	}

	@Override
	public boolean equip(Equipment e) {
		e.equipHand1(this);
		return false;
	}

	@Override
	public boolean unequip(Equipment e) {
		// TODO Auto-generated method stub
		return false;
	}
}
