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
	public StandardCorpse(Game game,Hero corpse) {
		super(game);
		setImageNumber(240);
		hasBeenLooted=false;
		this.corpse=corpse;
		items= new LinkedList<Item>();
		items.addAll(corpse.getLoot());
		items.addAll(corpse.getEquipment().getAllEquippedItems());
		name=corpse.getName()+" corpse";
	}

	@Override
	public void onEnter(Game game) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onInteraction(Hero hero) {
		//loot corpse
		if(!hero.isDead()) {
			if(!hasBeenLooted) {
			setImageNumber(241);
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
