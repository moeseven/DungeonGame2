package game.characterTypeLibrary;

import game.CharacterClass;
import game.Game;
import gameEncounter.Hero;
import gameEncounter.CardLibrary.BackStab;
import gameEncounter.CardLibrary.BasicAttack;
import gameEncounter.CardLibrary.BlindingBomb;
import gameEncounter.CardLibrary.Block;
import gameEncounter.CardLibrary.DaggerThrow;
import gameEncounter.CardLibrary.Feint;
import gameEncounter.CardLibrary.Parry;
import gameEncounter.CardLibrary.PoisonAttack;
import gameEncounter.CardLibrary.PoisonBomb;
import gameEncounter.CardLibrary.RangedAttack;
import gameEncounter.CardLibrary.Sidestep;
import gameEncounter.ItemLibrary.RustyBlade;

public class TypeThief extends CharacterClass{

	public TypeThief(Game game) {
		super(game);
		cardPool.add("backStab");
		cardPool.add("blindingBomb");
		cardPool.add("poisonBomb");
		cardPool.add("poisonousSlice()");		
		cardPool.add("daggerThrow");
		cardPool.add("feint");
		cardPool.add("sideStep");
		name="thief";
		items.add(new RustyBlade());
		for (int i=0; i<8;i++) {
			cards.add(game.cardBuilder.buildCard("basicAttack"));
		}
		for (int i=0; i<2;i++) {
			cards.add(game.cardBuilder.buildCard("basicBlock"));
		}
//		cards.add(game.cardBuilder.buildCard("backStab"));
//		cards.add(game.cardBuilder.buildCard("blindingBomb"));
//		cards.add(game.cardBuilder.buildCard("poisonBomb"));
//		cards.add(game.cardBuilder.buildCard("poisonousSlice"));
//		cards.add(game.cardBuilder.buildCard("daggerThrow"));
//		cards.add(game.cardBuilder.buildCard("feint"));
//		cards.add(game.cardBuilder.buildCard("sideStep"));
	}

	public void modifyHero(Hero hero) {
		super.modifyHero(hero);
		if (hero.getCharRace().getName().equals("human")) {
			hero.setImage(hero.getPlayer().getGame().imageLoader.getImage(25));
		}
		if (hero.getCharRace().getName().equals("dwarf")) {
			hero.setImage(hero.getPlayer().getGame().imageLoader.getImage(35));
		}
		if (hero.getCharRace().getName().equals("elf")) {
			hero.setImage(hero.getPlayer().getGame().imageLoader.getImage(36));
		}
		if (hero.getCharRace().getName().equals("halfling")) {
			hero.setImage(hero.getPlayer().getGame().imageLoader.getImage(37));
		}
		//mainstats
		hero.setStrength(hero.getStrength()+2);
		hero.setDexterity(hero.getDexterity()+4);
		hero.setIntelligence(hero.getIntelligence()+2);
		hero.setVitality(hero.getVitality()+1);
		//
		hero.setCritChance(hero.getCritChance()+8);
		hero.setDodge(hero.getDodge()+1);
		hero.setSpeed(hero.getSpeed()+1);
		hero.setTrapDisarm(hero.getTrapDisarm()+40);
		hero.setResistStress(hero.getResistStress()-4);
	}
}
