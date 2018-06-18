package game.characterTypeLibrary;

import game.CharacterClass;
import gameEncounter.Hero;
import gameEncounter.CardLibrary.Cleave;

public class TypeWarrior extends CharacterClass{

	public TypeWarrior() {
		name="warrior";
	}

	public void modifyHero(Hero hero) {
		// TODO Auto-generated method stub
		hero.setStrength(hero.getStrength()+1);
		hero.setVitality(hero.getVitality()+1);
		hero.setIntelligence(hero.getIntelligence()-1);
		hero.getDeck().addCard(new Cleave());
	}

	@Override
	public String getInfo() {
		// TODO Auto-generated method stub
		return "warrior";
	}

}
