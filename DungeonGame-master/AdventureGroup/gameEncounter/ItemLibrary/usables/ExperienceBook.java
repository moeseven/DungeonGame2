package gameEncounter.ItemLibrary.usables;

import gameEncounter.Hero;
import gameEncounter.Item;

public class ExperienceBook extends ItemConsumable{


	public ExperienceBook() {
		super();
		name="experience book";
		setGoldValue(20);
	}

	@Override
	public void mod(Hero hero) {
		hero.gainExp(1000);
	}
	
}
