package gameEncounter.ItemLibrary.usables;

import java.util.ArrayList;

import gameEncounter.Hero;
import gameEncounter.Item;

public abstract class ItemConsumable extends Item{

	private static ArrayList<ItemConsumable> allConsumables = new ArrayList<ItemConsumable>();
	public ItemConsumable() {
		super();
		category=0;
		weight=1;
		droppable=true;
	}
	public static ItemConsumable generateRandomConsumable() {
		allConsumables = new ArrayList<ItemConsumable>();
		//all the consumables
		allConsumables.add(new HealingPotion());
		allConsumables.add(new EnergyPotion());
		allConsumables.add(new AntiVenom());
		allConsumables.add(new Bandages());
		//
		int random= (int) (Math.random()*allConsumables.size());
		return allConsumables.get(random);
	}
	
}
