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

public class RaceRat extends MonsterRace{

	public RaceRat() {
		name="rat";
		//set Position classes
		position1Classes.add(new RatWarrior());
		position2Classes.add(new RatWarrior());
		position3Classes.add(new RatWarrior());
		position4Classes.add(new RatWarrior());
		position5Classes.add(new RatWarrior());
	}

	public void modifyHero(Hero hero) {
		super.modifyHero(hero);
		hero.setSpeed(17);
		hero.setBaseHp(35);		
		//stats
		hero.setStrength(10);
		hero.setDexterity(23);
		hero.setIntelligence(11);
		hero.setVitality(7);
		//
		//attack/defence
		hero.setAttackSkill(6);
		hero.setBlockSkill(3);
		hero.setAccuracy(12);
		hero.setDodge(1);
		hero.setSpellPower(8);
		hero.setSpellResist(5);
		//
		//resistances
		hero.setResistFire(10);
		hero.setResistCold(10);
		hero.setResistBleed(6);
		hero.setResistPoison(45);
		hero.setResistStun(5);
		//
		hero.setGood(false);
		hero.setGold(0);
		hero.setExperienceValue(8);
		//zombieslow
		hero.setManaPower(2);
		//deck		
		
	}
	private class RatWarrior extends CharacterClass{

		public RatWarrior() {			
			name="";
			items.add(new RatClaw());				
			for (int i=0; i<7;i++) {
				cards.add(new Bite());
			}
			for (int i=0; i<1;i++) {
				cards.add(new Block());
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
			hero.setArmor(hero.getArmor()+1);
			hero.setAttackSkill(hero.getAttackSkill()+1);
			hero.setBlockSkill(hero.getBlockSkill()+1);
		}
	}
	private class RatClaw extends ItemHand1{
		public RatClaw(){
			super();
			droppable=false;
			name="rat";
			setGoldValue(1);
			this.baseDamage=12;
			this.damageRange=4;
			this.facStr=0.45;
			this.weaponRange=2;
		}
		

	}
	private class Bite extends AttackCard{

		public Bite() {
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
			if(self.attackHero(self.getTarget())) {
				damageTarget(self);
				self.getTarget().bleed(1);
				self.getTarget().becomeStressed((int) (3*Math.random()));
				return true;
			}else {
				return false;
			}
		}

		@Override
		public String getName() {
			// TODO Auto-generated method stub
			return "bite";
		}

		@Override
		public boolean isFriendly() {
			// TODO Auto-generated method stub
			return false;
		}
		
	}

}
