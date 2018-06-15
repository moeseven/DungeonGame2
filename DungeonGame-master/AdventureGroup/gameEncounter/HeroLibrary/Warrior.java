package gameEncounter.HeroLibrary;

import java.util.LinkedList;

import gameEncounter.Card;
import gameEncounter.Deck;
import gameEncounter.Hero;
import gameEncounter.CardLibrary.Block;
import gameEncounter.CardLibrary.Cleave;
import gameEncounter.CardLibrary.BasicAttack;

public class Warrior extends Hero{

	public Warrior() {
		// TODO Auto-generated constructor stub
		this.initialize();
		good=true;
		speed=6;
		attackSkill=10;
		blockSkill=8;
		armor=1;
		manaPower=3;
		draw=4;
		maxHp=500;
		hp=maxHp;
		gold=100;
		name="Warrior";
		//deck
		deck=new Deck();
		for (int i=0; i<5;i++) {
			deck.addCard(new BasicAttack());
		}
		for (int i=0; i<5;i++) {
			deck.addCard(new Block());
		}
		deck.addCard(new Cleave());
	}

}
