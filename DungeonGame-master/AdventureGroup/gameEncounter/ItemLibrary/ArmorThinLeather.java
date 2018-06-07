package gameEncounter.ItemLibrary;

import gameEncounter.Equipment;
import gameEncounter.Hero;
import gameEncounter.Item;

public class ArmorThinLeather extends ItemBody{

	
	public ArmorThinLeather() {
		super();
		name="Thin Leather";
	}

	@Override
	public void mod(Hero hero) {
		hero.setTurnBlock(hero.getTurnBlock()+1);
	}

	@Override
	public void demod(Hero hero) {
		hero.setTurnBlock(hero.getTurnBlock()-1);
	}

}
