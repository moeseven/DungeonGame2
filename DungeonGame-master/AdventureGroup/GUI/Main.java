package GUI;

import java.util.LinkedList;

import GUI.grafics.StaticImageLoader;
import game.Game;
import game.Player;
import game.Leaderboard.Leaderboard;
import gameEncounter.Hero;
import gameEncounter.Item;

public class Main {
	public static MainMenu mm;
	public static LinkedList<Hero> heroes;
	public static LinkedList<Item> items;
	public static Player player;
	public static Game game;
	public static void main(String[] args) {
		//StaticImageLoader.prepareImage(); //do this when there are new images to load
//		Leaderboard lb= new Leaderboard();
//		lb.writeToFile();
		game = new Game();
		player = new Player(game);
		game.setPlayer(player);	
		mm=new MainMenu();
		mm.setGame(game);
	}

}
