package game.RoomInteractionLibrary;

import java.util.LinkedList;

import game.Game;
import game.RoomInteraction;
import gameEncounter.Hero;
import gameEncounter.Item;

public class SeekingHero extends RoomInteraction{
	Hero seeker;
	boolean herocreated=false;
	int startingExp;
	public SeekingHero(Game game,int startingExp) {//-1 starting exp adjusts exp to heroes
		super(game);	
		this.startingExp=startingExp;
		name="seeker";
		
	}

	@Override
	public void onEnter(Game game) {
		if (!herocreated) {
			herocreated=true;
			seeker= game.generator.generateRandomHero(game.getPlayer());
			if (startingExp==-1) {//adjust exp to group
				seeker.gainExp(game.getPlayer().getSelectedHero().getExperience());
			}else{
				seeker.gainExp(startingExp);
			}			
			seeker.autoskill();
			setImageNumber(seeker.getImageNumber());
		}		
	}

	@Override
	public void onInteraction(Hero hero) {		
		if (hero.getPlayer().getHeroes().size()<hero.getPlayer().getGroupSize()) {
			hero.getPlayer().getHeroes().add(seeker);
			hero.getPlayer().getGame().log.addLine(seeker.getName()+" joins your quest.");
		}else {
			hero.getPlayer().getAvailableHeroes().add(seeker);
			hero.getPlayer().getGame().log.addLine(seeker.getName()+" is waiting for a quest in the tavern.");
		}	
		hero.getPlayer().getGame().getRoom().getInteractions().remove(this);
	}	
}
