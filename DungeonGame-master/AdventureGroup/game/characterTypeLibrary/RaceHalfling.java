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
		hero.setGood(true);
		hero.setDodge(hero.getDodge()+3);
		hero.setSpeed(hero.getSpeed()+1);
		hero.setBaseHp(hero.getBaseHp()-10);
		//deck
		for (int i=0; i<1;i++) {
			hero.getDeck().addCard(new Block());
		}
		
	}

	@Override
	public String getInfo() {
		// TODO Auto-generated method stub
		return "halfling";
	}

}
