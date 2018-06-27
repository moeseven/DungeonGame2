package game.RoomInteractionLibrary;

import java.util.LinkedList;

import game.CharacterClass;
import game.CharacterRace;
import game.Game;
import game.RoomInteraction;
import game.characterTypeLibrary.genericCharacterClass;
import game.characterTypeLibrary.genericCharacterRace;
import gameEncounter.Hero;
import gameEncounter.Item;

public class SpikeTrap extends RoomInteraction{
	boolean disarmed;
	Hero trapStats;
	public SpikeTrap() {
		super();
		name="spike trap";
		// TODO Auto-generated constructor stub
		hidden=true;
		trapStats=new Hero(name, null, new genericCharacterRace(), new genericCharacterClass());
		trapStats.setAccuracy(14);
	}
	public void trapHits(Hero hero) {
		if(trapStats.attackHero(hero)) {
			hero.getPlayer().getGame().log.addLine(hero.getName()+" triggered a "+getName());
			hero.takeUnreflectableArmorDamage(trapStats, (int)(Math.random()*45));
			hero.becomeStressed(9);
			
		}
	}
	@Override
	public void onEnter(Game game) {
		//give heros trap detection capabilities
		if(Math.random()>game.getPlayer().getSelectedHero().getTrapDisarm()) {
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
			if(Math.random()>hero.getTrapDisarm()+10) {
				hero.getPlayer().getGame().log.addLine(hero.getName()+" disarms a "+getName()+" and gains "+exp+" experience");
				hero.gainExp(exp);				
			}else {
				trapHits(hero);
			}
			disarmed=true;
		}
	}

	
}
