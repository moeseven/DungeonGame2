package game.characterTypeLibrary;

import java.util.LinkedList;

import game.CharacterClass;
import game.Game;
import gameEncounter.Hero;
import gameEncounter.Item;
import gameEncounter.ItemLibrary.RustyBlade;

public class TypeWarrior extends CharacterClass{

	public TypeWarrior(Game game) {
		super(game);
		cardPool.add("carefulSlash");
		cardPool.add("bleedingSlice");
		cardPool.add("cleave");
		cardPool.add("bash");
		cardPool.add("bullWork");
		cardPool.add("ram");
		cardPool.add("mightyBlow");
		cardPool.add("parry");
		cardPool.add("intimidatingCry");
		name="warrior";
		items.add(game.itemBuilder.buildItem("rustyBlade",3));			
		for (int i=0; i<2;i++) {
			cards.add(game.cardBuilder.buildCard("carefulSlash"));
		}		
		for (int i=0; i<5;i++) {
			cards.add(game.cardBuilder.buildCard("basicAttack"));
			cards.add(game.cardBuilder.buildCard("basicBlock"));
		}
//		cards.add(game.cardBuilder.buildCard("carefulSlash"));
//		cards.add(game.cardBuilder.buildCard("bleedingSlice"));
//		cards.add(game.cardBuilder.buildCard("cleave"));
//		cards.add(game.cardBuilder.buildCard("bash"));
//		cards.add(game.cardBuilder.buildCard("ram"));
//		cards.add(game.cardBuilder.buildCard("mightyBlow"));
//		cards.add(game.cardBuilder.buildCard("parry"));
//		cards.add(game.cardBuilder.buildCard("intimidatingCry"));
	}

	public void modifyHero(Hero hero) {
		// TODO Auto-generated method stub
		super.modifyHero(hero);
		//mainstats
		hero.setStrength(hero.getStrength()+3);
		hero.setDexterity(hero.getDexterity()+2);
		hero.setIntelligence(hero.getIntelligence()+0);
		hero.setVitality(hero.getVitality()+5);
		//
		hero.setCritChance(hero.getCritChance()+1);
		hero.setCritDamage(hero.getCritDamage()+6);
		hero.setAttackSkill(hero.getAttackSkill()+1);
		hero.setBlockSkill(hero.getBlockSkill()+6);
		hero.setResistStress(hero.getResistStress()+1);
	}
}
