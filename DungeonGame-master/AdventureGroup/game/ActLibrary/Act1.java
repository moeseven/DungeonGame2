package game.ActLibrary;

import game.Act;
import game.Game;
import game.MonsterRace;
import game.Player;
import game.Room;
import game.RoomInteraction;
import game.RoomInteractionLibrary.*;
import game.RoomLibrary.EmptyRoom;
import game.RoomLibrary.GoblinRoom1;
import game.monsters.BossNecromancer;
import gameEncounter.Hero;

public class Act1 extends Act{

	public Act1(Game game) {
		super(game);
		//town
		addRoom(game.getTown(), 4, 4);
		//room 3,4
		addRoom(new EmptyRoom(game), 3, 4);
		//room 3,3
		addRoom(new GoblinRoom1(game), 3, 3);
		//room 8,8
		Room questRoom=new EmptyRoom(game);
		RoomInteraction interaction = new Chest(game);
		questRoom.getInteractions().add(interaction);
		questRoom.setHasFight(true);
		MonsterRace monster=new BossNecromancer(game);
		questRoom.getMonsters().add(new Hero("", game.dungeonMaster, monster, monster.getPosition1Classes().getFirst()));
		addRoom(questRoom, 8, 8);
		//room 5,4
		questRoom=new EmptyRoom(game);
		interaction = new AncientTome(game);
		questRoom.getInteractions().add(interaction);
		addRoom(questRoom, 5, 4);
	}

	@Override
	public boolean checkIfActFullfilled(Player player) {
		
		return false;
	}

}
