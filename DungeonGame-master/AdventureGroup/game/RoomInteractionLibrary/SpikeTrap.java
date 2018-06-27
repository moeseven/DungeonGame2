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
		trapStats=new Hero(name, null, new genericCharacterRace(), new genericCharacterClass());
		trapStats.setAccuracy(9);
	}

	@Override
	public void onEnter(Game game) {
		//give heros trap detection capabilities
		game.log.addLine(game.getPlayer().getSelectedHero().getName()+" triggered a "+getName());
		if(trapStats.attackHero(game.getPlayer().getSelectedHero())) {
			game.getPlayer().getSelectedHero().takeUnreflectableArmorDamage(trapStats, (int)(Math.random()*45));
			game.getPlayer().getSelectedHero().becomeStressed(9);
		}
	}

	@Override
	public void onInteraction(Hero hero) {
		int exp=5;
		if(disarmed) {
			hero.getPlayer().getGame().log.addLine(" nothing more to see");
		}else {
			hero.getPlayer().getGame().log.addLine(hero.getName()+" inspects a "+getName()+" and gains "+exp+" experience");
			hero.gainExp(exp);
			disarmed=true;
		}
	}

	
}
