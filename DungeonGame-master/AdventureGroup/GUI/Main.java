package GUI;

import java.util.LinkedList;

import game.Game;
import game.Player;
import game.RoomLibrary.GoblinRoom1;
import game.characterTypeLibrary.*;
import gameEncounter.Hero;
import gameEncounter.ItemLibrary.*;

public class Main {
	public static MainMenu mm;
	public static LinkedList<Hero> heroes;
	public static Player player;
	public static Game game;
	public static void main(String[] args) {
		heroes= new LinkedList<Hero>();
		heroes.add(new Hero("Ulmer",new RaceHuman(),new TypeWarrior()));
		heroes.getFirst().getEquipment().equipBody(new ArmorThinLeather());
		heroes.getFirst().getInventory().add(new ShortSword());
		heroes.getFirst().getInventory().add(new Buckler());
		heroes.getFirst().getInventory().add(new CrownOfThorns());
		heroes.getFirst().getInventory().add(new HeavySword());
		heroes.getFirst().getInventory().add(new PlateArmor());
		heroes.add(new Hero("Ülfi",new RaceHalfling(),new TypeWarrior()));
		heroes.getLast().setInventory(heroes.getFirst().getInventory());
		game = new Game(heroes);
		game.setNextRoom(new GoblinRoom1(game));
		player = new Player(game);
		mm=new MainMenu();
		mm.setGame(game);
		//StatsWindow gw=new StatsWindow(game);
		//FightWindow fw=new FightWindow(game,gw);
	}

}
