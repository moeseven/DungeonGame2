package game.characterTypeLibrary;

import game.CharacterClass;
import gameEncounter.Hero;
import gameEncounter.CardLibrary.SleepCharm;
import gameEncounter.CardLibrary.Wisdom;
import gameEncounter.ItemLibrary.RustyBlade;

public class TypeMage extends CharacterClass{

	public TypeMage() {
		name="mage";
		items.add(new RustyBlade());
		cards.add(new SleepCharm());
		cards.add(new Wisdom());
	}

	public void modifyHero(Hero hero) {
		// TODO Auto-generated method stub
		super.modifyHero(hero);
		hero.setSpellPower(hero.getSpellPower()+2);		
		hero.setVitality(hero.getVitality()-3);
	}
}
