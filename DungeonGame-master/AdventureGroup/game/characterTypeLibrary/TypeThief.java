package game.characterTypeLibrary;

import game.CharacterClass;
import gameEncounter.Hero;

public class TypeThief extends CharacterClass{

	public TypeThief() {
		name="thief";
	}

	public void modifyHero(Hero hero) {
		// TODO Auto-generated method stub
		hero.setDexterity(hero.getDexterity()+3);
		hero.setStrength(hero.getStrength()-1);
		hero.setVitality(hero.getVitality()-1);
	}

	@Override
	public String getInfo() {
		// TODO Auto-generated method stub
		return "thief";
	}

}
