package game.monsters;

import java.util.LinkedList;

import game.CharacterClass;
import game.CharacterRace;
import game.Game;
import game.MonsterRace;
import gameEncounter.Deck;
import gameEncounter.Hero;
import gameEncounter.Weapon;
import gameEncounter.CardLibrary.AttackCard;
import gameEncounter.CardLibrary.Spell;

public class RaceZombie extends MonsterRace{

	public RaceZombie(Game game) {
		super(game);
		name="zombie";
		//set Position classes
		position1Classes.add(new ZombieWarrior(game));
		position2Classes.add(new ZombieWarrior(game));
		position3Classes.add(new ZombieWarrior(game));
		position4Classes.add(new ZombieWarrior(game));
		position5Classes.add(new ZombieWarrior(game));
	}

	public void modifyHero(Hero hero) {
		super.modifyHero(hero);
		hero.setSpeed(4);
		hero.setBaseHp(180);		
		//stats
		hero.setStrength(12);
		hero.setDexterity(3);
		hero.setIntelligence(1);
		hero.setVitality(6);
		//
		//attack/defence
		hero.setAttackSkill(6);
		hero.setBlockSkill(3);
		hero.setAccuracy(1);
		hero.setDodge(1);
		hero.setSpellPower(8);
		hero.setSpellResist(20);
		//
		//resistances
		hero.setResistFire(5);
		hero.setResistCold(40);
		hero.setResistBleed(10);
		hero.setResistPoison(80);
		hero.setResistStun(60);
		//
		hero.setArmor(5);
		hero.setGood(false);
		hero.setGold((int)(Math.random()*15.0));
		hero.setExperienceValue(30);
		//zombieslow
		hero.setManaPower(2);
		hero.setResistStress(90);
		//deck		
		
	}
	private class ZombieWarrior extends CharacterClass{

		public ZombieWarrior(Game game) {	
			super(game);
			name="";				
			for (int i=0; i<4;i++) {
				cards.add(game.cardBuilder.buildCard("basicAttack"));
			}
			for (int i=0; i<6;i++) {
				cards.add(game.cardBuilder.buildCard("meeleAttack"));
			}
			cards.add(game.cardBuilder.buildCard("zombieBite"));
			cards.add(game.cardBuilder.buildCard("zombieGrab"));
			cards.add(game.cardBuilder.buildCard("zombieMoan"));
		}

		public void modifyHero(Hero hero) {
			super.modifyHero(hero);
			//hero.setImage(hero.getPlayer().getGame().imageLoader.getImage(65));
			hero.setImageNumber(65);
			//mainstats
			hero.setStrength(hero.getStrength()+3);
			hero.setDexterity(hero.getDexterity()+2);
			hero.setIntelligence(hero.getIntelligence()+0);
			hero.setVitality(hero.getVitality()+6);
			//
			hero.setArmor(hero.getArmor()+1);
			hero.setAttackSkill(hero.getAttackSkill()+1);
			hero.setBlockSkill(hero.getBlockSkill()+1);
		}
	}
}
