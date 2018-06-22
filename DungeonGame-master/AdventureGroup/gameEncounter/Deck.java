package gameEncounter;

import java.io.Serializable;
import java.util.LinkedList;

public class Deck implements Serializable{
	private LinkedList<Card> cards;
	public Deck() {
		// TODO Auto-generated constructor stub
		cards=new LinkedList<Card>();
	}
	//functions
	public void addCard(Card card) {
		cards.add(card);
	}
	//g&S
	public LinkedList<Card> getCards() {
		return cards;
	}
	public void setCards(LinkedList<Card> cards) {
		this.cards = cards;
	}
	
}
