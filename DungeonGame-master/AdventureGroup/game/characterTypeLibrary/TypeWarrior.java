package game.characterTypeLibrary;

import java.util.LinkedList;

import game.CharacterClass;
import gameEncounter.Hero;
import gameEncounter.Item;
import gameEncounter.CardLibrary.Cleave;
import gameEncounter.ItemLibrary.RustyBlade;

public class TypeWarrior extends CharacterClass{

	public TypeWarrior() {
		name="warrior";
		items.add(new RustyBlade());
	}

	public void modifyHero(Hero hero) {
		// TODO Auto-generated method stub
		super.modifyHero(hero);
		hero.setAttackSkill(hero.getAttackSkill()+1);
		hero.setBlockSkill(hero.getBlockSkill()+1);
		hero.setVitality(hero.getVitality()+2);
	}
}
