package GUI;

import java.util.LinkedList;

import game.Game;
import game.Player;
import game.RoomLibrary.GoblinRoom1;
import gameEncounter.Hero;
import gameEncounter.HeroLibrary.Warrior;

public class Main {
	public static LinkedList<Hero> heroes;
	public static Player player;
	public static Game game;
	public static void main(String[] args) {
		heroes= new LinkedList<Hero>();
		heroes.add(new Warrior());
		game = new Game(heroes);
		game.enterRoom(new GoblinRoom1(heroes));
		player = new Player(game);
		new GameWindow(game);
	}

}
