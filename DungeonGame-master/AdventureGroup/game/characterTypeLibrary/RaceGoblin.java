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
		hero.setGood(false);
		hero.setSpeed(7);
		hero.setAttackSkill(7);
		hero.setBlockSkill(4);
		hero.setArmor(1);
		hero.setManaPower(2);
		hero.setDraw(3);
		hero.setBaseHp(40+(int) (Math.random()*50));
		hero.setGold((int)Math.random()*5);
		hero.setName("Goblin");
		hero.setExperienceValue(10);
		//deck
		for (int i=0; i<4;i++) {
			hero.getDeck().addCard(new BasicAttack());
		}
		for (int i=0; i<3;i++) {
			hero.getDeck().addCard(new Block());
		}
		
		
	}

	@Override
	public String getInfo() {
		// TODO Auto-generated method stub
		return "goblin";
	}

}
