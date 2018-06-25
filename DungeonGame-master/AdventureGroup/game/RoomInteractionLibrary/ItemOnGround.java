package game.RoomInteractionLibrary;

import game.Game;
import game.Room;
import game.RoomInteraction;
import gameEncounter.Hero;
import gameEncounter.Item;

public class ItemOnGround extends RoomInteraction{
	private Item item;
	private Room room;
	public ItemOnGround(Item item, Room room) {
		this.item=item;
		this.room=room;
		name=item.getName();
	}
	@Override
	public void onEnter(Game game) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onInteraction(Hero hero) {
		// TODO Auto-generated method stub
		if(item!=null) {
			hero.getPlayer().addItemtoInventory(item);
			room.getInteractions().remove(this);
		}		
	}

}
