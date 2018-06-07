package gameEncounter.ItemLibrary;

import gameEncounter.Equipment;
import gameEncounter.Hero;
import gameEncounter.Item;

public abstract class ItemBiHand extends Item{


	public ItemBiHand() {
		super();
		category=3;
	}

	@Override
	public boolean equip(Equipment e) {
		e.equipBiHand(this);
		return false;
	}

	@Override
	public boolean unequip(Equipment e) {
		// TODO Auto-generated method stub
		return false;
	}

}
