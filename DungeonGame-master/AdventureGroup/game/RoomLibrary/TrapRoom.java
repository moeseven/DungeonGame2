package game.RoomLibrary;


import game.Game;
import game.Room;
import game.RoomInteractionLibrary.Shop;
import game.RoomInteractionLibrary.Well;

public class TrapRoom extends Room{

	public TrapRoom() {
		// TODO Auto-generated constructor stub
		super();
		getInteractions().add(new Well());
	}

	@Override
	public void enterRoom(Game game) {
		// TODO Auto-generated method stub
		for(int i=0;i<game.getPlayer().getHeroes().size();i++) {
			game.getPlayer().getHeroes().get(i).takeDamage(game.getPlayer().getHeroes().get(i), 9);
		}		
	}

}
