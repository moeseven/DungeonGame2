package game.RoomInteractionLibrary;

import java.util.LinkedList;

import game.RoomInteraction;
import gameEncounter.Hero;
import gameEncounter.Item;

public class StandardCorpse extends RoomInteraction{
	private Hero corpse;
	private boolean hasBeenLooted=false;
	public StandardCorpse(Hero corpse) {
		super();
		this.corpse=corpse;
		name=corpse.getName()+" corpse";
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onEnter() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onInteraction(Hero hero) {
		// TODO Auto-generated method stub
		//loot corpse
		if(!hasBeenLooted) {
			hero.loot(corpse);
			
		}
		hasBeenLooted=true;
	}
	
}
