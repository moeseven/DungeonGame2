package game.characterTypeLibrary;

import game.CharacterClass;
import gameEncounter.Hero;
import gameEncounter.CardLibrary.BackStab;
import gameEncounter.CardLibrary.BasicAttack;
import gameEncounter.CardLibrary.BlindingBomb;
import gameEncounter.CardLibrary.Block;
import gameEncounter.CardLibrary.PoisonAttack;
import gameEncounter.CardLibrary.PoisonBomb;
import gameEncounter.CardLibrary.RangedAttack;
import gameEncounter.ItemLibrary.RustyBlade;

public class TypeThief extends CharacterClass{

	public TypeThief() {
		cardPool.add(new BlindingBomb());
		cardPool.add(new PoisonBomb());
		cardPool.add(new PoisonAttack());
		cardPool.add(new BackStab());
		name="thief";
		items.add(new RustyBlade());
		for (int i=0; i<8;i++) {
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
		hero.setTrapDisarm(hero.getTrapDisarm()+35);
		hero.setResistStress(hero.getResistStress()-4);
	}
}
