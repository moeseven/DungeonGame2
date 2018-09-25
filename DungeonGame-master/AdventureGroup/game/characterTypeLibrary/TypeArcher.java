package game.characterTypeLibrary;

import game.CharacterClass;
import game.Game;
import gameEncounter.Hero;
import gameEncounter.CardLibrary.Bandage;
import gameEncounter.CardLibrary.BasicAttack;
import gameEncounter.CardLibrary.Block;
import gameEncounter.CardLibrary.Concentrate;
import gameEncounter.CardLibrary.DivineGrace;
import gameEncounter.CardLibrary.FireArrow;
import gameEncounter.CardLibrary.FrostArrow;
import gameEncounter.CardLibrary.HeadShot;
import gameEncounter.CardLibrary.RangedAttack;
import gameEncounter.CardLibrary.PoisonShot;
import gameEncounter.ItemLibrary.GoblinBow;
import gameEncounter.ItemLibrary.RustyBlade;
import gameEncounter.ItemLibrary.ShortBow;

public class TypeArcher extends CharacterClass{

	public TypeArcher(Game game) {
		super(game);
		cardPool.add("poisonShot");
		cardPool.add("headShot");
		cardPool.add("concentrate");
		cardPool.add("fireArrow");
		cardPool.add("frostArrow");
		cardPool.add("bandage");
		name="archer";
		items.add(game.itemBuilder.buildItem("rustyBlade"));	
		for (int i=0; i<7;i++) {
			cards.add(game.cardBuilder.buildCard("rangedAttack"));
		}
		cards.add(game.cardBuilder.buildCard("basicAttack"));
		cards.add(game.cardBuilder.buildCard("basicBlock"));
		cards.add(game.cardBuilder.buildCard("basicBlock"));
	}

	public void modifyHero(Hero hero) {
		super.modifyHero(hero);
		if (hero.getCharRace().getName().equals("human")) {
			hero.setImage(hero.getPlayer().getGame().imageLoader.getImage(22));
		}
		if (hero.getCharRace().getName().equals("dwarf")) {
			hero.setImage(hero.getPlayer().getGame().imageLoader.getImage(33));
		}
		if (hero.getCharRace().getName().equals("elf")) {
			hero.setImage(hero.getPlayer().getGame().imageLoader.getImage(26));
		}
		if (hero.getCharRace().getName().equals("halfling")) {
			hero.setImage(hero.getPlayer().getGame().imageLoader.getImage(34));
		}
		//mainstats
		hero.setStrength(hero.getStrength()+1);
		hero.setDexterity(hero.getDexterity()+3);
		hero.setIntelligence(hero.getIntelligence()+2);
		hero.setVitality(hero.getVitality()+2);
		//
		hero.setCritChance(hero.getCritChance()+4);
		hero.setAttackSkill(hero.getAttackSkill()+2);
		hero.setAccuracy(hero.getAccuracy()+2);
		hero.setTrapDisarm(hero.getTrapDisarm()+5);
		hero.setResistStress(hero.getResistStress()-1);
	}


}
