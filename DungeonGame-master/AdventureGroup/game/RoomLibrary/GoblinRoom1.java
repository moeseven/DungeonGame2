package game.RoomLibrary;

import java.util.LinkedList;

import game.Game;
import game.Room;
import game.characterTypeLibrary.RaceGoblin;
import game.characterTypeLibrary.TypeWarrior;
import gameEncounter.Fight;
import gameEncounter.Hero;

public class GoblinRoom1 extends Room{

	public GoblinRoom1() {
		this.hasFight=true;
	}

	@Override
	public void enterRoom(Game game) {
		LinkedList<Hero> foes=new LinkedList<Hero>();
		foes.add(new Hero("", new RaceGoblin(), new TypeWarrior()));
		foes.add(new Hero("", new RaceGoblin(), new TypeWarrior()));
		this.fight= new Fight(game,foes, game.getPlayer().getHeroes());
		
	}
	
}
