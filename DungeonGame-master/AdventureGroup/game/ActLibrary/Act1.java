package game.ActLibrary;

import game.Act;
import game.Game;
import game.MonsterRace;
import game.Player;
import game.Room;
import game.RoomInteractionLibrary.Chest;
import game.RoomLibrary.EmptyRoom;
import game.RoomLibrary.GoblinRoom1;
import game.monsters.BossNecromancer;
import gameEncounter.Hero;

public class Act1 extends Act{

	public Act1(Game game) {
		super(game);
		addRoom(game.getTown(), 4, 4);
		addRoom(new EmptyRoom(game), 3, 4);
		addRoom(new GoblinRoom1(game), 3, 3);
		Room questRoom=new EmptyRoom(game);
		Chest questInteraction = new Chest(game);
		questRoom.getInteractions().add(questInteraction);
		questRoom.setHasFight(true);
		MonsterRace monster=new BossNecromancer(game);
		questRoom.getMonsters().add(new Hero("", game.dungeonMaster, monster, monster.getPosition1Classes().getFirst()));
		addRoom(questRoom, 8, 8);
	}

	@Override
	public boolean checkIfActFullfilled(Player player) {
		
		return false;
	}

}
