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
		//all stats		
		hero.setStrength(12);
		hero.setDexterity(3);
		hero.setVitality(1);
		hero.setIntelligence(6);
		//main attributes
		hero.setAttackSkill(28);
		hero.setBlockSkill(4);
		hero.setAccuracy(1);
		hero.setDodge(1);
		hero.setSpellPower(15);
		hero.setSpellDuration(7);
		//
		hero.setArmor(7);
		hero.setSpeed(2);					
		hero.setThorns(0);
		//
		hero.setDraw(4);
		hero.setManaPower(2);
		//offensive
		hero.setCritChance(4);
		hero.setCritDamage(20);
		//elemental bonus
		hero.setStunChance(10);
		hero.setFireDmg(10);
		hero.setColdDmg(50);
		hero.setLightningDmg(35);
		hero.setPoisonDmg(5);
		hero.setBleedDmg(5);
		hero.setMagicDmg(25);		
		//resistance
		hero.setResistSpell(20);
		hero.setResistFire(-30);
		hero.setResistLightning(0);
		hero.setResistCold(20);
		hero.setResistPoison(35);
		hero.setResistBleed(15);
		hero.setResistStun(35);
		hero.setResistStress(90);
		hero.setStressCap(81);
		//
		hero.setTrapDisarm(10);
		hero.setBaseHp(120);		
		//
		hero.setImageNumber(65);	
		//
		hero.setGood(false);
		hero.setGold((int)(Math.random()*15.0));
		hero.setExperienceValue(11);	
		hero.setUndead(true);
		for (int i=0; i<2;i++) {
			cards.add(game.cardBuilder.buildCard("basicAttack"));
		}
	}
	private class ZombieWarrior extends CharacterClass{

		public ZombieWarrior(Game game) {	
			super(game);
			name="";				
			for (int i=0; i<2;i++) {
				cards.add(game.cardBuilder.buildCard("basicAttack"));
			}
			for (int i=0; i<3;i++) {
				cards.add(game.cardBuilder.buildCard("meeleAttack"));
			}
			cards.add(game.cardBuilder.buildCard("shortStrike"));
			cards.add(game.cardBuilder.buildCard("shortStrike"));
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
			hero.setArmor(hero.getArmor()+5);
			hero.setAttackSkill(hero.getAttackSkill()+3);
			hero.setBlockSkill(hero.getBlockSkill()+5);
		}
	}
}
