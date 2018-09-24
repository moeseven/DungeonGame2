package game.characterTypeLibrary;

import game.CharacterRace;
import game.Game;
import gameEncounter.Deck;
import gameEncounter.Hero;
import gameEncounter.CardLibrary.Block;
import gameEncounter.CardLibrary.Cleave;
import gameEncounter.CardLibrary.BasicAttack;

public class RaceHuman extends CharacterRace{

	public RaceHuman(Game game) {
		super(game);
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
		hero.setImage(hero.getPlayer().getGame().imageLoader.getImage(29));
		//resistances
		hero.setSpellResist(0);
		hero.setResistFire(0);
		hero.setResistCold(0);
		hero.setResistPoison(0);
		hero.setResistBleed(0);
		hero.setResistStun(0);
		hero.setResistStress(10);
		hero.setTrapDisarm(12);
		//deck
				
	}


}
