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
		hero.setSpeed(6);
		hero.setStrength(12);
		hero.setDexterity(8);
		hero.setVitality(10);
		hero.setIntelligence(10);
		hero.setAttackSkill(10);
		hero.setBlockSkill(8);
		hero.setArmor(1);
		hero.setManaPower(2);
		hero.setDraw(3);
		hero.setBaseHp(100);
		hero.setGold((int)(100*Math.random()));
		//deck
		for (int i=0; i<3;i++) {
			hero.getDeck().addCard(new Block());
		}		
	}

	@Override
	public String getInfo() {
		// TODO Auto-generated method stub
		return "human";
	}

}
