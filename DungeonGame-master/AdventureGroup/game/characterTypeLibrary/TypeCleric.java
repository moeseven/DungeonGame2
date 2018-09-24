package game.characterTypeLibrary;

import game.CharacterClass;
import game.Game;
import gameEncounter.Hero;
import gameEncounter.CardLibrary.Bash;
import gameEncounter.CardLibrary.BasicAttack;
import gameEncounter.CardLibrary.Block;
import gameEncounter.CardLibrary.DivineGrace;
import gameEncounter.CardLibrary.Harden;
import gameEncounter.CardLibrary.HeavenlyShield;
import gameEncounter.CardLibrary.HeavenlyStrength;
import gameEncounter.CardLibrary.MeeleAttack;
import gameEncounter.CardLibrary.RangedAttack;
import gameEncounter.ItemLibrary.RustyBlade;


public class TypeCleric extends CharacterClass{

	public TypeCleric(Game game) {
		super(game);
		cardPool.add("bash");
		cardPool.add("divineGrace");
		cardPool.add("heavenlyShield");
		cardPool.add("heavenlyStrength");
		cardPool.add("harden");
		
		name="cleric";
		items.add(new RustyBlade());		
		for (int i=0; i<3;i++) {
			cards.add(game.cardBuilder.buildCard("basicAttack"));
		}
		cards.add(game.cardBuilder.buildCard("meeleAttack"));
		cards.add(game.cardBuilder.buildCard("meeleAttack"));
		for (int i=0; i<5;i++) {
			cards.add(game.cardBuilder.buildCard("basicBlock"));
		}
	}

	public void modifyHero(Hero hero) {
		super.modifyHero(hero);
		if (hero.getCharRace().getName().equals("human")) {
			hero.setImage(hero.getPlayer().getGame().imageLoader.getImage(39));
		}
		if (hero.getCharRace().getName().equals("dwarf")) {
			hero.setImage(hero.getPlayer().getGame().imageLoader.getImage(38));
		}
		if (hero.getCharRace().getName().equals("elf")) {
			hero.setImage(hero.getPlayer().getGame().imageLoader.getImage(122));
		}
		if (hero.getCharRace().getName().equals("halfling")) {
			hero.setImage(hero.getPlayer().getGame().imageLoader.getImage(123));
		}
		//mainstats
		
		hero.setStrength(hero.getStrength()+3);
		hero.setDexterity(hero.getDexterity()+0);
		hero.setIntelligence(hero.getIntelligence()+4);
		hero.setVitality(hero.getVitality()+5);
		//
		hero.setSpellDuration(hero.getSpellDuration()+1);
		hero.setSpellResist(hero.getSpellResist()+5);
		hero.setSpellPower(hero.getSpellPower()+1);
		hero.setResistStress(hero.getResistStress()+8);
	}

}
