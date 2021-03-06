package game.characterTypeLibrary;

import game.CharacterRace;
import game.Game;
import gameEncounter.Deck;
import gameEncounter.Hero;
import gameEncounter.CardLibrary.BasicAttack;

public class RaceHalfling extends CharacterRace{

	public RaceHalfling(Game game) {
		super(game);
		name="halfling";
		nameList.add("Hemik");
		nameList.add("F�renik");
		nameList.add("Sam");
		nameList.add("Firdi");
		nameList.add("Laura");
		nameList.add("Nulas");
		nameList.add("Tim");
		nameList.add("Nimek");
		nameList.add("Derbel");
		nameList.add("Neuk");
		nameList.add("Myr");
		nameList.add("Nunt");
		nameList.add("Brodda");
		nameList.add("Ulfang");
	}

	public void modifyHero(Hero hero) {
		super.modifyHero(hero);
		//hero.setImage(hero.getPlayer().getGame().imageLoader.getImage(31));
		hero.setImageNumber(31);
		hero.setStrength(hero.getStrength()-6);
		hero.setDexterity(hero.getDexterity()+2);
		hero.setVitality(hero.getVitality()-2);
		hero.setDodge(hero.getDodge()+11);
		hero.setBaseHp(hero.getBaseHp()-10);
		//resistances
		hero.setArmor(2);
		hero.setSpellResist(30);
		hero.setResistFire(0);
		hero.setResistCold(5);
		hero.setResistPoison(10);
		hero.setResistBleed(5);
		hero.setResistStun(0);	
		hero.setResistStress(26);
		hero.setTrapDisarm(30);
		//
		hero.setPoisonDmg(5);
		hero.setCritDamage(9);
		hero.setCritChance(5);
		//deck
		
	}

}
