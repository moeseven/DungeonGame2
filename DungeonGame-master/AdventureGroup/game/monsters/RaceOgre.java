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
import gameEncounter.CardLibrary.Ram;
import gameEncounter.ItemLibrary.GoblinBow;
import gameEncounter.ItemLibrary.ItemBiHand;
import gameEncounter.ItemLibrary.RustyBlade;
import gameEncounter.buffLibrary.Bashed;
import gameEncounter.CardLibrary.AttackCard;
import gameEncounter.CardLibrary.Bash;
import gameEncounter.CardLibrary.BasicAttack;
import gameEncounter.CardLibrary.BleedingSlice;

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
		hero.setImage(hero.getPlayer().getGame().imageLoader.getImage(42));
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
		hero.setResistPoison(15);
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
			items.add(new OgreClub());	
			cards.add(new Bash());
			cards.add(new Bash());
			cards.add(new Ram());
			for (int i=0; i<3;i++) {
				cards.add(new BasicAttack());
			}
			for (int i=0; i<4;i++) {
				cards.add(new MeeleAttack());
			}
			for (int i=0; i<4;i++) {
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
			hero.setArmor(hero.getArmor()+20);
			hero.setAttackSkill(hero.getAttackSkill()+1);
			hero.setBlockSkill(hero.getBlockSkill()+1);
		}
	}
	private class OgreClub extends ItemBiHand{
		public OgreClub(){
			super();
			droppable=false;
			name="ogre club";
			setGoldValue(1);
			requiredStrength=45;
			this.baseDamage=15;
			this.damageRange=20;
			this.facStr=0.95;
			this.weaponRange=2;
		}
		

	}
}
