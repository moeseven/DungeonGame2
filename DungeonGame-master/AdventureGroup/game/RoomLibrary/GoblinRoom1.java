package game.RoomLibrary;

import java.util.LinkedList;

import game.Game;
import game.Room;
import gameEncounter.Fight;
import gameEncounter.Hero;
import gameEncounter.HeroLibrary.Goblin;

public class GoblinRoom1 extends Room{

	public GoblinRoom1(Game game, LinkedList<Hero> heroes) {
		super(game,heroes);
		this.hasFight=true;
	}

	@Override
	public void enterRoom() {
		LinkedList<Hero> foes=new LinkedList<Hero>();
		foes.add(new Goblin());
		foes.add(new Goblin());
		this.fight= new Fight(game,foes, heroes);
		
	}
	
}
