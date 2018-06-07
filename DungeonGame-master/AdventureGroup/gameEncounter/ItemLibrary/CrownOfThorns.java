package gameEncounter.ItemLibrary;

import gameEncounter.Equipment;
import gameEncounter.Hero;
import gameEncounter.Item;

public class CrownOfThorns extends ItemHead{

	
	public CrownOfThorns() {
		super();
		name="crown of thorns";
	}

	@Override
	public void mod(Hero hero) {
		hero.setTurnBlock(hero.getTurnBlock()+2);
		hero.setThorns(hero.getThorns()+5);
	}

	@Override
	public void demod(Hero hero) {
		hero.setTurnBlock(hero.getTurnBlock()-2);
		hero.setThorns(hero.getThorns()-5);
	}

}
