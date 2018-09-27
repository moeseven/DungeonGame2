package game.monsters;

import java.util.LinkedList;

import game.CharacterClass;
import game.CharacterRace;
import game.Game;
import game.MonsterRace;
import gameEncounter.Deck;
import gameEncounter.Hero;
import gameEncounter.CardLibrary.Block;
import gameEncounter.CardLibrary.Bullwork;
import gameEncounter.CardLibrary.CarefulSlash;
import gameEncounter.CardLibrary.Cleave;
import gameEncounter.CardLibrary.Concentrate;
import gameEncounter.CardLibrary.FireArrow;
import gameEncounter.CardLibrary.FrostArrow;
import gameEncounter.CardLibrary.HeadShot;
import gameEncounter.CardLibrary.Magicmissile;
import gameEncounter.CardLibrary.MeeleAttack;
import gameEncounter.CardLibrary.RangedAttack;
import gameEncounter.CardLibrary.SleepCharm;
import gameEncounter.CardLibrary.PoisonShot;
import gameEncounter.ItemLibrary.GoblinBow;
import gameEncounter.ItemLibrary.HeavySword;
import gameEncounter.ItemLibrary.RustyBlade;
import gameEncounter.ItemLibrary.ShortBow;
import gameEncounter.CardLibrary.Bash;
import gameEncounter.CardLibrary.BasicAttack;
import gameEncounter.CardLibrary.BleedingSlice;

public class RaceSkeletton extends MonsterRace{

	public RaceSkeletton(Game game) {
		super(game);
		name="skeletton";
		//set Position classes
		position1Classes.add(new SkelettonWarrior(game));
		position1Classes.add(new SkelettonHulk(game));
		position2Classes.add(new SkelettonWarrior(game));
		//3
		position3Classes.add(new SkelettonArcher(game));
		position3Classes.add(new SkelettonMage(game));
		//4
		position4Classes.add(new SkelettonArcher(game));
		position5Classes.add(new SkelettonArcher(game));
	}

	public void modifyHero(Hero hero) {
		super.modifyHero(hero);
		//hero.setImage(hero.getPlayer().getGame().imageLoader.getImage(49));
		hero.setImageNumber(49);
		hero.setSpeed(11);
		hero.setBaseHp(90);		
		//stats
		hero.setStrength(21);
		hero.setDexterity(21);
		hero.setIntelligence(19);
		hero.setVitality(9);
		//
		//attack/defence
		hero.setAttackSkill(11);
		hero.setBlockSkill(11);
		hero.setAccuracy(12);
		hero.setDodge(11);
		hero.setSpellPower(11);
		hero.setSpellResist(11);
		//
		//resistances
		hero.setResistFire(12);
		hero.setResistCold(33);
		hero.setResistBleed(100);
		hero.setResistPoison(15);
		hero.setResistStun(15);
		//
		hero.setGood(false);
		hero.setGold((int)(Math.random()*10.0));
		hero.setExperienceValue(20);
		hero.setResistStress(20);
		hero.setDraw(4);
		//deck		
		
	}
	private class SkelettonWarrior extends CharacterClass{

		public SkelettonWarrior(Game game) {	
			super(game);
			name="warrior";
			items.add(new RustyBlade());				
			for (int i=0; i<4;i++) {
				cards.add(new MeeleAttack());
			}
			cards.add(new BasicAttack());
			for (int i=0; i<6;i++) {
				cards.add(new Block());
			}
			cards.add(new CarefulSlash());
			cards.add(new BleedingSlice());
		}

		public void modifyHero(Hero hero) {
			// TODO Auto-generated method stub
			super.modifyHero(hero);
			//mainstats
			hero.setStrength(hero.getStrength()+3);
			hero.setDexterity(hero.getDexterity()+2);
			hero.setIntelligence(hero.getIntelligence()+0);
			hero.setVitality(hero.getVitality()+9);
			//
			hero.setArmor(hero.getArmor()+5);
			hero.setAttackSkill(hero.getAttackSkill()+1);
			hero.setBlockSkill(hero.getBlockSkill()+1);
		}
	}
	private class SkelettonHulk extends CharacterClass{

		public SkelettonHulk(Game game) {	
			super(game);
			name="hulk";
			items.add(new HeavySword());				
			for (int i=0; i<4;i++) {
				cards.add(new MeeleAttack());
			}
			cards.add(new BasicAttack());
			for (int i=0; i<6;i++) {
				cards.add(new Block());
			}
			cards.add(new CarefulSlash());
			cards.add(new Bash());
			cards.add(new BleedingSlice());
			cards.add(new Cleave());
		}

		public void modifyHero(Hero hero) {
			// TODO Auto-generated method stub
			super.modifyHero(hero);
			//mainstats
			hero.setStrength(hero.getStrength()+14);
			hero.setDexterity(hero.getDexterity()+2);
			hero.setIntelligence(hero.getIntelligence()+0);
			hero.setVitality(hero.getVitality()+29);
			//
			hero.setArmor(hero.getArmor()+7);
			hero.setAttackSkill(hero.getAttackSkill()+5);
			hero.setBlockSkill(hero.getBlockSkill()+5);
			hero.setSpeed(hero.getSpeed()-4);
		}
	}
	private class SkelettonArcher extends CharacterClass{

		public SkelettonArcher(Game game) {
			super(game);
			name="archer";
			items.add(new ShortBow());		
			for (int i=0; i<7;i++) {
				cards.add(new RangedAttack());
			}
			cards.add(new BasicAttack());
			cards.add(new Block());
			cards.add(new Block());
			cards.add(new FrostArrow());
			cards.add(new FrostArrow());
			cards.add(new HeadShot());
		}

		public void modifyHero(Hero hero) {
			// TODO Auto-generated method stub
			super.modifyHero(hero);
			//hero.setImage(hero.getPlayer().getGame().imageLoader.getImage(50));
			hero.setImageNumber(50);
			//mainstats
			hero.setStrength(hero.getStrength()+1);
			hero.setDexterity(hero.getDexterity()+2);
			hero.setIntelligence(hero.getIntelligence()+1);
			hero.setVitality(hero.getVitality()+1);
			//
			hero.setAccuracy(hero.getAccuracy()+2);
		}


	}
	private class SkelettonMage extends CharacterClass{

		public SkelettonMage(Game game) {
			super(game);
			name="mage";
			items.add(new RustyBlade());				
			for (int i=0; i<4;i++) {
				cards.add(new BasicAttack());
			}
			cards.add(new BasicAttack());
			for (int i=0; i<2;i++) {
				cards.add(new Block());
			}
			cards.add(new SleepCharm());
			cards.add(new Magicmissile());

		}

		public void modifyHero(Hero hero) {
			// TODO Auto-generated method stub
			super.modifyHero(hero);
			//hero.setImage(hero.getPlayer().getGame().imageLoader.getImage(70));
			hero.setImageNumber(70);
			//mainstats
			hero.setStrength(hero.getStrength()-3);
			hero.setDexterity(hero.getDexterity()-2);
			hero.setIntelligence(hero.getIntelligence()+9);
			hero.setVitality(hero.getVitality()+0);
			//
			hero.setArmor(hero.getArmor()+0);
			hero.setAttackSkill(hero.getAttackSkill()-1);
			hero.setBlockSkill(hero.getBlockSkill()-1);
		}
	}


}
