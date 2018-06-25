package game.characterTypeLibrary;

import game.CharacterRace;
import gameEncounter.Deck;
import gameEncounter.Hero;
import gameEncounter.CardLibrary.Block;
import gameEncounter.CardLibrary.BasicAttack;

public class RaceGoblin extends CharacterRace{

	public RaceGoblin() {
		name="goblin";
	}

	public void modifyHero(Hero hero) {
		super.modifyHero(hero);
		hero.setSpeed(hero.getSpeed()+1);
		hero.setBaseHp(hero.getBaseHp()-30);
		hero.setDodge(hero.getDodge()+2);
		hero.setStrength(hero.getStrength()-3);
		hero.setVitality(hero.getIntelligence()-4);
		hero.setAttackSkill(hero.getAttackSkill()-4);
		hero.setBlockSkill(hero.getBlockSkill()-5);
		hero.setGood(false);
		hero.setGold((int)(Math.random()*5.0));
		hero.setExperienceValue(10);
		hero.setResistFire(12);
		//deck				
	}

}
