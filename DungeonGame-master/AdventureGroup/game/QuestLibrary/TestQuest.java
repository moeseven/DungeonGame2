package game.QuestLibrary;

import java.util.LinkedList;

import game.Game;
import game.MonsterRace;
import game.Player;
import game.Quest;
import game.Room;
import game.RoomInteractionLibrary.Chest;
import game.RoomLibrary.EmptyRoom;
import game.monsters.BossNecromancer;
import gameEncounter.Hero;
import gameEncounter.Item;

public class TestQuest extends Quest{
	private Item questItem = new QuestRelic();
	public TestQuest(Game game) {
		super(game);
		// TODO Auto-generated constructor stub
		rooms.add(game.generator.generateRandomRoom(game,0,0));
		Room questRoom=new EmptyRoom(game);
		Chest questInteraction = new Chest(game);
		questInteraction.getItems().add(questItem);
		questRoom.getInteractions().add(questInteraction);
		questRoom.setHasFight(true);
		MonsterRace monster=new BossNecromancer(game);
		questRoom.getMonsters().add(new Hero("", game.dungeonMaster, monster, monster.getPositionClasses(1).getFirst()));
		rooms.add(questRoom);
		description="find the -"+questItem.getName()+"- and return it to the town.";
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
			LinkedList<String> relicNames= new LinkedList<String>();
			relicNames.add("necromancers book");
			name=relicNames.get((int) Math.min(relicNames.size()-1,(Math.random()*relicNames.size())));
			
		}

		@Override
		public void generateItemDescription() {
			// TODO Auto-generated method stub
			super.generateItemDescription();
			description.add("return this to town to gain quest rewards");
		}
		
	}
	
}

