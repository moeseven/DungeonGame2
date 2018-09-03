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
import gameEncounter.CardLibrary.Channel;
import gameEncounter.CardLibrary.Concentrate;
import gameEncounter.CardLibrary.FireArrow;
import gameEncounter.CardLibrary.FrostArrow;
import gameEncounter.CardLibrary.HeadShot;
import gameEncounter.CardLibrary.Magicmissile;
import gameEncounter.CardLibrary.MeeleAttack;
import gameEncounter.CardLibrary.RangedAttack;
import gameEncounter.CardLibrary.Spell;
import gameEncounter.CardLibrary.SpellnoTarget;
import gameEncounter.CardLibrary.PoisonShot;
import gameEncounter.ItemLibrary.GoblinBow;
import gameEncounter.ItemLibrary.ItemHand1;
import gameEncounter.ItemLibrary.RustyBlade;
import gameEncounter.buffLibrary.Bashed;
import gameEncounter.CardLibrary.AttackCard;
import gameEncounter.CardLibrary.Bash;
import gameEncounter.CardLibrary.BasicAttack;
import gameEncounter.CardLibrary.BleedingSlice;

public class BossNecromancer extends MonsterRace{

	public BossNecromancer(Game game) {
		super(game);
		name="necromancer";
		//set Position classes
		position1Classes.add(new NecromancerAspirant(game));
		position2Classes.add(null);
		position3Classes.add(null);
		position4Classes.add(null);
		position5Classes.add(null);
	}

	public void modifyHero(Hero hero) {
		super.modifyHero(hero);
		hero.setImage(hero.getPlayer().getGame().imageLoader.getImage(66));
		hero.setSpeed(12);
		hero.setBaseHp(220);		
		//stats
		hero.setStrength(12);
		hero.setDexterity(14);
		hero.setIntelligence(34);
		hero.setVitality(12);
		//
		//attack/defence
		hero.setAttackSkill(12);
		hero.setBlockSkill(10);
		hero.setAccuracy(14);
		hero.setDodge(13);
		hero.setSpellPower(35);
		hero.setSpellResist(14);
		//
		//resistances
		hero.setResistFire(4);
		hero.setResistCold(10);
		hero.setResistBleed(10);
		hero.setResistPoison(30);
		hero.setResistStun(30);
		//
		hero.setGood(false);
		hero.setGold((int)(Math.random()*45.0));
		hero.setExperienceValue(195);
		//boss
		hero.setManaPower(3);
		hero.setDraw(5);
		//deck		
		
	}
	private class NecromancerAspirant extends CharacterClass{

		public NecromancerAspirant(Game game) {	
			super(game);
			name="";
			items.add(new ZombieClaw());				
			for (int i=0; i<5;i++) {				
				cards.add(new Block());
			}
			//attacks
			cards.add(new BasicAttack());
			cards.add(new BasicAttack());
			cards.add(new BasicAttack());
			cards.add(new MeeleAttack());
			//spells
			cards.add(new Magicmissile());
			cards.add(new Magicmissile());
			cards.add(new Magicmissile());
			cards.add(new SummonZombie());
			cards.add(new SummonZombie());
			cards.add(new Channel());
			
			for (int i=0; i<6;i++) {
				
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
			hero.setArmor(hero.getArmor()+3);
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
	private class SummonZombie extends SpellnoTarget{

		public SummonZombie() {
			super();
			manaCost=3;
		}

		@Override
		public boolean extraCastConditions(Hero hero) {
			boolean isThereSpace=false;
			if(hero.getPlayer().getGroupSize()-1-hero.getPlayer().getHeroes().size()>0) {
				isThereSpace=true;
			}
			return isThereSpace;
		}

		@Override
		public boolean applyEffect(Hero self) {
			MonsterRace monster= new RaceZombie(game);
			self.getPlayer().addHero(new Hero("", self.getPlayer(), monster, monster.getPosition1Classes().getFirst()));
			self.getPlayer().getHeroes().getFirst().setUpHandPile();
			return true;
		}

		@Override
		public String getName() {
			// TODO Auto-generated method stub
			return "summon Zombie";
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
			legalCastPositions[0]=true;
			legalCastPositions[1]=false;
			legalCastPositions[2]=false;
			legalCastPositions[3]=false;
			legalCastPositions[4]=false;
		}
		public boolean applyEffect(Hero self) {
				if(self.attackHero(self.getTarget(),this)) {
					damageTarget(self);
					self.getTarget().buffHero(new Bashed());
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
		public LinkedList<String> getCardText(Hero hero) {
			LinkedList<String> textList= new LinkedList<String>();
			textList.add(" bash");
			return textList;
		}
	}

}
