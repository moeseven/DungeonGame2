package game.RoomLibrary;


import game.Game;
import game.Room;
import game.RoomInteractionLibrary.Shop;
import game.RoomInteractionLibrary.SpikeTrap;
import game.RoomInteractionLibrary.Well;

public class TrapRoom extends Room{

	public TrapRoom(Game game) {
		// TODO Auto-generated constructor stub
		super(game);
		getInteractions().add(new SpikeTrap(game));
	}


}
