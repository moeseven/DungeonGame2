package game;

import gameEncounter.Card;


public class TestMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Game game =new Game();
		Card card=game.cardBuilder.buildCard("basicBlock");
		System.out.println(card.toString());
	}

}
