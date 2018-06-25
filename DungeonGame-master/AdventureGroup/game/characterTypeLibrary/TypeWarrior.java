package game.characterTypeLibrary;

import java.util.LinkedList;

import game.CharacterClass;
import gameEncounter.Hero;
import gameEncounter.Item;
import gameEncounter.CardLibrary.BasicAttack;
import gameEncounter.CardLibrary.Block;
import gameEncounter.CardLibrary.CarefulSlash;
import gameEncounter.CardLibrary.Cleave;
import gameEncounter.CardLibrary.RangedAttack;
import gameEncounter.CardLibrary.Wisdom;
import gameEncounter.ItemLibrary.RustyBlade;

public class TypeWarrior extends CharacterClass{

	public TypeWarrior() {
		cardPool.add(new BasicAttack());
		name="warrior";
		items.add(new RustyBlade());
		cards.add(new CarefulSlash());		
		for (int i=0; i<5;i++) {
			cards.add(new BasicAttack());
		}
		for (int i=0; i<4;i++) {
			cards.add(new Block());
		}
	}

	public void modifyHero(Hero hero) {
		// TODO Auto-generated method stub
		super.modifyHero(hero);
		//mainstats
		hero.setStrength(hero.getStrength()+3);
		hero.setDexterity(hero.getDexterity()+2);
		hero.setIntelligence(hero.getIntelligence()+0);
		hero.setVitality(hero.getVitality()+6);
		//
		hero.setAttackSkill(hero.getAttackSkill()+1);
		hero.setBlockSkill(hero.getBlockSkill()+1);
	}
}
