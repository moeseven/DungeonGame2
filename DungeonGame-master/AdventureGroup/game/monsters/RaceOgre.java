package game.monsters;

import java.util.LinkedList;

import game.CharacterClass;
import game.CharacterRace;
import game.Game;
import game.MonsterRace;
import gameEncounter.Deck;
import gameEncounter.Hero;
import gameEncounter.Weapon;

import gameEncounter.buffLibrary.Bashed;

public class RaceOgre extends MonsterRace{

	public RaceOgre(Game game) {
		super(game);
		name="ogre";
		//set Position classes
		position1Classes.add(new OgreWarrior(game));
		position2Classes.add(new OgreWarrior(game));
		position3Classes.add(new OgreWarrior(game));
		position4Classes.add(new OgreWarrior(game));
		position5Classes.add(new OgreWarrior(game));
	}

	public void modifyHero(Hero hero) {
		super.modifyHero(hero);
		//hero.setImage(hero.getPlayer().getGame().imageLoader.getImage(42));
		hero.setImageNumber(42);
		hero.setSpeed(7);
		hero.setBaseHp(400);		
		//stats
		hero.setStrength(46);
		hero.setDexterity(10);
		hero.setIntelligence(7);
		hero.setVitality(20);
		//
		//attack/defence
		hero.setAttackSkill(18);
		hero.setBlockSkill(6);
		hero.setAccuracy(1);
		hero.setDodge(2);
		hero.setSpellPower(8);
		hero.setSpellResist(10);
		//
		//resistances
		hero.setResistFire(0);
		hero.setResistCold(10);
		hero.setResistBleed(10);
		hero.setResistPoison(35);
		hero.setResistStun(65);
		//
		hero.setGood(false);
		hero.setGold((int)(Math.random()*95.0));
		hero.setExperienceValue(280);
		//ogre
		hero.setManaPower(2);
		//deck		
		
	}
	private class OgreWarrior extends CharacterClass{

		public OgreWarrior(Game game) {	
			super(game);
			name="";	
			cards.add(game.cardBuilder.buildCard("bash"));
			cards.add(game.cardBuilder.buildCard("ram"));
			for (int i=0; i<4;i++) {				
				cards.add(game.cardBuilder.buildCard("basicBlock"));
			}
			for (int i=0; i<2;i++) {
				cards.add(game.cardBuilder.buildCard("basicAttack"));
				cards.add(game.cardBuilder.buildCard("meeleAttack"));
			}
		}

		public void modifyHero(Hero hero) {
			// TODO Auto-generated method stub
			super.modifyHero(hero);
			//mainstats
			hero.setStrength(hero.getStrength()+3);
			hero.setDexterity(hero.getDexterity()+2);
			hero.setIntelligence(hero.getIntelligence()+0);
			hero.setVitality(hero.getVitality()+6);
			//
			hero.setArmor(hero.getArmor()+20);
			hero.setAttackSkill(hero.getAttackSkill()+1);
			hero.setBlockSkill(hero.getBlockSkill()+1);
		}
	}
}
