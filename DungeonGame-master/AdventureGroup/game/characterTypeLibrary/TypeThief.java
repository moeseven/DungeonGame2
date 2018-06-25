package game.characterTypeLibrary;

import game.CharacterClass;
import gameEncounter.Hero;
import gameEncounter.CardLibrary.BackStab;
import gameEncounter.CardLibrary.BasicAttack;
import gameEncounter.CardLibrary.BlindingBomb;
import gameEncounter.CardLibrary.Block;
import gameEncounter.CardLibrary.RangedAttack;
import gameEncounter.ItemLibrary.RustyBlade;

public class TypeThief extends CharacterClass{

	public TypeThief() {
		cardPool.add(new BasicAttack());
		name="thief";
		items.add(new RustyBlade());
		cards.add(new BackStab());
		cards.add(new BlindingBomb());
		for (int i=0; i<6;i++) {
			cards.add(new BasicAttack());
		}
		for (int i=0; i<2;i++) {
			cards.add(new Block());
		}
	}

	public void modifyHero(Hero hero) {
		// TODO Auto-generated method stub
		super.modifyHero(hero);
		//mainstats
		hero.setStrength(hero.getStrength()+2);
		hero.setDexterity(hero.getDexterity()+4);
		hero.setIntelligence(hero.getIntelligence()+2);
		hero.setVitality(hero.getVitality()+1);
		//
		hero.setDodge(hero.getDodge()+1);
		hero.setSpeed(hero.getSpeed()+1);
	}
}
