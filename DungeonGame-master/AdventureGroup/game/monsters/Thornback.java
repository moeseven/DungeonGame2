package game.monsters;

import java.util.LinkedList;

import game.CharacterClass;
import game.CharacterRace;
import game.Game;
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

public class Thornback extends MonsterRace{

	public Thornback(Game game) {
		super(game);
		name="thorn back";
		//set Position classes
		position1Classes.add(new NormalThornback(game));
		position2Classes.add(new NormalThornback(game));
		position3Classes.add(new NormalThornback(game));
		position4Classes.add(new NormalThornback(game));
		position5Classes.add(new NormalThornback(game));
	}

	public void modifyHero(Hero hero) {
		super.modifyHero(hero);
		//hero.setImage(hero.getPlayer().getGame().imageLoader.getImage(53));
		hero.setImageNumber(53);
		hero.setSpeed(7);
		hero.setBaseHp(65);		
		//stats
		hero.setStrength(15);
		hero.setDexterity(13);
		hero.setIntelligence(11);
		hero.setVitality(9);
		//
		//attack/defence
		hero.setAttackSkill(15);
		hero.setBlockSkill(22);
		hero.setAccuracy(11);
		hero.setDodge(7);
		hero.setSpellPower(8);
		hero.setSpellResist(8);
		//
		//resistances
		hero.setArmor(40);
		hero.setThorns(10);
		hero.setResistFire(5);
		hero.setResistCold(30);
		hero.setResistBleed(6);
		hero.setResistPoison(2);
		hero.setResistStun(25);
		//
		hero.setGood(false);
		hero.setGold(0);
		hero.setExperienceValue(18);
		
		//
		hero.setManaPower(2);
		//deck		
		
	}
	private class NormalThornback extends CharacterClass{

		public NormalThornback(Game game) {		
			super(game);
			name="";
			items.add(new ThornbackClaw());				
			for (int i=0; i<4;i++) {
				cards.add(new MeeleAttack());
			}
			cards.add(new BasicAttack());
			cards.add(new BasicAttack());
			for (int i=0; i<5;i++) {
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
	private class ThornbackClaw extends ItemHand1{
		public ThornbackClaw(){
			super();
			droppable=false;
			name="claw";
			setGoldValue(1);
			this.baseDamage=12;
			this.damageRange=21;
			this.facStr=0.65;
			this.weaponRange=2;
		}
		

	}
	private class Snap extends AttackCard{

		public Snap() {
			super();
			manaCost=1;
		}

		@Override
		public boolean applyEffect(Hero self) {
			if(self.attackHero(self.getTarget(),this)) {
				damageTarget(self);
				return true;
			}else {
				return false;
			}
		}

		@Override
		public String getName() {
			// TODO Auto-generated method stub
			return "snap";
		}

		@Override
		public boolean isFriendly() {
			// TODO Auto-generated method stub
			return false;
		}
		
	}

}
