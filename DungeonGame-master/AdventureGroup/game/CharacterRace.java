package game;

import gameEncounter.Hero;
import gameEncounter.CardLibrary.BasicAttack;
import gameEncounter.CardLibrary.Block;

public abstract class CharacterRace extends CharacterType{

	public CharacterRace() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void modifyHero(Hero hero) {
		hero.setName(name);
		//deck
		for (int i=0; i<5;i++) {
			hero.getDeck().addCard(new BasicAttack());
		}
		for (int i=0; i<3;i++) {
			hero.getDeck().addCard(new Block());
		}
	}
	

}
