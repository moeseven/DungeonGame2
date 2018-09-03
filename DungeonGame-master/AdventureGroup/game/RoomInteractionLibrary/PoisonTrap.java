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

public class PoisonTrap extends Trap{
	public PoisonTrap(Game game) {
		super(game);
		image=game.imageLoader.getImage(88);
		name="poison trap";
		trapStats.setAccuracy(25);
		
	}
	public void trapHits(Hero hero) {
		if(trapStats.attackHero(hero,card)) {
			hero.getPlayer().getGame().log.addLine(hero.getName()+" triggered a "+getName());
			hero.poison((int) (Math.random()*5)+3);
			hero.becomeStressed(19);
			
		}
	}
	
}
