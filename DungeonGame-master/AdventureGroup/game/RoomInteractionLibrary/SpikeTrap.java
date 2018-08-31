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

public class SpikeTrap extends Trap{
	public SpikeTrap(Game game) {
		super(game);
		image=game.imageLoader.getImage(87);
		name="spike trap";
		trapStats.setAccuracy(13);
	}
	public void trapHits(Hero hero) {
		if(trapStats.attackHero(hero)) {
			hero.getPlayer().getGame().log.addLine(hero.getName()+" triggered a "+getName());
			hero.takeArmorDamage(trapStats, (int)(Math.random()*95));
			hero.becomeStressed(13);
			
		}
	}
	
}
