package game.characterTypeLibrary;

import game.CharacterClass;
import gameEncounter.Hero;
import gameEncounter.CardLibrary.Bash;
import gameEncounter.CardLibrary.BasicAttack;
import gameEncounter.CardLibrary.Block;
import gameEncounter.CardLibrary.DivineGrace;
import gameEncounter.CardLibrary.Harden;
import gameEncounter.CardLibrary.HeavenlyShield;
import gameEncounter.CardLibrary.HeavenlyStrength;
import gameEncounter.CardLibrary.MeeleAttack;
import gameEncounter.CardLibrary.RangedAttack;
import gameEncounter.ItemLibrary.RustyBlade;


public class TypeCleric extends CharacterClass{

	public TypeCleric() {
		cardPool.add(new Bash());
		cardPool.add(new DivineGrace());
		cardPool.add(new HeavenlyShield());
		cardPool.add(new HeavenlyStrength());
		cardPool.add(new Harden());
		
		name="cleric";
		items.add(new RustyBlade());		
		for (int i=0; i<3;i++) {
			cards.add(new BasicAttack());
		}
		cards.add(new MeeleAttack());
		cards.add(new MeeleAttack());
		for (int i=0; i<5;i++) {
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
		hero.setResistStress(hero.getResistStress()+8);
	}

}
