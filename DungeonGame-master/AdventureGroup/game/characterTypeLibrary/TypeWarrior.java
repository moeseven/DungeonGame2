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
		cardPool.add("advancingAttack");
		cardPool.add("bleedingSlice");
		cardPool.add("cleave");
		cardPool.add("shortStrike");
		cardPool.add("bullWork");
		cardPool.add("ram");
		cardPool.add("mightyBlow");
		cardPool.add("parry");
		cardPool.add("intimidatingCry");
		cardPool.add("chargeAttack");
		cardPool.add("sideStep");
		cardPool.add("shieldBash");
		cardPool.add("bloodOffer");
		cardPool.add("bloodRitual");
		cardPool.add("bloodStrike");
		name="warrior";
		items.add(game.itemBuilder.buildItem("rustyBlade",3));			
		cards.add(game.cardBuilder.buildCard("meeleAttack"));
		cards.add(game.cardBuilder.buildCard("meeleAttack"));
		cards.add(game.cardBuilder.buildCard("basicAttack"));
		cards.add(game.cardBuilder.buildCard("basicAttack"));
		cards.add(game.cardBuilder.buildCard("basicAttack"));
		for (int i=0; i<6;i++) {			
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
		hero.setBleedDmg(hero.getBleedDmg()+5);
		hero.setCritChance(hero.getCritChance()+1);
		hero.setCritDamage(hero.getCritDamage()+6);
		hero.setAttackSkill(hero.getAttackSkill()+1);
		hero.setBlockSkill(hero.getBlockSkill()+6);
		hero.setResistStress(hero.getResistStress()+1);
		hero.setStunChance(hero.getStunChance()+3);
	}
}
