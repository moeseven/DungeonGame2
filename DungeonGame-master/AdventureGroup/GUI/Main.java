package GUI;

import java.util.LinkedList;

import game.Game;
import game.Player;
import game.Room;
import game.RoomLibrary.GoblinRoom1;
import game.RoomLibrary.Town;
import game.characterTypeLibrary.*;
import gameEncounter.Hero;
import gameEncounter.Item;
import gameEncounter.ItemLibrary.*;
import sun.security.util.LegacyAlgorithmConstraints;

public class Main {
	public static MainMenu mm;
	public static LinkedList<Hero> heroes;
	public static LinkedList<Item> items;
	public static Player player;
	public static LinkedList<Room> roomChain;
	public static Game game;
	public static void main(String[] args) {
		heroes= new LinkedList<Hero>();
		roomChain=new LinkedList<Room>();
		roomChain.add(new Town());
		roomChain.add(new GoblinRoom1());		
		game = new Game(roomChain);
		player = new Player(game);
		game.setPlayer(player);
		items= new LinkedList<Item>();
		items.add(new ShortSword());
		items.add(new Buckler());
		items.add(new CrownOfThorns());
		items.add(new HeavySword());
		items.add(new PlateArmor());
		items.add(new ArmorThinLeather());
		player.setInventory(items);
		heroes.add(new Hero("Ulmer",player,new RaceHuman(),new TypeWarrior()));		
		heroes.add(new Hero("Ülfi",player,new RaceHalfling(),new TypeWarrior()));
		player.setHeroes(heroes);
		mm=new MainMenu();
		mm.setGame(game);
		//StatsWindow gw=new StatsWindow(game);
		//FightWindow fw=new FightWindow(game,gw);
	}

}
