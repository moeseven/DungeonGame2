package game.ActLibrary;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import game.Act;
import game.CharacterRace;
import game.Game;
import game.GeneratorRandom;
import game.MonsterRace;
import game.Player;
import game.Room;
import game.RoomInteraction;
import game.RoomInteractionLibrary.*;
import game.RoomLibrary.EmptyRoom;
import game.RoomLibrary.GoblinRoom1;
import game.monsters.BossNecromancer;
import game.monsters.RaceGoblin;
import game.monsters.RaceRat;
import game.monsters.RaceZombie;
import gameEncounter.Hero;

public class Act1 extends Act{
	protected Room questRoom;
	protected RoomInteraction interaction;
	protected MonsterRace monster;
	public Act1(Game game) {
		super(game);
		//town
		addRoom(game.getTown(), 4, 4);
		//room 3,4
		addRoom(new EmptyRoom(game), 3, 4);
		//room 3,3
		addRoom(new GoblinRoom1(game), 3, 3);
		//room 3,2
		questRoom=new EmptyRoom(game);
		interaction = new SleepingOgre(game);
		questRoom.getInteractions().add(interaction);
		addRoom(questRoom, 3, 2);
		//room 2,3
		questRoom=new EmptyRoom(game);
		interaction = new HayHeap(game);
		questRoom.getInteractions().add(interaction);
		addRoom(questRoom, 2, 3);
		//room 1,3
		questRoom=new EmptyRoom(game);
		interaction = new Sack(game,35);		
		questRoom.getInteractions().add(interaction);
		interaction = new Sack(game,45);
		questRoom.getInteractions().add(interaction);
		addRoom(questRoom, 1, 3);
		//room 1,4
		questRoom=new EmptyRoom(game);
		interaction = new Chest(game);
		questRoom.getInteractions().add(interaction);
		questRoom.setHasFight(true);
		monster=new RaceGoblin(game);
		questRoom.getMonsters().add(new Hero("", game.dungeonMaster, monster, monster.getPositionClasses(5).getFirst()));
		questRoom.getMonsters().add(new Hero("", game.dungeonMaster, monster, monster.getPositionClasses(1).getFirst()));
		questRoom.getMonsters().add(new Hero("", game.dungeonMaster, monster, monster.getPositionClasses(1).getFirst()));
		
		addRoom(questRoom, 1, 4);
		//room 8,8
		questRoom=new EmptyRoom(game);
		interaction = new Chest(game);
		questRoom.getInteractions().add(interaction);
		questRoom.setHasFight(true);
		monster=new BossNecromancer(game);
		questRoom.getMonsters().add(new Hero("", game.dungeonMaster, monster, monster.getPositionClasses(1).getFirst()));
		addRoom(questRoom, 8, 8);
		//room 8,7
		questRoom=new EmptyRoom(game);
		interaction = new Chest(game);
		questRoom.getInteractions().add(interaction);
		questRoom.getInteractions().add(new UndeadCorpse(game,30,(int) Math.random()*50));
		questRoom.getInteractions().add(new UndeadCorpse(game,90,(int) Math.random()*50));
		addRoom(questRoom, 8,7);
		//room 8,6
		questRoom=new EmptyRoom(game);
		interaction = new EvilStatue(game);
		questRoom.getInteractions().add(interaction);
		addRoom(questRoom, 8,6);
		//room 8,5
		questRoom=new EmptyRoom(game);
		interaction = new Well(game);
		questRoom.getInteractions().add(interaction);
		addRoom(questRoom, 8,5);
		//room 5,4
		questRoom=new EmptyRoom(game);
		interaction = new AncientTome(game);
		questRoom.getInteractions().add(interaction);
		addRoom(questRoom, 5, 4);
		//room 5,3
		addRandomRoom(5, 3);
		//room 5,2
		addRandomRoom(5,2);
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
	}
	
	@Override
	public boolean addRandomRoom(int x, int y) {
		double fightProbability=0.3;
		int maxRoomInteractions=5;
		questRoom= new EmptyRoom(game);
		ArrayList<RoomInteraction> act1Interactions;		
		int randomInteractionAmount=(int) (Math.pow(Math.random(), 6)*maxRoomInteractions);
		for (int i = 0; i < randomInteractionAmount; i++) {
			act1Interactions= new ArrayList<RoomInteraction>();
			act1Interactions.add(new Sack(game,40));
			act1Interactions.add(new Sack(game,10));
			act1Interactions.add(new Sack(game,60));
			act1Interactions.add(new Chest(game));
			act1Interactions.add(new Chest(game));
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
			act1Interactions.add(new UndeadCorpse(game, 12,(int) Math.random()*30));
			act1Interactions.add(new Sack(game,10));
			questRoom.getInteractions().add(act1Interactions.get((int) (Math.random()*act1Interactions.size())));
		}				
		//possible monsters
		HashMap<MonsterRace,Integer> act1Monsters= new HashMap<MonsterRace,Integer>();		
		act1Monsters.put(new RaceGoblin(game),1);
		act1Monsters.put(new RaceGoblin(game),2);
		act1Monsters.put(new RaceGoblin(game),3);
		act1Monsters.put(new RaceGoblin(game),3);
		act1Monsters.put(new RaceGoblin(game),3);
		act1Monsters.put(new RaceGoblin(game),3);
		act1Monsters.put(new RaceGoblin(game),4);
		act1Monsters.put(new RaceZombie(game),2);
		act1Monsters.put(new RaceRat(game),2);
		act1Monsters.put(new RaceRat(game),3);
		act1Monsters.put(new RaceRat(game),5);
		//
		
		if (Math.random()<fightProbability) {
			Iterator it = act1Monsters.entrySet().iterator();
			int randomToken=(int)(Math.random()*act1Monsters.size());
			int count=0;
		    while (it.hasNext()) {
		    	Map.Entry pair = (Map.Entry)it.next();
		    	if (count==randomToken) {
			        int numberOfMonsters = (Integer) pair.getValue();
			        for (int i = Math.min(numberOfMonsters+1, game.dungeonMaster.getGroupSize()); i >0; i--) {		
			        	MonsterRace mapMonster=(MonsterRace) pair.getKey();
						questRoom.getMonsters().add(new Hero("", game.dungeonMaster,mapMonster, mapMonster.getPositionClasses(i).get((int) Math.min(mapMonster.getPositionClasses(i).size()-1, Math.random()*mapMonster.getPositionClasses(i).size()))));//if multiple classes maybe choose randomly
					}					
				}
		    	count++;
		        it.remove(); // avoids a ConcurrentModificationException
		    }
			questRoom.setHasFight(true);
		}
		return addRoom(questRoom, x, y);
	}

	@Override
	public boolean checkIfActFullfilled(Player player) {
		
		return false;
	}

}
