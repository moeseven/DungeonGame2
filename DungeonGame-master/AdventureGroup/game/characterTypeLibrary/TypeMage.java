package game.characterTypeLibrary;

import game.CharacterClass;
import game.Game;
import gameEncounter.Hero;
import gameEncounter.CardLibrary.BasicAttack;
import gameEncounter.CardLibrary.Block;
import gameEncounter.CardLibrary.Channel;
import gameEncounter.CardLibrary.FireBall;
import gameEncounter.CardLibrary.Firewave;
import gameEncounter.CardLibrary.Magicmissile;
import gameEncounter.CardLibrary.RangedAttack;
import gameEncounter.CardLibrary.RosesAndThorns;
import gameEncounter.CardLibrary.SleepCharm;
import gameEncounter.CardLibrary.Wisdom;
import gameEncounter.ItemLibrary.RustyBlade;

public class TypeMage extends CharacterClass{

	public TypeMage(Game game) {
		super(game);
		cardPool.add("fireWave");
		cardPool.add("wisdom");
		cardPool.add("channel");
		cardPool.add("fireBall");
		cardPool.add("sleepCharm");		
		cardPool.add("rosesAndThorns");
		name="mage";		
		items.add(new RustyBlade());
		for (int i=0; i<3;i++) {
			cards.add(game.cardBuilder.buildCard("basicBlock"));
		}
		cards.add(game.cardBuilder.buildCard("magicMissile"));
		cards.add(game.cardBuilder.buildCard("magicMissile"));
		for (int i=0; i<5;i++) {
			cards.add(game.cardBuilder.buildCard("basicAttack"));
		}
		
	}

	public void modifyHero(Hero hero) {
		super.modifyHero(hero);
		if (hero.getCharRace().getName().equals("human")) {
			hero.setImage(hero.getPlayer().getGame().imageLoader.getImage(124));
		}
		if (hero.getCharRace().getName().equals("dwarf")) {
			hero.setImage(hero.getPlayer().getGame().imageLoader.getImage(127));
		}
		if (hero.getCharRace().getName().equals("elf")) {
			hero.setImage(hero.getPlayer().getGame().imageLoader.getImage(125));
		}
		if (hero.getCharRace().getName().equals("halfling")) {
			hero.setImage(hero.getPlayer().getGame().imageLoader.getImage(126));
		}
		//mainstats
		hero.setStrength(hero.getStrength()+0);
		hero.setDexterity(hero.getDexterity()+1);
		hero.setIntelligence(hero.getIntelligence()+6);
		hero.setVitality(hero.getVitality()+1);
		//
		hero.setSpellPower(hero.getSpellPower()+2);	
		hero.setResistStress(hero.getResistStress()-3);
	}
}
