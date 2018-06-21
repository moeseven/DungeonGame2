package game.characterTypeLibrary;

import game.CharacterClass;
import gameEncounter.Hero;
import gameEncounter.ItemLibrary.RustyBlade;
import gameEncounter.ItemLibrary.ShortBow;

public class TypeArcher extends CharacterClass{

	public TypeArcher() {
		name="archer";
		items.add(new ShortBow());
	}

	public void modifyHero(Hero hero) {
		// TODO Auto-generated method stub
		super.modifyHero(hero);
		hero.setAccuracy(hero.getAccuracy()+2);
		hero.setStrength(hero.getStrength()-1);
		hero.setVitality(hero.getVitality()-1);
	}

	@Override
	public String getInfo() {
		// TODO Auto-generated method stub
		return "thief";
	}

}
