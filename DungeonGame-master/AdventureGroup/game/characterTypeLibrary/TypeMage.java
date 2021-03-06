package game.characterTypeLibrary;

import game.CharacterClass;
import game.Game;
import gameEncounter.Hero;
import gameEncounter.Item;

public class TypeMage extends CharacterClass{

	public TypeMage(Game game) {
		super(game);
		cardPool.add("fireWave");
		cardPool.add("wisdom");
		cardPool.add("channel");
		cardPool.add("fireBall");
		cardPool.add("sleepCharm");		
		cardPool.add("rosesAndThorns");
		cardPool.add("breeze");
		cardPool.add("sparks");
		cardPool.add("magicShield");
		cardPool.add("iceArmor");
		cardPool.add("iceWall");
		cardPool.add("mindBlast");
		cardPool.add("exert");
		cardPool.add("thinkFast");
		cardPool.add("slow");
		name="mage";		
		Item startItem = game.itemBuilder.buildItem("rustyBlade",6);
		items.add(startItem);
		for (int i=0; i<2;i++) {
			cards.add(game.cardBuilder.buildCard("magicMissile"));
		}		
		for (int i=0; i<5;i++) {
			cards.add(game.cardBuilder.buildCard("basicAttack"));
			cards.add(game.cardBuilder.buildCard("basicBlock"));
		}
		
	}

	public void modifyHero(Hero hero) {
		super.modifyHero(hero);
		if (hero.getCharRace().getName().equals("human")) {
			//hero.setImage(hero.getPlayer().getGame().imageLoader.getImage(124));
			hero.setImageNumber(124);
		}
		if (hero.getCharRace().getName().equals("dwarf")) {
			//hero.setImage(hero.getPlayer().getGame().imageLoader.getImage(127));
			hero.setImageNumber(127);
		}
		if (hero.getCharRace().getName().equals("elf")) {
			//hero.setImage(hero.getPlayer().getGame().imageLoader.getImage(125));
			hero.setImageNumber(125);
		}
		if (hero.getCharRace().getName().equals("halfling")) {
			//hero.setImage(hero.getPlayer().getGame().imageLoader.getImage(126));
			hero.setImageNumber(126);
		}
		//mainstats
		hero.setArmor(hero.getArmor()-1);
		hero.setIntelligence(hero.getIntelligence()+6);
		hero.setVitality(hero.getVitality()+1);
		hero.setFireDmg(hero.getFireDmg()+5);
		hero.setCritChance(hero.getCritChance()+2);
		hero.setCritDamage(hero.getCritDamage()+5);
		//
		hero.setSpellPower(hero.getSpellPower()+8);	
		hero.setResistStress(hero.getResistStress()-3);
	}
}
