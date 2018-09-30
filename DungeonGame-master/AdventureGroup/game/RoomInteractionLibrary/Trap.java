package game.RoomInteractionLibrary;

import java.util.LinkedList;

import game.CharacterClass;
import game.CharacterRace;
import game.Game;
import game.RoomInteraction;
import game.characterTypeLibrary.genericCharacterClass;
import game.characterTypeLibrary.genericCharacterRace;
import gameEncounter.Card;
import gameEncounter.Card_new;
import gameEncounter.Hero;
import gameEncounter.Item;

public abstract class Trap extends RoomInteraction{
	protected boolean disarmed;
	protected Hero trapStats;
	protected Card card;
	public Trap(Game game) {
		super(game);
		name="trap";
		// TODO Auto-generated constructor stub
		hidden=true;
		card = new Card_new("0", null, null, "trap", "120", null, null, null, null, null, null, null, null,null,null,null, null);
		trapStats=new Hero(name, null, new genericCharacterRace(game), new genericCharacterClass(game));
		trapStats.setAccuracy(14);
	}
	public abstract void trapHits(Hero hero);
	@Override
	public void onEnter(Game game) {
		//give heros trap detection capabilities
		if(Math.random()>(game.getPlayer().getSelectedHero().getTrapDisarm()/100.0)) {
			trapHits(game.getPlayer().getSelectedHero());
		}else {
			hidden=false;
			game.log.addLine(game.getPlayer().getSelectedHero().getName()+" detected a "+getName());
		}
		
	}

	@Override
	public void onInteraction(Hero hero) {
		int exp=15;		
		if(disarmed) {
			hero.getPlayer().getGame().log.addLine("nothing more to see");
		}else {
			if(Math.random()>(hero.getTrapDisarm()/100.0)+10) {
				hero.getPlayer().getGame().log.addLine(hero.getName()+" disarms a "+getName()+" and gains "+exp+" experience");
				hero.gainExp(exp);				
			}else {
				trapHits(hero);
			}
			disarmed=true;
		}
	}

	
}
