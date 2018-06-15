package gameEncounter.HeroLibrary;

import java.util.LinkedList;

import gameEncounter.Card;
import gameEncounter.Deck;
import gameEncounter.Hero;
import gameEncounter.CardLibrary.Block;
import gameEncounter.CardLibrary.Cleave;
import gameEncounter.CardLibrary.BasicAttack;

public class Halfling extends Hero{

	public Halfling() {
		// TODO Auto-generated constructor stub
		this.initialize();
		good=true;
		speed=7;
		attackSkill=5;
		blockSkill=5;
		armor=0;
		manaPower=2;
		draw=4;
		maxHp=200;
		hp=maxHp;
		gold=100;
		name="Halfling";
		//deck
		deck=new Deck();
		for (int i=0; i<4;i++) {
			deck.addCard(new BasicAttack());
		}
		for (int i=0; i<5;i++) {
			deck.addCard(new Block());
		}
	}

}
