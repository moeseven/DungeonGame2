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
		hero.setGood(true);
		hero.setSpeed(hero.getSpeed()+1);
		hero.setBaseHp(hero.getBaseHp()-15);
		hero.setDodge(hero.getDodge()+2);
		
		hero.setGood(false);
		hero.setGold((int)Math.random()*5);
		hero.setName("Goblin");
		hero.setExperienceValue(10);
		//deck				
	}

	@Override
	public String getInfo() {
		// TODO Auto-generated method stub
		return "goblin";
	}

}
