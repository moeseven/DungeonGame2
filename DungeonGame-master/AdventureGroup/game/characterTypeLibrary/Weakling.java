package game.characterTypeLibrary;

import game.CharacterRace;
import gameEncounter.Deck;
import gameEncounter.Hero;
import gameEncounter.CardLibrary.Block;
import gameEncounter.CardLibrary.BasicAttack;

public class Weakling extends CharacterRace{

	public Weakling() {
		name="weakling";
	}

	public void modifyHero(Hero hero) {
		super.modifyHero(hero);
		hero.setGood(true);
		hero.setBaseHp(hero.getBaseHp()-90);
		hero.setGold((int)Math.random()*5);
		hero.setExperienceValue(10);
		//deck				
	}

}
