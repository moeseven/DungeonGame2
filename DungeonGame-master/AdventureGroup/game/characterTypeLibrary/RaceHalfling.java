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
		hero.setSpeed(9);
		hero.setAttackSkill(8);
		hero.setBlockSkill(6);
		hero.setArmor(0);
		hero.setManaPower(2);
		hero.setDraw(3);
		hero.setBaseHp(90);
		hero.setGold((int)(100*Math.random()));
		//deck
		for (int i=0; i<3;i++) {
			hero.getDeck().addCard(new Block());
		}
		
	}

	@Override
	public String getInfo() {
		// TODO Auto-generated method stub
		return "halfling";
	}

}
