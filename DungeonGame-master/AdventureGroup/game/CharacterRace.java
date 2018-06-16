package game;

import gameEncounter.Hero;
import gameEncounter.CardLibrary.BasicAttack;
import gameEncounter.CardLibrary.Block;

public abstract class CharacterRace extends CharacterType{

	public CharacterRace() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void modifyHero(Hero hero) {
		hero.setSpeed(10);
		hero.setStrength(10);
		hero.setDexterity(10);
		hero.setVitality(10);
		hero.setIntelligence(10);
		hero.setBlockSkill(10);
		hero.setArmor(1);
		hero.setDodge(10);
		hero.setManaPower(2);
		hero.setDraw(3);
		hero.setBaseHp(100);
		hero.setGold((int)(100*Math.random()));
		//deck
		for (int i=0; i<5;i++) {
			hero.getDeck().addCard(new BasicAttack());
		}
		for (int i=0; i<3;i++) {
			hero.getDeck().addCard(new Block());
		}
	}
	

}
