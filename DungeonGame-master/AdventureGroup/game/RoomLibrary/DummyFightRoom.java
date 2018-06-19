package game.RoomLibrary;

import java.util.LinkedList;

import game.Game;
import game.Room;
import game.characterTypeLibrary.RaceGoblin;
import game.characterTypeLibrary.TypeWarrior;
import game.characterTypeLibrary.Weakling;
import gameEncounter.Fight;
import gameEncounter.Hero;

public class DummyFightRoom extends Room{

	public DummyFightRoom() {
		this.hasFight=true;
	}

	@Override
	public void enterRoom(Game game) {
		game.dungeonMaster.setHeroes(new LinkedList<Hero>());
		game.dungeonMaster.getHeroes().add(new Hero("", game.dungeonMaster,new Weakling(), new TypeWarrior()));
		game.dungeonMaster.getHeroes().add(new Hero("", game.dungeonMaster,new Weakling(), new TypeWarrior()));
		//game.dungeonMaster.getHeroes().add(new Hero("", game.dungeonMaster,new RaceGoblin(), new TypeWarrior()));
		this.fight= new Fight(game,game.dungeonMaster.getHeroes(), game.getPlayer().getHeroes());
		
	}
	
}
