package game.characterTypeLibrary;

import game.CharacterRace;
import gameEncounter.Deck;
import gameEncounter.Hero;
import gameEncounter.CardLibrary.Block;
import gameEncounter.CardLibrary.Cleave;
import gameEncounter.CardLibrary.BasicAttack;

public class RaceHuman extends CharacterRace{

	public RaceHuman() {
		name="human";
		nameList.add("Herbert");
		nameList.add("Hank");
		nameList.add("Hans");
		nameList.add("Argeil");
		nameList.add("Peter");
		nameList.add("Adam");
		nameList.add("Ruben");
		nameList.add("Walter");
		nameList.add("Thomas");
		nameList.add("Tom");		
		nameList.add("Bill");
		nameList.add("Josef");
		nameList.add("Dieter");
		nameList.add("Ulrich");
		nameList.add("Mandor");
		nameList.add("Berethor");
		nameList.add("Siegfried");
		nameList.add("Moritz");
		nameList.add("Emil");
	}

	public  void modifyHero(Hero hero) {
		super.modifyHero(hero);
		hero.setResistFire(5);
		hero.setResistCold(5);
		hero.setResistPoison(5);
		hero.setResistStun(7);
		hero.setSpellResist(hero.getSpellResist()-1);
		//deck
				
	}


}
