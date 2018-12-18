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
		//image=game.imageLoader.getImage(84);
		setImageNumber(84);
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
		hero.looseMoral((int) (Math.random()*6));
		setImageNumber(95-Math.max(1, charges));
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
			game.getPlayer().getHeroes().get(i).looseMoral((int) (Math.random()*12));
		}	
		MonsterRace monsterRace= new RaceRat(game);
		int monstersAmount= (int) Math.max(1, (Math.random()*5));
		for(int i=0; i<monstersAmount;i++) {
			game.getRoom().addMonster(new Hero("", game.dungeonMaster,monsterRace, monsterRace.getPositionClasses(1).get(0)));
		}
		game.getRoom().setHasFight(true);		
		game.getRoom().getInteractions().remove(this);
		game.log.addLine("rats emerge from under the hay!");
		game.enterRoom(game.getRoom());
				
	}

	public LinkedList<Item> getItems() {
		return items;
	}

	public void setItems(LinkedList<Item> items) {
		this.items = items;
	}
	
}
