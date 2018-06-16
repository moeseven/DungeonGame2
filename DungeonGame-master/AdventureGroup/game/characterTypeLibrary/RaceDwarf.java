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
		hero.setSpeed(hero.getSpeed()-2);
		hero.setStrength(hero.getStrength()+3);
		hero.setDexterity(hero.getDexterity()-2);
		hero.setIntelligence(hero.getIntelligence()-1);
		hero.setVitality(hero.getVitality()+1);
		hero.setBaseHp(hero.getBaseHp()+10);
	}

	@Override
	public String getInfo() {
		// TODO Auto-generated method stub
		return "dwarf";
	}

}
