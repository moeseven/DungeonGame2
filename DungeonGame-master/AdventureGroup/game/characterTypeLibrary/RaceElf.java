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
	}

	@Override
	public String getInfo() {
		// TODO Auto-generated method stub
		return "elf";
	}

}
