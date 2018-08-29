package game.RoomInteractionLibrary;

import java.util.LinkedList;

import game.Game;
import game.MonsterRace;
import game.RoomInteraction;
import game.monsters.RaceGoblin;
import game.monsters.RaceRat;
import gameEncounter.Hero;
import gameEncounter.Item;

public class HayHeap extends RoomInteraction{
	private int charges=3;
	private int gold=20;
	private LinkedList<Item> items= new LinkedList<Item>();
	public HayHeap(Game game) {
		super(game);
		name="hay heap";
		gold=(int) (Math.random()*5);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onEnter(Game game) {
		// TODO Auto-generated method stub
	}

	@Override
	public void onInteraction(Hero hero) {
		hero.becomeStressed((int) (Math.random()*6));
		if(charges>0) {
			charges+=-1;
			if(Math.random()>0.2) {
				hero.getPlayer().gainGold(gold);
			}else {
				ratsApear(hero.getPlayer().getGame());				
			}
						
		}else {
			hero.getPlayer().getGame().log.addLine("allready searched");
		}
	}
	private void ratsApear(Game game) {
		for (int i=0; i<game.getPlayer().getHeroes().size();i++) {
			game.getPlayer().getHeroes().get(i).becomeStressed((int) (Math.random()*12));
		}	
		MonsterRace monsterRace= new RaceRat();
		int monstersAmount= (int) Math.max(1, (Math.random()*5));
		for(int i=0; i<monstersAmount;i++) {
			game.getRoom().getMonsters().add(new Hero("", game.dungeonMaster,monsterRace, monsterRace.getPosition1Classes().get(0)));
		}
		game.getRoom().setHasFight(true);		
		game.getRoom().getInteractions().remove(this);
		game.enterRoom(game.getRoom());
		game.log.addLine("rats emerge from under the hay!");		
	}

	public LinkedList<Item> getItems() {
		return items;
	}

	public void setItems(LinkedList<Item> items) {
		this.items = items;
	}
	
}
