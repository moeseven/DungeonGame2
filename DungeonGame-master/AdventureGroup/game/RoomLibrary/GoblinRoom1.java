package game.RoomLibrary;

import java.util.LinkedList;

import game.Game;
import game.Room;
import game.RoomInteractionLibrary.Sack;
import game.RoomInteractionLibrary.Shop;
import game.characterTypeLibrary.TypeArcher;
import game.characterTypeLibrary.TypeWarrior;
import game.monsters.RaceGoblin;
import gameEncounter.Fight;
import gameEncounter.Hero;

public class GoblinRoom1 extends Room{

	public GoblinRoom1(Game game) {
		super(game);
		this.hasFight=true;
		getInteractions().add(new Sack(game,60));
		monsters.add(new Hero("", game.dungeonMaster,new RaceGoblin(game), new TypeWarrior(game)));
		monsters.add(new Hero("", game.dungeonMaster,new RaceGoblin(game), new TypeWarrior(game)));
	}
}
