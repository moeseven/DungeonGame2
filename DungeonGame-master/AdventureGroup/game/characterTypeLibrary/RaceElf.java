package game.characterTypeLibrary;

import game.CharacterRace;
import gameEncounter.Hero;


public class RaceElf extends CharacterRace{

	public RaceElf() {
		name="elf";
	}

	public void modifyHero(Hero hero) {
		// TODO Auto-generated method stub
		super.modifyHero(hero);
		hero.setGood(true);
		hero.setSpeed(hero.getSpeed()+4);
		hero.setStrength(hero.getStrength()-1);
		hero.setDexterity(hero.getDexterity()+5);
		hero.setIntelligence(hero.getIntelligence());
		hero.setVitality(hero.getVitality()-2);
		hero.setBaseHp(hero.getBaseHp()-5);
	}

	@Override
	public String getInfo() {
		// TODO Auto-generated method stub
		return "elf";
	}

}
