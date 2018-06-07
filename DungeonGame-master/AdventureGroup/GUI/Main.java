package GUI;

import java.util.LinkedList;

import game.Game;
import game.Player;
import game.RoomLibrary.GoblinRoom1;
import gameEncounter.Hero;
import gameEncounter.HeroLibrary.Warrior;
import gameEncounter.ItemLibrary.*;

public class Main {
	public static LinkedList<Hero> heroes;
	public static Player player;
	public static Game game;
	public static void main(String[] args) {
		heroes= new LinkedList<Hero>();
		heroes.add(new Warrior());
		heroes.getFirst().getEquipment().equipBody(new ArmorThinLeather());
		heroes.getFirst().getInventory().add(new ShortSword());
		heroes.getFirst().getInventory().add(new Buckler());
		heroes.getFirst().getInventory().add(new CrownOfThorns());
		heroes.getFirst().getInventory().add(new HeavySword());
		game = new Game(heroes);
		game.enterRoom(new GoblinRoom1(heroes));
		player = new Player(game);
		GameWindow gw=new GameWindow(game);
		//FightWindow fw=new FightWindow(game,gw);
	}

}
