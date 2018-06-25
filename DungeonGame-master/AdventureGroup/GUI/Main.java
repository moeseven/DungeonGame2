package GUI;

import java.util.LinkedList;

import game.Game;
import game.Player;
import game.Room;
import game.RoomLibrary.DummyFightRoom;
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
	public static LinkedList<Room> roomChain;
	public static Game game;
	public static void main(String[] args) {
		
		roomChain=new LinkedList<Room>();
		roomChain.add(new TrapRoom());
		roomChain.add(new GoblinRoom1());
		roomChain.add(new TrapRoom());		
		roomChain.add(new GoblinRoom1());
		game = new Game(roomChain);
		player = new Player(game);
		game.setPlayer(player);	
		heroes= new LinkedList<Hero>();
		heroes.add(new Hero("Irbal", player,new RaceElf(), new TypeArcher()));
		heroes.add(new Hero("Mandor",player,new RaceHuman(),new TypeWarrior()));		
		heroes.add(new Hero("Filt",player,new RaceHalfling(),new TypeThief()));
			
		player.setAvailableHeroes(heroes);
		player.setGold(200);

		mm=new MainMenu();
		mm.setGame(game);
		//StatsWindow gw=new StatsWindow(game);
		//FightWindow fw=new FightWindow(game,gw);
	}

}
