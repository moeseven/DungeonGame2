package game.characterTypeLibrary;

import game.CharacterClass;
import gameEncounter.Hero;
import gameEncounter.ItemLibrary.RustyBlade;

public class TypeThief extends CharacterClass{

	public TypeThief() {
		name="thief";
		items.add(new RustyBlade());
	}

	public void modifyHero(Hero hero) {
		// TODO Auto-generated method stub
		super.modifyHero(hero);
		hero.setDodge(hero.getDodge()+1);
		hero.setSpeed(hero.getSpeed()+1);
		hero.setVitality(hero.getVitality()-1);
	}
}
