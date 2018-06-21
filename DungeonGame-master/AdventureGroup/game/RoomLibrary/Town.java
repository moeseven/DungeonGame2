package game.RoomLibrary;


import game.Game;
import game.Room;
import game.RoomInteractionLibrary.Shop;
import game.RoomInteractionLibrary.Well;

public class Town extends Room{

	public Town() {
		// TODO Auto-generated constructor stub
		super();
		getInteractions().add(new Shop());
	}

	@Override
	public void enterRoom(Game game) {
		// TODO Auto-generated method stub
		
	}

}
