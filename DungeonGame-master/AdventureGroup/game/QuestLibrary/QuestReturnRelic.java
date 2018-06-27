package game.QuestLibrary;

import game.Game;
import game.Player;
import game.Quest;
import game.Room;
import game.RoomInteractionLibrary.Chest;
import game.RoomLibrary.EmptyRoom;
import gameEncounter.Item;

public class QuestReturnRelic extends Quest{
	private Item questItem = new QuestRelic();
	public QuestReturnRelic(Game game) {
		super(game);
		// TODO Auto-generated constructor stub
		for(int i=0; i<5; i++) {
			rooms.add(game.generator.generateRandomRoom(game,0.2,0));
		}
		rooms.add(game.generator.generateRandomRoom(game,1,0));
		Room questRoom=new EmptyRoom(game);
		Chest questInteraction = new Chest();
		questInteraction.getItems().add(questItem);
		questRoom.getInteractions().add(questInteraction);
		rooms.add(questRoom);
		description="find the "+questItem.getName()+" and return it to the town.";
		goldReward=500;
		experienceReward=700;
	}
	public boolean checkIfQuestFullfilled(Player player) {
		if(player.getInventory().contains(questItem)) {
			giveReward(player);
			player.getInventory().remove(questItem);
			return true;
		}
		return false;
	}	
	
	
	private class QuestRelic extends Item{

		public QuestRelic() {
			super();
			// TODO Auto-generated constructor stub
			name="mandral star";
			
		}

		@Override
		public void generateItemDescription() {
			// TODO Auto-generated method stub
			super.generateItemDescription();
			description.add("return this to town to gain quest rewards");
		}
		
	}
	
}

