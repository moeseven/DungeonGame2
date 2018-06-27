package GUI;

import java.util.LinkedList;

import game.Game;
import game.GeneratorRandom;
import game.Player;
import game.Room;
import game.RoomLibrary.GoblinRoom1;
import game.RoomLibrary.Town;
import game.RoomLibrary.TrapRoom;
import game.characterTypeLibrary.*;
import gameEncounter.Hero;
import gameEncounter.Item;
import gameEncounter.ItemLibrary.*;

public class Main {
	public static MainMenu mm;
	public static LinkedList<Hero> heroes;
	public static LinkedList<Item> items;
	public static Player player;
	public static Game game;
	public static void main(String[] args) {
		game = new Game();
		player = new Player(game);
		game.setPlayer(player);	
//		game.getRoomChain().add(new TrapRoom(game));
//		game.getRoomChain().add(game.generator.generateRandomRoom(game));
//		game.getRoomChain().add(game.generator.generateRandomRoom(game));
//		game.getRoomChain().add(game.generator.generateRandomRoom(game));
//		game.getRoomChain().add(game.generator.generateRandomRoom(game));
//		game.getRoomChain().add(game.generator.generateRandomRoom(game));	
//		game.getRoomChain().add(new GoblinRoom1(game));
//		game.getRoomChain().add(new GoblinRoom1(game));
		mm=new MainMenu();
		mm.setGame(game);
		//StatsWindow gw=new StatsWindow(game);
		//FightWindow fw=new FightWindow(game,gw);
	}

}
