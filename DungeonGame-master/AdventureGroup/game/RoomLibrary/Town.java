package game.RoomLibrary;


import game.Game;
import game.Room;
import game.RoomInteractionLibrary.Altar;
import game.RoomInteractionLibrary.MedicineMan;
import game.RoomInteractionLibrary.Portal;
import game.RoomInteractionLibrary.QuestBoard;
import game.RoomInteractionLibrary.Shop;
import game.RoomInteractionLibrary.Tavern;
import game.RoomInteractionLibrary.TeleportStone;
import game.RoomInteractionLibrary.Well;
import gameEncounter.GameEquations;

public class Town extends Room{

	public Town(Game game) {
		super(game);
		getInteractions().add(new Shop(game));
		getInteractions().add(new Tavern(game));
		getInteractions().add(new MedicineMan(game)); 
		getInteractions().add(new QuestBoard(game));
		getInteractions().add(new TeleportStone(game));
		getInteractions().add(new Portal(game));
	}

	@Override
	public void enterRoom() {
		super.enterRoom();		
		game.log.addLine("Day: "+game.turn/7);
		game.questFulfilledCheck();
	}
	

}
