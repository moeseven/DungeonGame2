package game.RoomInteractionLibrary;

import java.util.LinkedList;

import game.Game;
import game.RoomInteraction;
import gameEncounter.Hero;
import gameEncounter.Item;

public class StandardCorpse extends RoomInteraction{
	private Hero corpse;
	private boolean hasBeenLooted;
	private LinkedList<Item> items;
	public StandardCorpse(Hero corpse) {
		super();
		hasBeenLooted=false;
		this.corpse=corpse;
		items= new LinkedList<Item>();
		items.addAll(corpse.getEquipment().getAllEquippedItems());
		
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
		if(!hero.isDead()) {
			if(!hasBeenLooted) {
			hero.loot(corpse);
			hero.getPlayer().addMultipleItemsToInventory(items);
		}else {
			hero.getPlayer().getGame().log.addLine("allready looted!");
		}
		if(items.size()==0) {
			hasBeenLooted=true;
		}
		}
				
	}
	
}
