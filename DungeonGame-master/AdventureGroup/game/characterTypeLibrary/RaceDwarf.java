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
	}

	@Override
	public String getInfo() {
		// TODO Auto-generated method stub
		return "dwarf";
	}

}
