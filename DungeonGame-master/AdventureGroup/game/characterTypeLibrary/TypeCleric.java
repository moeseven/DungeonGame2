package game.characterTypeLibrary;

import game.CharacterClass;
import gameEncounter.Hero;
import gameEncounter.ItemLibrary.RustyBlade;


public class TypeCleric extends CharacterClass{

	public TypeCleric() {
		name="cleric";
		items.add(new RustyBlade());
	}

	public void modifyHero(Hero hero) {
		// TODO Auto-generated method stub
		super.modifyHero(hero);
		hero.setStrength(hero.getStrength()+1);
		hero.setIntelligence(hero.getIntelligence()+1);
		hero.setVitality(hero.getVitality()+1);
		hero.setDexterity(hero.getDexterity()-2);
	}

	@Override
	public String getInfo() {
		// TODO Auto-generated method stub
		return "cleric";
	}

}
