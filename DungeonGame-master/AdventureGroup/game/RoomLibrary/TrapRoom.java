package game.RoomLibrary;


import game.Game;
import game.Room;
import game.RoomInteractionLibrary.Shop;
import game.RoomInteractionLibrary.SpikeTrap;
import game.RoomInteractionLibrary.Well;

public class TrapRoom extends Room{

	public TrapRoom() {
		// TODO Auto-generated constructor stub
		super();
		getInteractions().add(new SpikeTrap());
	}

	@Override
	public void enterRoom(Game game) {
		// TODO Auto-generated method stub
		
	}

}
