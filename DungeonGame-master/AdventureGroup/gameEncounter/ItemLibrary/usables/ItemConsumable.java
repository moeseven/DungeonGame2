package gameEncounter.ItemLibrary.usables;

import gameEncounter.Hero;
import gameEncounter.Item;

public abstract class ItemConsumable extends Item{


	public ItemConsumable() {
		super();
		category=0;
	}

	@Override
	public abstract void mod(Hero hero);
	
}