package game.characterTypeLibrary;

import game.CharacterClass;
import game.Game;
import gameEncounter.Hero;
import gameEncounter.Item;
import gameEncounter.CardLibrary.Bandage;
import gameEncounter.CardLibrary.BasicAttack;

public class TypeArcher extends CharacterClass{

	public TypeArcher(Game game) {
		super(game);
		cardPool.add("poisonShot");
		cardPool.add("headShot");
		cardPool.add("concentrate");
		cardPool.add("fireArrow");
		cardPool.add("frostArrow");
		cardPool.add("bandage");
		cardPool.add("energize");
		cardPool.add("blindShot");
		name="archer";
		Item startItem = game.itemBuilder.buildItem("shortBow",6);
		startItem.setGoldValue(0);
		items.add(startItem);	
		for (int i=0; i<2;i++) {
			cards.add(game.cardBuilder.buildCard("rangedAttack"));
		}
		for (int i=0; i<5;i++) {
			cards.add(game.cardBuilder.buildCard("basicAttack"));
			cards.add(game.cardBuilder.buildCard("basicBlock"));
		}
	}

	public void modifyHero(Hero hero) {
		super.modifyHero(hero);
		if (hero.getCharRace().getName().equals("human")) {
			//hero.setImage(hero.getPlayer().getGame().imageLoader.getImage(22));
			hero.setImageNumber(22);
		}
		if (hero.getCharRace().getName().equals("dwarf")) {
			//hero.setImage(hero.getPlayer().getGame().imageLoader.getImage(33));
			hero.setImageNumber(33);
		}
		if (hero.getCharRace().getName().equals("elf")) {
			//hero.setImage(hero.getPlayer().getGame().imageLoader.getImage(26));
			hero.setImageNumber(26);
		}
		if (hero.getCharRace().getName().equals("halfling")) {
			//hero.setImage(hero.getPlayer().getGame().imageLoader.getImage(34));
			hero.setImageNumber(34);
		}
		//mainstats
		hero.setStrength(hero.getStrength()+1);
		hero.setDexterity(hero.getDexterity()+3);
		hero.setIntelligence(hero.getIntelligence()+2);
		hero.setVitality(hero.getVitality()+2);
		//
		hero.setCritChance(hero.getCritChance()+4);
		hero.setCritDamage(hero.getCritDamage()+15);
		hero.setAttackSkill(hero.getAttackSkill()+6);
		hero.setAccuracy(hero.getAccuracy()+2);
		hero.setTrapDisarm(hero.getTrapDisarm()+5);
		hero.setResistStress(hero.getResistStress()-1);
	}


}
