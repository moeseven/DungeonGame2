package game.characterTypeLibrary;

import game.CharacterClass;
import gameEncounter.Hero;
import gameEncounter.CardLibrary.Block;
import gameEncounter.CardLibrary.Channel;
import gameEncounter.CardLibrary.FireBall;
import gameEncounter.CardLibrary.Magicmissile;
import gameEncounter.CardLibrary.RangedAttack;
import gameEncounter.CardLibrary.SleepCharm;
import gameEncounter.CardLibrary.Wisdom;
import gameEncounter.ItemLibrary.RustyBlade;

public class TypeMage extends CharacterClass{

	public TypeMage() {
		cardPool.add(new Magicmissile());
		name="mage";
		items.add(new RustyBlade());
		cards.add(new Block());
		cards.add(new Block());
		cards.add(new SleepCharm());
		cards.add(new Wisdom());
		cards.add(new Channel());		
		cards.add(new Magicmissile());
		cards.add(new Magicmissile());
		cards.add(new Magicmissile());
		cards.add(new Magicmissile());
		cards.add(new FireBall());
	}

	public void modifyHero(Hero hero) {
		// TODO Auto-generated method stub
		super.modifyHero(hero);
		//mainstats
		hero.setStrength(hero.getStrength()+0);
		hero.setDexterity(hero.getDexterity()+1);
		hero.setIntelligence(hero.getIntelligence()+6);
		hero.setVitality(hero.getVitality()+1);
		//
		hero.setSpellPower(hero.getSpellPower()+2);		
	}
}
