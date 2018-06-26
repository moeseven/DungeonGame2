package game.characterTypeLibrary;

import game.CharacterRace;
import gameEncounter.Deck;
import gameEncounter.Hero;
import gameEncounter.CardLibrary.Block;
import gameEncounter.CardLibrary.BasicAttack;

public class RaceHalfling extends CharacterRace{

	public RaceHalfling() {
		name="halfling";
		nameList.add("Hemik");
		nameList.add("Förenik");
		nameList.add("Sam");
		nameList.add("Firdi");
		nameList.add("Laura");
		nameList.add("Nulas");
		nameList.add("Tim");
		nameList.add("Nimek");
		nameList.add("Derbel");
		nameList.add("Neuk");
		nameList.add("Myr");
		nameList.add("Nunt");
		nameList.add("Brodda");
		nameList.add("Ulfang");
	}

	public void modifyHero(Hero hero) {
		super.modifyHero(hero);
		hero.setStrength(hero.getStrength()-3);
		hero.setDexterity(hero.getDexterity()+1);
		hero.setSpellResist(hero.getSpellResist()+4);
		hero.setVitality(hero.getVitality()-1);
		hero.setDodge(hero.getDodge()+3);
		hero.setBaseHp(hero.getBaseHp()-10);
		hero.setResistFire(7);
		hero.setResistPoison(7);
		//deck
		
	}

}
