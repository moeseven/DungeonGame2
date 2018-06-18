package game.characterTypeLibrary;

import game.CharacterClass;
import gameEncounter.Hero;

public class TypeMage extends CharacterClass{

	public TypeMage() {
		name="mage";
	}

	public void modifyHero(Hero hero) {
		// TODO Auto-generated method stub
		hero.setIntelligence(hero.getIntelligence()+4);
		hero.setVitality(hero.getVitality()-1);
		hero.setStrength(hero.getStrength()-2);
		
	}

	@Override
	public String getInfo() {
		// TODO Auto-generated method stub
		return "mage";
	}

}
