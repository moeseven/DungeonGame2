package game.characterTypeLibrary;

import game.CharacterClass;
import gameEncounter.Hero;
import gameEncounter.ItemLibrary.GoblinBow;
import gameEncounter.ItemLibrary.RustyBlade;
import gameEncounter.ItemLibrary.ShortBow;

public class TypeArcher extends CharacterClass{

	public TypeArcher() {
		name="archer";
		items.add(new GoblinBow());
	}

	public void modifyHero(Hero hero) {
		// TODO Auto-generated method stub
		super.modifyHero(hero);
		hero.setAccuracy(hero.getAccuracy()+2);
	}

	@Override
	public String getInfo() {
		// TODO Auto-generated method stub
		return "thief";
	}

}
