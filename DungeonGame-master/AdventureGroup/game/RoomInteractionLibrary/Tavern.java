package game.RoomInteractionLibrary;

import java.util.LinkedList;

import game.Game;
import game.Quest;
import game.RoomInteraction;
import gameEncounter.Hero;


public class Tavern extends RoomInteraction{
	private LinkedList<Hero> heroes=new LinkedList<Hero>();
	private LinkedList<Quest> quests = new LinkedList<Quest>();
	public Tavern(Game game) {
		super(game);
		//image=game.imageLoader.getImage(105);
		setImageNumber(105);
		name="tavern";

	}

	@Override
	public void onEnter(Game game) {
		heroes=game.getPlayer().getAvailableHeroes();
		for(int i=0; i<heroes.size();i++) {
			heroes.get(i).cleanseHero();
		}
	}

	@Override
	public void onInteraction(Hero hero) {
		// TODO Auto-generated method stub
		//setup tavern here
		if(hero!=null) {
			hero.getPlayer().getGame().log.addLine("entering tavern");
			hero.getPlayer().getGame().getRoom().setTavern(this);
			hero.getPlayer().getGame().getRoom().setTavernOpen(true);
		}
	}

	public LinkedList<Hero> getHeroes() {
		return heroes;
	}

	public void setHeroes(LinkedList<Hero> heroes) {
		this.heroes = heroes;
	}

}
