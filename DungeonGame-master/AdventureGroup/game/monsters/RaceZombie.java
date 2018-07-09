package game.monsters;

import java.util.LinkedList;

import game.CharacterClass;
import game.CharacterRace;
import game.MonsterRace;
import gameEncounter.Deck;
import gameEncounter.Hero;
import gameEncounter.Weapon;
import gameEncounter.CardLibrary.Block;
import gameEncounter.CardLibrary.Bullwork;
import gameEncounter.CardLibrary.CarefulSlash;
import gameEncounter.CardLibrary.Concentrate;
import gameEncounter.CardLibrary.FireArrow;
import gameEncounter.CardLibrary.FrostArrow;
import gameEncounter.CardLibrary.HeadShot;
import gameEncounter.CardLibrary.MeeleAttack;
import gameEncounter.CardLibrary.RangedAttack;
import gameEncounter.CardLibrary.Spell;
import gameEncounter.CardLibrary.PoisonShot;
import gameEncounter.ItemLibrary.GoblinBow;
import gameEncounter.ItemLibrary.ItemHand1;
import gameEncounter.ItemLibrary.RustyBlade;
import gameEncounter.buffLibrary.Bashed;
import gameEncounter.CardLibrary.AttackCard;
import gameEncounter.CardLibrary.Bash;
import gameEncounter.CardLibrary.BasicAttack;
import gameEncounter.CardLibrary.BleedingSlice;

public class RaceZombie extends MonsterRace{

	public RaceZombie() {
		name="zombie";
		//set Position classes
		position1Classes.add(new ZombieWarrior());
		position2Classes.add(new ZombieWarrior());
		position3Classes.add(new ZombieWarrior());
		position4Classes.add(new ZombieWarrior());
		position5Classes.add(new ZombieWarrior());
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
		hero.setAccuracy(8);
		hero.setDodge(1);
		hero.setSpellPower(8);
		hero.setSpellResist(20);
		//
		//resistances
		hero.setResistFire(0);
		hero.setResistCold(40);
		hero.setResistBleed(60);
		hero.setResistPoison(80);
		hero.setResistStun(60);
		//
		hero.setGood(false);
		hero.setGold((int)(Math.random()*5.0));
		hero.setExperienceValue(18);
		//zombieslow
		hero.setManaPower(1);
		hero.setResistStress(90);
		//deck		
		
	}
	private class ZombieWarrior extends CharacterClass{

		public ZombieWarrior() {			
			name="";
			items.add(new ZombieClaw());				
			for (int i=0; i<4;i++) {
				cards.add(new BasicAttack());
			}
			for (int i=0; i<6;i++) {
				cards.add(new MeeleAttack());
			}
			cards.add(new Moaning());
			cards.add(new Grab());
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
			hero.setArmor(hero.getArmor()+1);
			hero.setAttackSkill(hero.getAttackSkill()+1);
			hero.setBlockSkill(hero.getBlockSkill()+1);
		}
	}
	private class ZombieClaw extends ItemHand1{
		public ZombieClaw(){
			super();
			droppable=false;
			name="zombie claw";
			setGoldValue(1);
			this.baseDamage=20;
			this.damageRange=4;
			this.facStr=0.95;
			this.weaponRange=2;
		}
		

	}
	private class Moaning extends Spell{

		public Moaning() {
			super();
			manaCost=1;
		}

		@Override
		public int rangeOfCard(Hero hero) {
			// TODO Auto-generated method stub
			return 10;
		}

		@Override
		public boolean applyEffect(Hero self) {
			self.getTarget().becomeStressed(6);
			return true;
		}

		@Override
		public String getName() {
			// TODO Auto-generated method stub
			return "horrible moaning";
		}

		@Override
		public boolean isFriendly() {
			// TODO Auto-generated method stub
			return false;
		}
		
	}
	public class Grab extends AttackCard{
		public Grab() {
			// TODO Auto-generated constructor stub
			manaCost =1;
			damageMult=0.3;
			legalPositions[0]=true;
			legalPositions[1]=false;
			legalPositions[2]=false;
			legalPositions[3]=false;
			legalPositions[4]=false;
		}
		public boolean applyEffect(Hero self) {
				if(self.attackHero(self.getTarget())) {
					damageTarget(self);
					self.getTarget().takeStun();
					self.getTarget().becomeStressed(6);
					return true;
				}else {
					return false;
				}
		}
		@Override
		public String getName() {
			return "Grab";
		}
		@Override
		public String getCardText() {
			//TODO correct number display
			return super.getCardText()+" bash";
		}
	}

}
