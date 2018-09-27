package game.RoomInteractionLibrary;

import java.util.LinkedList;

import game.Game;
import game.RoomInteraction;
import gameEncounter.Hero;
import gameEncounter.Item;

public class EvilStatue extends RoomInteraction{
	private int charges=1;
	private int gold=20;
	private LinkedList<Item> items= new LinkedList<Item>();
	public EvilStatue(Game game) {
		super(game);
		//image=game.imageLoader.getImage(85);
		setImageNumber(85);
		name="evil statue";
		gold=(int) (Math.random()*15);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onEnter(Game game) {
		// TODO Auto-generated method stub
		for(int i=0;i<game.getPlayer().getHeroes().size();i++) {
			game.getPlayer().getHeroes().get(i).becomeStressed(15);
		}		
	}

	@Override
	public void onInteraction(Hero hero) {
		hero.getPlayer().getGame().log.addLine("it gazes viciously");
	}

	public LinkedList<Item> getItems() {
		return items;
	}

	public void setItems(LinkedList<Item> items) {
		this.items = items;
	}
	
}
