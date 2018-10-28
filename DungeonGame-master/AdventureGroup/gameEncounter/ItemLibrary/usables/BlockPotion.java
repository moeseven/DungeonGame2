package gameEncounter.ItemLibrary.usables;

import gameEncounter.GameEquations;
import gameEncounter.Hero;
import gameEncounter.Item;

public class BlockPotion extends ItemConsumable{


	public BlockPotion() {
		super();
		name="hard potion";
		this.setImageNumber(231);
		setGoldValue(20);
	}

	@Override
	public void mod(Hero hero) {
		hero.setBlock(hero.getBlock()+45);	
	}
	
}
