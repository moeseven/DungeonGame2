package game.characterTypeLibrary;

import game.CharacterClass;
import gameEncounter.Hero;
import gameEncounter.ItemLibrary.RustyBlade;

public class TypeMage extends CharacterClass{

	public TypeMage() {
		name="mage";
		items.add(new RustyBlade());
	}

	public void modifyHero(Hero hero) {
		// TODO Auto-generated method stub
		super.modifyHero(hero);
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
