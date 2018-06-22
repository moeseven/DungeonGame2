package game.characterTypeLibrary;

import game.CharacterRace;
import gameEncounter.Deck;
import gameEncounter.Hero;
import gameEncounter.CardLibrary.Block;
import gameEncounter.CardLibrary.BasicAttack;

public class RaceHalfling extends CharacterRace{

	public RaceHalfling() {
		name="halfling";
	}

	public void modifyHero(Hero hero) {
		super.modifyHero(hero);
		hero.setStrength(hero.getStrength()-3);
		hero.setDexterity(hero.getDexterity()+1);
		hero.setVitality(hero.getVitality()-1);
		hero.setDodge(hero.getDodge()+3);
		hero.setBaseHp(hero.getBaseHp()-10);
		//deck
		
	}

	@Override
	public String getInfo() {
		// TODO Auto-generated method stub
		return "halfling";
	}

}
