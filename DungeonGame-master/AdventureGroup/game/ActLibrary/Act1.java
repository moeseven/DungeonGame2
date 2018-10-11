package game.ActLibrary;

import game.Act;
import game.Game;
import game.Player;
import game.RoomLibrary.EmptyRoom;
import game.RoomLibrary.GoblinRoom1;

public class Act1 extends Act{

	public Act1(Game game) {
		super(game);
		addRoom(game.getTown(), 4, 4);
		addRoom(new EmptyRoom(game), 3, 4);
		addRoom(new GoblinRoom1(game), 3, 3);
	}

	@Override
	public boolean checkIfActFullfilled(Player player) {
		
		return false;
	}

}
