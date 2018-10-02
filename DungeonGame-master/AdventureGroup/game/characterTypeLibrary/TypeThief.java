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
		name="thief";
		cardPool.add("backStab");
		cardPool.add("blindingBomb");
		cardPool.add("poisonBomb");
		cardPool.add("poisonousSlice");		
		cardPool.add("daggerThrow");
		cardPool.add("feint");
		cardPool.add("sideStep");
		items.add(game.itemBuilder.buildItem("rustyBlade",2));
		cards.add(game.cardBuilder.buildCard("feint"));
		cards.add(game.cardBuilder.buildCard("daggerThrow"));		
		for (int i=0; i<5;i++) {
			cards.add(game.cardBuilder.buildCard("basicAttack"));
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
			//hero.setImage(hero.getPlayer().getGame().imageLoader.getImage(25));
			hero.setImageNumber(25);
		}
		if (hero.getCharRace().getName().equals("dwarf")) {
			//hero.setImage(hero.getPlayer().getGame().imageLoader.getImage(35));
			hero.setImageNumber(35);
		}
		if (hero.getCharRace().getName().equals("elf")) {
			//hero.setImage(hero.getPlayer().getGame().imageLoader.getImage(36));
			hero.setImageNumber(36);
		}
		if (hero.getCharRace().getName().equals("halfling")) {
			//hero.setImage(hero.getPlayer().getGame().imageLoader.getImage(37));
			hero.setImageNumber(37);
		}
		//mainstats
		hero.setStrength(hero.getStrength()+2);
		hero.setDexterity(hero.getDexterity()+4);
		hero.setIntelligence(hero.getIntelligence()+2);
		hero.setVitality(hero.getVitality()+1);
		//
		hero.setCritChance(hero.getCritChance()+8);
		hero.setDodge(hero.getDodge()+4);
		hero.setSpeed(hero.getSpeed()+1);
		hero.setTrapDisarm(hero.getTrapDisarm()+40);
		hero.setResistStress(hero.getResistStress()-4);
	}
}
