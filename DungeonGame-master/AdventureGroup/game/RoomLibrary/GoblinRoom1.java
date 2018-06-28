package game.RoomLibrary;

import java.util.LinkedList;

import game.Game;
import game.Room;
import game.characterTypeLibrary.TypeArcher;
import game.characterTypeLibrary.TypeWarrior;
import game.monsters.RaceGoblin;
import gameEncounter.Fight;
import gameEncounter.Hero;

public class GoblinRoom1 extends Room{

	public GoblinRoom1(Game game) {
		super(game);
		this.hasFight=true;
		monsters.add(new Hero("", game.dungeonMaster,new RaceGoblin(), new TypeWarrior()));
		monsters.add(new Hero("", game.dungeonMaster,new RaceGoblin(), new TypeWarrior()));
		monsters.add(new Hero("", game.dungeonMaster,new RaceGoblin(), new TypeArcher()));
	}
}
