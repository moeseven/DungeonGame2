package game.characterTypeLibrary;

import java.util.HashMap;
import java.util.LinkedList;

import game.CharacterClass;
import game.CharacterRace;
import game.CharacterType;
import game.Game;
import gameEncounter.Deck;
import gameEncounter.Hero;

public class Weakling extends CharacterClass{
	public Weakling(Game game) {
		super(game);
		name="weakling";
		for (int j = 0; j < game.generator.getAllCards().size(); j++) {
			cards.add(game.cardBuilder.buildCard(game.generator.getAllCards().get(j)));
		}
	}

	public void modifyHero(Hero hero) {
		super.modifyHero(hero);
		hero.setGood(true);
		hero.setBaseHp(1000);
		hero.setDraw(10);
		hero.setManaPower(10);
		hero.setExperienceValue(10);
		hero.setAccuracy(40);
		//deck				
	}

}
