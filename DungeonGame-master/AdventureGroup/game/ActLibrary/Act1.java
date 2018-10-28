package game.ActLibrary;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

import GUI.LeaderboardWindow;
import game.Act;
import game.CharacterRace;
import game.Game;
import game.GeneratorRandom;
import game.MonsterRace;
import game.Player;
import game.Quest;
import game.Room;
import game.RoomInteraction;
import game.Leaderboard.Leaderboard;
import game.RoomInteractionLibrary.*;
import game.RoomLibrary.EmptyRoom;
import game.RoomLibrary.GoblinRoom1;
import game.monsters.BossNecromancer;
import game.monsters.RaceGoblin;
import game.monsters.RaceRat;
import game.monsters.RaceZombie;
import gameEncounter.Hero;
import gameEncounter.Item;

public class Act1 extends Act{
	protected Room room;
	protected RoomInteraction interaction;
	HashMap<MonsterRace,Integer> act1Monsters= new HashMap<MonsterRace,Integer>();
	protected MonsterRace monster;
	public Act1(Game game) {
		super(game);
		//possible monsters	in act1
		act1Monsters.put(new RaceGoblin(game),1);
		act1Monsters.put(new RaceGoblin(game),2);
		act1Monsters.put(new RaceGoblin(game),2);
		act1Monsters.put(new RaceGoblin(game),2);
		act1Monsters.put(new RaceGoblin(game),3);
		act1Monsters.put(new RaceGoblin(game),3);
		act1Monsters.put(new RaceGoblin(game),3);
		act1Monsters.put(new RaceZombie(game),2);
		act1Monsters.put(new RaceRat(game),2);
		act1Monsters.put(new RaceRat(game),3);
		act1Monsters.put(new RaceRat(game),4);
		//start room
		room=new EmptyRoom(game);
		room.getInteractions().add(new Sack(game, 15));
		startRoom=room;
		addRoom(room, 4, 0);
		//tutorial fight room
		room=new EmptyRoom(game);
		monster=new RaceRat(game);
		room.addMonster(new Hero("", game.dungeonMaster, monster, monster.getPositionClasses(5).getFirst()));
		addRoom(room, 4, 1);
		//meet mate room
		room=new EmptyRoom(game);
		interaction=new SeekingHero(game, 30);
		room.getInteractions().add(interaction);
		addRoom(room, 4, 2);
		//first goblin
		room=new EmptyRoom(game);
		interaction=new Chest(game);
		room.getInteractions().add(interaction);
		monster=new RaceGoblin(game);
		room.addMonster(new Hero("", game.dungeonMaster, monster, monster.getPositionClasses(1).getFirst()));
		addRoom(room, 4, 3);
		//town
		addRoom(game.getTown(), 4, 4);
		//test room
		room=new EmptyRoom(game);
		interaction = new Altar(game);
		room.setHasFight(true);
		monster=new BossNecromancer(game);
		room.addMonster(new Hero("", game.dungeonMaster, monster, monster.getPositionClasses(5).getFirst()));
		room.getInteractions().add(interaction);
		//addRoom(questRoom, 4, 5);
		//room 6,4
		addRoom(new EmptyRoom(game), 6, 4);
		//room 6,3
		addRoom(new GoblinRoom1(game), 6, 3);
		//room 9,3
		room=new EmptyRoom(game);
		interaction = new SleepingOgre(game);
		room.getInteractions().add(interaction);
		addRoom(room, 9, 3);
		//room 2,2
		room=new EmptyRoom(game);
		interaction= new Altar(game);
		room.getInteractions().add(interaction);
		addRandomRoom(2,2);
		//room 2,3
		room=new EmptyRoom(game);
		interaction = new HayHeap(game);
		room.getInteractions().add(interaction);
		addRoom(room, 2, 3);
		//room 1,3
		room=new EmptyRoom(game);
		interaction = new Sack(game,35);		
		room.getInteractions().add(interaction);
		interaction = new Sack(game,45);
		room.getInteractions().add(interaction);
		addRoom(room, 1, 3);
		//room 6,6
		room=new EmptyRoom(game);
		interaction = new Chest(game);
		room.getInteractions().add(interaction);
		room.setHasFight(true);
		monster=new RaceGoblin(game);
		room.addMonster(new Hero("", game.dungeonMaster, monster, monster.getPositionClasses(5).getFirst()));
		room.addMonster(new Hero("", game.dungeonMaster, monster, monster.getPositionClasses(1).getFirst()));
		room.addMonster(new Hero("", game.dungeonMaster, monster, monster.getPositionClasses(1).getFirst()));
		
		addRoom(room, 6, 6);
		//room 2,0 ~~~main act quest~~~		
		mainQuest=new Act1Finish(game);
		addRoom(mainQuest.getRooms().getFirst(), 2, 0);
		//room 2,1
		room=new EmptyRoom(game);
		interaction = new Chest(game);
		room.getInteractions().add(interaction);
		room.getInteractions().add(new UndeadCorpse(game,30,(int) Math.random()*50));
		room.getInteractions().add(new UndeadCorpse(game,90,(int) Math.random()*50));
		addRoom(room, 2,1);
		//room 8,7
		room=new EmptyRoom(game);
		interaction= new Sack(game, 30);
		room.getInteractions().add(interaction);
		interaction = new Well(game);
		room.getInteractions().add(interaction);
		interaction= new Sack(game, 30);
		room.getInteractions().add(interaction);
		addRoom(room, 8,7);
		//room 8,6
		room=new EmptyRoom(game);
		interaction = new Chest(game);
		room.getInteractions().add(interaction);
		addRoom(room, 8,6);
		//room 8,5
		room=new EmptyRoom(game);
		interaction = new Well(game);
		room.getInteractions().add(interaction);
		addRoom(room, 8,5);
		//room 5,4
		room=new EmptyRoom(game);
		interaction = new AncientTome(game);
		room.getInteractions().add(interaction);
		addRoom(room, 5, 4);
		//room 9,6
		room=new EmptyRoom(game);
		Chest chest = new Chest(game);
		chest.setGold(chest.getGold()+50);
		room.getInteractions().add(chest);
		monster=new RaceGoblin(game);
		for (int i = 1; i < 6; i++) {
			room.addMonster(new Hero("", game.dungeonMaster,monster, monster.getPositionClasses(i).get((int) Math.min(monster.getPositionClasses(i).size()-1, Math.random()*monster.getPositionClasses(i).size()))));
		}
		room.setHasFight(true);
		addRoom(room,9, 6);
		//room 7,1
		room=new EmptyRoom(game);
		monster=new RaceGoblin(game);
		for (int i = 4; i > 1; i--) {
			room.addMonster(new Hero("", game.dungeonMaster,monster, monster.getPositionClasses(i).get((int) Math.min(monster.getPositionClasses(i).size()-1, Math.random()*monster.getPositionClasses(i).size()))));
		}
		room.setHasFight(true);;
		addRoom(room, 7, 1);
		//room 7,0
		room=new EmptyRoom(game);
		chest = new Chest(game);
		chest.setGold(chest.getGold()+100);
		interaction=new AncientTome(game);
		room.getInteractions().add(interaction);
		room.getInteractions().add(chest);
		interaction=new AncientTome(game);
		room.getInteractions().add(interaction);
		addRoom(room, 7, 0);
		//room 4,7
		room=new EmptyRoom(game);
		chest = new Chest(game);
		chest.setGold(chest.getGold()+20);
		room.getInteractions().add(chest);
		monster=new RaceGoblin(game);
		for (int i = 1; i < 4; i++) {
			room.addMonster(new Hero("", game.dungeonMaster,monster, monster.getPositionClasses(i).get((int) Math.min(monster.getPositionClasses(i).size()-1, Math.random()*monster.getPositionClasses(i).size()))));
		}
		room.setHasFight(true);
		addRoom(room, 4, 7);
		//room 6,5
		addRandomRoom(6, 5);
		//room 6,7
		addRandomRoom(6, 7);
		//room 5,7
		addRandomRoom(5, 7);
		//room 8,8
		addRandomRoom(8,8);
		//room 6,2
		addRandomRoom(6,2);
		//room 7,2
		addRandomRoom(7, 2);
		//room 8,2
		addRandomRoom(8, 2);
		//room 8,3
		addRandomRoom(8, 3);
		//room 8,4
		addRandomRoom(8, 4);
		//room 2,4
		room=new EmptyRoom(game);
		room.getInteractions().add(new Chest(game));
		monster=new RaceGoblin(game);
		for (int i = 1; i < 2; i++) {
			room.addMonster(new Hero("", game.dungeonMaster,monster, monster.getPositionClasses(i).get((int) Math.min(monster.getPositionClasses(i).size()-1, Math.random()*monster.getPositionClasses(i).size()))));
		}
		room.setHasFight(true);
		addRandomRoom(2, 4);
		//room 2,5
		addRandomRoom(2, 5);
		//room 2,6
		addRandomRoom(2, 6);
		//room 3,6
		addRandomRoom(3, 6);
		//room 3,7
		addRandomRoom(3, 7);
		//room 3,8
		addRandomRoom(3, 8);
		//room 3,9
		addRandomRoom(3, 9);
		//room 4,9
		addRandomRoom(4, 9);
		//room 5,9
		addRandomRoom(5, 9);
		//room 6,9
		addRandomRoom(6, 9);
		//room 7,9
		addRandomRoom(7, 9);
		//room 8,9
		addRandomRoom(8, 9);
	}
	
	@Override
	public boolean addRandomRoom(int x, int y) {
		double fightProbability=0.3;
		int maxRoomInteractions=5;
		room= new EmptyRoom(game);
		ArrayList<RoomInteraction> act1Interactions;		
		int randomInteractionAmount=(int) (Math.pow(Math.random(), 6)*maxRoomInteractions);
		for (int i = 0; i < randomInteractionAmount; i++) {
			act1Interactions= new ArrayList<RoomInteraction>();
			act1Interactions.add(new Sack(game,40));
			act1Interactions.add(new Sack(game,10));
			act1Interactions.add(new Sack(game,60));
			act1Interactions.add(new Chest(game));
			act1Interactions.add(new Chest(game));
			act1Interactions.add(new SleepingOgre(game));
			Chest itemChest= new Chest(game);
			itemChest.getItems().add(game.generator.generateRandomItem(4));
			act1Interactions.add(itemChest);
			act1Interactions.add(itemChest);
			act1Interactions.add(new HayHeap(game));
			act1Interactions.add(new Well(game));
			act1Interactions.add(new SpikeTrap(game));
			act1Interactions.add(new PoisonTrap(game));
			act1Interactions.add(new EvilStatue(game));
			act1Interactions.add(new AncientTome(game));
			act1Interactions.add(new UndeadCorpse(game, 12,(int) Math.random()*40));
			act1Interactions.add(new Altar(game));
			act1Interactions.add(new SeekingHero(game,-1));
			act1Interactions.add(new Sack(game,10));
			room.getInteractions().add(act1Interactions.get((int) (Math.random()*act1Interactions.size())));
		}						
		if (Math.random()<fightProbability) {
			Iterator it = act1Monsters.entrySet().iterator();
			int randomToken=(int)(Math.random()*act1Monsters.size());
			int count=0;
		    while (it.hasNext()) {
		    	Map.Entry pair = (Map.Entry)it.next();
		    	if (count==randomToken) {
			        int numberOfMonsters = 1+Math.min((Integer) pair.getValue(),game.dungeonMaster.getGroupSize()-1);    
			        for (int i = numberOfMonsters; i >0; i--) {		
			        	MonsterRace mapMonster=(MonsterRace) pair.getKey();
						room.addMonster(new Hero("", game.dungeonMaster,mapMonster, mapMonster.getPositionClasses(i).get((int) Math.min(mapMonster.getPositionClasses(i).size()-1, Math.random()*mapMonster.getPositionClasses(i).size()))));//if multiple classes maybe choose randomly
					}					
				}
		    	count++;
		        it.remove(); // avoids a ConcurrentModificationException
		    }
		    if (room.getMonsters().size()>0) {
				room.setHasFight(true);
			}			
		}
		return addRoom(room, x, y);
	}

	@Override
	public boolean checkIfActFullfilled(Player player) {
		
		return false;
	}
	private class Act1Finish extends Quest{
		private Item questItem = new QuestRelic();
		public Act1Finish(Game game) {
			super(game);
			Room questRoom=new EmptyRoom(game);
			Chest questInteraction = new Chest(game);
			questInteraction.getItems().add(questItem);
			questRoom.getInteractions().add(questInteraction);
			questRoom.setHasFight(true);
			MonsterRace monster=new BossNecromancer(game);
			questRoom.addMonster(new Hero("", game.dungeonMaster, monster, monster.getPositionClasses(1).getFirst()));
			rooms.add(questRoom);
			description="find the -"+questItem.getName()+"- and return it to the town.";
			goldReward=600;
			experienceReward=100;
			gamePoints=1000;
		}
		public boolean checkIfQuestFullfilled(Player player) {
			if(player.getInventory().contains(questItem)) {
				giveReward(player);
				player.getInventory().remove(questItem);
				return true;
			}
			return false;
		}	
		
		
		@Override
		public void giveReward(Player player) {
			super.giveReward(player);
			//leaderboard here
			Leaderboard lb= Leaderboard.loadLeaderboard();
			new LeaderboardWindow(lb,game, true);
		}


		private class QuestRelic extends Item{

			public QuestRelic() {
				super();
				LinkedList<String> relicNames= new LinkedList<String>();
				relicNames.add("necromancers book");
				name=relicNames.get((int) Math.min(relicNames.size()-1,(Math.random()*relicNames.size())));
				
			}

			@Override
			public void generateItemDescription() {
				super.generateItemDescription();
				description.add("return this to town to gain quest rewards");
			}
			
		}
		
	}
}
