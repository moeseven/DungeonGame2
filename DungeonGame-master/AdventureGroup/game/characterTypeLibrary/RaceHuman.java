package game.characterTypeLibrary;

import game.CharacterRace;
import gameEncounter.Deck;
import gameEncounter.Hero;
import gameEncounter.CardLibrary.Block;
import gameEncounter.CardLibrary.Cleave;
import gameEncounter.CardLibrary.BasicAttack;

public class RaceHuman extends CharacterRace{

	public RaceHuman() {
		name="human";
	}

	public  void modifyHero(Hero hero) {
		super.modifyHero(hero);
		hero.setGood(true);
		//deck
				
	}

	@Override
	public String getInfo() {
		// TODO Auto-generated method stub
		return "human";
	}

}
