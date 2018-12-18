package game.RoomInteractionLibrary;

import java.util.LinkedList;

import game.Game;
import game.MonsterRace;
import game.Room;
import game.RoomInteraction;
import game.monsters.RaceOgre;
import gameEncounter.Hero;
import gameEncounter.Item;

public class SleepingOgre extends RoomInteraction{
	private int charges=1;
	private int gold=20;
	private Hero ogre;
	private MonsterRace monsterRace= new RaceOgre(game);
	LinkedList<Hero> monsterSet= new LinkedList<Hero>();
	private LinkedList<Item> items= new LinkedList<Item>();
	public SleepingOgre(Game game) {
		super(game);
		name="sleeping ogre";		 
		//image=game.imageLoader.getImage(96);
		setImageNumber(96);
		gold=(int) (Math.random()*15);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onEnter(Game game) {
		// TODO Auto-generated method stub
		if (charges>0) {
			ogre=new Hero("", game.dungeonMaster,monsterRace, monsterRace.getPositionClasses(1).get(0));
		}
	}

	@Override
	public void onInteraction(Hero hero) {
		if(charges>0) {
			charges+=-1;
			if(Math.random()>0.15+hero.getTrapDisarm()/100.0) {		
				hero.getPlayer().gainGold(ogre.getGold());
				ogre.setGold(0);
				hero.getPlayer().getGame().log.addLine("the ogre keeps sleeping");
			}else {
				ogreAwakens(hero.getPlayer().getGame());				
			}
						
		}else {		
			ogreAwakens(hero.getPlayer().getGame());
		}
		
	}
	private void ogreAwakens(Game game) {
		for (int i=0; i<game.getPlayer().getHeroes().size();i++) {
			game.getPlayer().getHeroes().get(i).looseMoral((int) (Math.random()*22));
		}		
		game.getRoom().addMonster(ogre);
		game.getRoom().setHasFight(true);		
		game.getRoom().getInteractions().remove(this);
		game.enterRoom(game.getRoom());
		game.log.addLine("the "+name+" awoke!");		
	}

	public LinkedList<Item> getItems() {
		return items;
	}

	public void setItems(LinkedList<Item> items) {
		this.items = items;
	}
	
}
