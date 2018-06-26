package game.RoomLibrary;


import game.Game;
import game.Room;
import game.RoomInteractionLibrary.Shop;
import game.RoomInteractionLibrary.Tavern;
import game.RoomInteractionLibrary.Well;

public class Town extends Room{

	public Town(Game game) {
		// TODO Auto-generated constructor stub
		super(game);
		getInteractions().add(new Shop());
		getInteractions().add(new Tavern());
	}

}
