package game.characterTypeLibrary;

import game.CharacterClass;
import gameEncounter.Hero;
import gameEncounter.CardLibrary.DivineGrace;
import gameEncounter.ItemLibrary.RustyBlade;


public class TypeCleric extends CharacterClass{

	public TypeCleric() {
		name="cleric";
		items.add(new RustyBlade());
		cards.add(new DivineGrace());
	}

	public void modifyHero(Hero hero) {
		// TODO Auto-generated method stub
		super.modifyHero(hero);
		hero.setSpellResist(hero.getSpellResist()+1);
		hero.setSpellPower(hero.getSpellPower()+1);
	}

	@Override
	public String getInfo() {
		// TODO Auto-generated method stub
		return "cleric";
	}

}
