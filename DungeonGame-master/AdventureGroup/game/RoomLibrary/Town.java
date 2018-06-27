package game.RoomLibrary;


import game.Game;
import game.Room;
import game.RoomInteractionLibrary.QuestBoard;
import game.RoomInteractionLibrary.Shop;
import game.RoomInteractionLibrary.Tavern;
import game.RoomInteractionLibrary.Well;

public class Town extends Room{
	private int idleStressRelief=5;
	public Town(Game game) {
		// TODO Auto-generated constructor stub
		super(game);
		getInteractions().add(new Shop());
		getInteractions().add(new Tavern());
		getInteractions().add(new QuestBoard());
	}

	@Override
	public void enterRoom() {
		// TODO Auto-generated method stub
		super.enterRoom();
		for(int i=0; i<game.getPlayer().getAvailableHeroes().size();i++) {
			game.getPlayer().getAvailableHeroes().get(i).becomeStressed(-idleStressRelief);
		}		
		game.getActiveQuest().onReturnToTown(game.getPlayer());
		game.newQuest();
	}
	

}
