package gameEncounter.HeroLibrary;

import java.util.LinkedList;

import gameEncounter.Card;
import gameEncounter.Deck;
import gameEncounter.Hero;
import gameEncounter.CardLibrary.Block;
import gameEncounter.CardLibrary.Cleave;
import gameEncounter.CardLibrary.MeeleAttack;

public class Warrior extends Hero{

	public Warrior() {
		// TODO Auto-generated constructor stub
		this.initialize();
		good=true;
		turnBlock=0;
		turnMana=3;
		turnDraw=4;
		maxHp=500;
		hp=maxHp;
		gold=100;
		name="Warrior";
		//deck
		deck=new Deck();
		for (int i=0; i<5;i++) {
			deck.addCard(new MeeleAttack());
		}
		for (int i=0; i<5;i++) {
			deck.addCard(new Block());
		}
		deck.addCard(new Cleave());
	}

}
