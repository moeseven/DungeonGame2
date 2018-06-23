package game.RoomLibrary;

import java.util.LinkedList;

import game.Game;
import game.Room;
import game.characterTypeLibrary.RaceGoblin;
import game.characterTypeLibrary.TypeArcher;
import game.characterTypeLibrary.TypeWarrior;
import gameEncounter.Fight;
import gameEncounter.Hero;

public class GoblinRoom1 extends Room{

	public GoblinRoom1() {
		this.hasFight=true;
	}

	@Override
	public void enterRoom(Game game) {
		game.dungeonMaster.setHeroes(new LinkedList<Hero>());
		game.dungeonMaster.addHero(new Hero("", game.dungeonMaster,new RaceGoblin(), new TypeWarrior()));
		game.dungeonMaster.addHero(new Hero("", game.dungeonMaster,new RaceGoblin(), new TypeWarrior()));
		game.dungeonMaster.addHero(new Hero("", game.dungeonMaster,new RaceGoblin(), new TypeArcher()));
		this.fight= new Fight(game,game.dungeonMaster.getHeroes(), game.getPlayer().getHeroes());
		
	}
	
}
