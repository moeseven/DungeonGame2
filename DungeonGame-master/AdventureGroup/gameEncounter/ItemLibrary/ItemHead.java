package gameEncounter.ItemLibrary;

import gameEncounter.Equipment;
import gameEncounter.Hero;
import gameEncounter.Item;

public abstract class ItemHead extends Item{


	public ItemHead() {
		super();
		category=5;
	}

	@Override
	public boolean equip(Equipment e) {
		e.equipHead(this);
		return false;
	}

	@Override
	public boolean unequip(Equipment e) {
		// TODO Auto-generated method stub
		return false;
	}

}
