package game.characterTypeLibrary;

import game.CharacterRace;
import gameEncounter.Hero;

public class RaceDwarf extends CharacterRace{

	public RaceDwarf() {
		name="dwarf";
	}

	public void modifyHero(Hero hero) {
		// TODO Auto-generated method stub
		super.modifyHero(hero);
		hero.setGood(true);		
		hero.setBaseHp(hero.getBaseHp()+10);
		hero.setBlockSkill(hero.getBlockSkill()+2);
		hero.setDodge(hero.getDodge()-1);
		hero.setSpeed(hero.getSpeed()-2);
	}

	@Override
	public String getInfo() {
		// TODO Auto-generated method stub
		return "dwarf";
	}

}
