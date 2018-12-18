package game;

import java.io.Serializable;
import java.util.LinkedList;

import GUI.grafics.MyImageLoader;
import game.ActLibrary.Act1;
import game.QuestLibrary.QuestReturnRelic;
import game.RoomInteractionLibrary.Tavern;
import game.RoomLibrary.Town;
import gameEncounter.Fight;
import gameEncounter.GameEquations;
import gameEncounter.Hero;
import gameEncounter.Item;
import gameEncounter.CardLibrary.CardBuilder;
import gameEncounter.ItemLibrary.ItemBuilder;
import gameEncounter.ItemLibrary.ItemSpecialBuilder;
import gameEncounter.ItemLibrary.ItemSuffixBuilder;
import tools.MyLog;

public class Game implements Serializable {
	private Player player; // change this for multiplayer
	protected int maximumGroupSize=5;
	public Player dungeonMaster;
	public GeneratorRandom generator;
	// public MyImageLoader imageLoader;
	public CardBuilder cardBuilder;
	public ItemBuilder itemBuilder;
	public ItemSpecialBuilder itemSpecialBuilder;
	public ItemSuffixBuilder itemSuffixBuilder;
	public int turn = 0;
	public int points = 0;
	public MyLog log;
	private Room room;
	private Room town;
	private LinkedList<Quest> availableQuests;
	private LinkedList<Act> actList;
	private Act activeAct;
	private int idleStressRelief = 10;

	public Game() {
		super();
		player = new Player(this);
		cardBuilder = new CardBuilder();
		itemBuilder = new ItemBuilder(this,"resources/items.properties");
		itemSpecialBuilder = new ItemSpecialBuilder(this,"resources/itemsSpecial.properties");
		itemSuffixBuilder = new ItemSuffixBuilder();
		dungeonMaster = new DungeonMaster(this);
		generator = new GeneratorRandom(this);
		log = new MyLog();
		availableQuests = new LinkedList<Quest>();
		town = new Town(this);	
		//all acts
		actList= new LinkedList<Act>();
		actList.add(new Act1(this));
		activeAct = actList.getFirst();
		
		room = activeAct.getStartRoom();
		availableQuests.add(activeAct.getMainQuest());
		
		// cardBuilder.printMap();
	}

	public void enterRoom(Room room) {
		this.room = room;
		log = new MyLog();
		for (int i = 0; i < player.getHeroes().size(); i++) {
			player.getHeroes().get(i).applyNegativeTurnEffects();
		}
		room.prepareRoomAndEnter(this);
	}

	public void increaseGameTurn() {
		// increment turns for final score
		// do time related stuff here
		if (turn % 4 == 0) {
			for (int i = 0; i < getPlayer().getAvailableHeroes().size(); i++) {
				getPlayer().getAvailableHeroes().get(i)
						.setStress(getPlayer().getAvailableHeroes().get(i).getStress() - idleStressRelief);
				if (getPlayer().getAvailableHeroes().get(i).getStress() < 0) {
					getPlayer().getAvailableHeroes().get(i).setStress(0);
				}
				getPlayer().getAvailableHeroes().get(i).heal(getPlayer().getAvailableHeroes().get(i).getVitality());
						
			}
		}
		turn++;
	}

	// getters and setters
	public Room getRoom() {
		return room;
	}

	public void setRoom(Room room) {
		this.room = room;
	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}
	// public Room getNextRoom() {
	// if(room!=town) {
	// if(activeQuest.getRooms().size()>activeQuest.getRooms().indexOf(room)+1) {
	// return activeQuest.getRooms().get(activeQuest.getRooms().indexOf(room)+1);
	// }else {
	// return town;
	// }
	// }else {
	// return activeQuest.getRooms().getFirst();
	// }
	// }
	// public void enterNextRoom() {
	// room=getNextRoom();
	// //check here if all heroes are dead
	// LinkedList<Hero> stressedOutHeroes= new LinkedList<Hero>();
	// for(int i=0; i<this.getPlayer().getHeroes().size();i++) {
	// if(!getPlayer().getHeroes().get(i).isDead()) {
	// if(player.getHeroes().get(i).getStress()==player.getHeroes().get(i).getStressCap())
	// {
	// stressedOutHeroes.add(getPlayer().getHeroes().get(i));
	// }
	// }
	// //player.getHeroes().get(i).becomeStressed(2); find other ways to stress
	// }
	// player.removeDeadHeroesFromRoster();
	// for(int i=0; i<stressedOutHeroes.size();i++) {
	// if(!stressedOutHeroes.get(i).isDead()){
	// player.getHeroes().remove(stressedOutHeroes.get(i));
	// player.getAvailableHeroes().add(stressedOutHeroes.get(i));
	// }
	// }
	// if(player.getHeroes().size()==0) {
	// //TODO return to town here -- Quest over!
	// room=town;
	// }
	// log.clear();
	//
	// if(room!=town) {
	// log.addLine("||||���������������"+"ROOM
	// "+activeQuest.getRooms().indexOf(room)+"���������������||||");
	// }
	// room.prepareRoomAndEnter(this);
	//
	// }

	public void tpHeroes() {
		player.removeDeadHeroesFromRoster();
		if (player.getHeroes().size() == 0) {
			player.setInventory(new LinkedList<Item>());
		} else {
			for (int i = 0; i < player.getHeroes().size(); i++) {
				player.getHeroes().get(i).setUpDrawPile();
				player.getHeroes().get(i).turnBegin();
			}
		}
		player.setTpLocation(room);
		this.enterRoom(town);
	}

	public void retreatHeroes() {
		player.removeDeadHeroesFromRoster();
		if (player.getHeroes().size() == 0) {
			player.setInventory(new LinkedList<Item>());
		} else {
			for (int i = 0; i < player.getHeroes().size(); i++) {
				player.getHeroes().get(i).setUpDrawPile();
				player.getHeroes().get(i).turnBegin();
				player.getHeroes().get(i).looseMoral(12);
			}
		}
		Room previousRoom = town;
		//maybe not go back to town
		this.enterRoom(previousRoom);
	}
	public void addNewQuest(Quest quest) {
		availableQuests.add(quest);
		log.addLine("new Quest:");
		log.addLine(quest.getDescription());
	}
	public void questFulfilledCheck() {
		for (int i = 0; i < availableQuests.size(); i++) {
			availableQuests.get(i).onReturnToTown(player);
		}
	}
	public Room getTown() {
		return town;
	}

	public LinkedList<Quest> getAvailableQuests() {
		return availableQuests;
	}

	public void setAvailableQuests(LinkedList<Quest> availableQuests) {
		this.availableQuests = availableQuests;
	}

	public Act getActiveAct() {
		return activeAct;
	}

	public void setActiveAct(Act activeAct) {
		this.activeAct = activeAct;
	}

	public int getMaximumGroupSize() {
		return maximumGroupSize;
	}

	public LinkedList<Act> getActList() {
		return actList;
	}

	public void setActList(LinkedList<Act> actList) {
		this.actList = actList;
	}

}
