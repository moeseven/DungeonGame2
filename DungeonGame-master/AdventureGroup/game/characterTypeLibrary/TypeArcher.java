package game.characterTypeLibrary;

import game.CharacterClass;
import gameEncounter.Hero;
import gameEncounter.CardLibrary.BasicAttack;
import gameEncounter.CardLibrary.Block;
import gameEncounter.CardLibrary.DivineGrace;
import gameEncounter.CardLibrary.RangedAttack;
import gameEncounter.ItemLibrary.GoblinBow;
import gameEncounter.ItemLibrary.RustyBlade;
import gameEncounter.ItemLibrary.ShortBow;

public class TypeArcher extends CharacterClass{

	public TypeArcher() {
		cardPool.add(new RangedAttack());
		name="archer";
		items.add(new GoblinBow());		
		for (int i=0; i<10;i++) {
			cards.add(new RangedAttack());
		}
	}

	public void modifyHero(Hero hero) {
		// TODO Auto-generated method stub
		super.modifyHero(hero);
		//mainstats
		hero.setStrength(hero.getStrength()+1);
		hero.setDexterity(hero.getDexterity()+3);
		hero.setIntelligence(hero.getIntelligence()+2);
		hero.setVitality(hero.getVitality()+2);
		//
		hero.setAccuracy(hero.getAccuracy()+2);
	}


}
