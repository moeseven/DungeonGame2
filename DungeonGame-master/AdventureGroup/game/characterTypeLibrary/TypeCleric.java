package game.characterTypeLibrary;

import game.CharacterClass;
import gameEncounter.Hero;
import gameEncounter.CardLibrary.BasicAttack;
import gameEncounter.CardLibrary.Block;
import gameEncounter.CardLibrary.DivineGrace;
import gameEncounter.CardLibrary.RangedAttack;
import gameEncounter.ItemLibrary.RustyBlade;


public class TypeCleric extends CharacterClass{

	public TypeCleric() {
		cardPool.add(new BasicAttack());
		name="cleric";
		items.add(new RustyBlade());
		cards.add(new DivineGrace());
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
		hero.setDexterity(hero.getDexterity()+0);
		hero.setIntelligence(hero.getIntelligence()+4);
		hero.setVitality(hero.getVitality()+5);
		//
		hero.setSpellResist(hero.getSpellResist()+1);
		hero.setSpellPower(hero.getSpellPower()+1);
	}

}
