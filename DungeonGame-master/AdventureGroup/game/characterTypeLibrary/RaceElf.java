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
		hero.setSpeed(hero.getSpeed()+2);
		hero.setAccuracy(hero.getAccuracy()+3);
		hero.setBaseHp(hero.getBaseHp()-5);
		hero.setStrength(hero.getStrength()-1);
		hero.setDexterity(hero.getDexterity()+3);
	}

	@Override
	public String getInfo() {
		// TODO Auto-generated method stub
		return "elf";
	}

}
