package gameEncounter.ItemLibrary;

import gameEncounter.Equipment;
import gameEncounter.Hero;
import gameEncounter.Item;

public abstract class ItemBody extends Item{


	public ItemBody() {
		super();
		category=4;
	}

	@Override
	public boolean equip(Equipment e) {
		e.equipBody(this);
		return false;
	}

	@Override
	public boolean unequip(Equipment e) {
		// TODO Auto-generated method stub
		return false;
	}

}
