package game.characterTypeLibrary;

import game.CharacterClass;
import gameEncounter.Hero;
import gameEncounter.CardLibrary.BasicAttack;
import gameEncounter.CardLibrary.Block;
import gameEncounter.CardLibrary.Concentrate;
import gameEncounter.CardLibrary.DivineGrace;
import gameEncounter.CardLibrary.FireArrow;
import gameEncounter.CardLibrary.FrostArrow;
import gameEncounter.CardLibrary.HeadShot;
import gameEncounter.CardLibrary.RangedAttack;
import gameEncounter.CardLibrary.RangedPoison;
import gameEncounter.ItemLibrary.GoblinBow;
import gameEncounter.ItemLibrary.RustyBlade;
import gameEncounter.ItemLibrary.ShortBow;

public class TypeArcher extends CharacterClass{

	public TypeArcher() {
		cardPool.add(new RangedPoison());
		cardPool.add(new HeadShot());
		cardPool.add(new Concentrate());
		cardPool.add(new FireArrow());
		cardPool.add(new FrostArrow());
		name="archer";
		items.add(new GoblinBow());		
		for (int i=0; i<7;i++) {
			cards.add(new RangedAttack());
		}
		cards.add(new BasicAttack());
		cards.add(new Block());
		cards.add(new Block());
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
