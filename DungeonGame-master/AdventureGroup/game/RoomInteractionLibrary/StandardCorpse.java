package game.RoomInteractionLibrary;

import java.util.LinkedList;

import game.Game;
import game.RoomInteraction;
import gameEncounter.Hero;
import gameEncounter.Item;

public class StandardCorpse extends RoomInteraction{
	private Hero corpse;
	private boolean hasBeenLooted;
	public StandardCorpse(Hero corpse) {
		super();
		hasBeenLooted=false;
		this.corpse=corpse;
		name=corpse.getName()+" corpse";
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onEnter(Game game) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onInteraction(Hero hero) {
		// TODO Auto-generated method stub
		//loot corpse
		if(!hasBeenLooted) {
			hero.loot(corpse);
			
		}else {
			hero.getPlayer().getGame().log.addLine("allready looted!");
		}
		hasBeenLooted=true;
	}
	
}
