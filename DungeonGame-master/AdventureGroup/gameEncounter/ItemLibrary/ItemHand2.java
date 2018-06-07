package gameEncounter.ItemLibrary;

import gameEncounter.Equipment;
import gameEncounter.Hero;
import gameEncounter.Item;

public abstract class ItemHand2 extends Item{


	public ItemHand2() {
		super();
		category=2;
	}

	@Override
	public boolean equip(Equipment e) {
		e.equipHand2(this);
		return false;
	}

	@Override
	public boolean unequip(Equipment e) {
		// TODO Auto-generated method stub
		return false;
	}

}
