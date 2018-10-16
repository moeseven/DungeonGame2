package game.characterTypeLibrary;

import game.CharacterRace;
import game.Game;
import gameEncounter.Deck;
import gameEncounter.Hero;

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
		//hero.setImage(hero.getPlayer().getGame().imageLoader.getImage(29));
		hero.setImageNumber(29);
		//resistances
		hero.setSpellResist(5);
		hero.setResistFire(5);
		hero.setResistCold(5);
		hero.setResistPoison(5);
		hero.setResistBleed(5);
		hero.setResistStun(5);
		hero.setResistStress(10);
		hero.setTrapDisarm(12);
		hero.setStunChance(4);
		//
		hero.setMagicDmg(5);
		hero.setCritDamage(10);
		hero.setCritChance(3);
		//deck
				
	}


}
