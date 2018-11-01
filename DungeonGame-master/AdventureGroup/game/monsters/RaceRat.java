package game.monsters;

import java.util.LinkedList;

import game.CharacterClass;
import game.CharacterRace;
import game.Game;
import game.MonsterRace;
import gameEncounter.Deck;
import gameEncounter.Hero;
import gameEncounter.Weapon;

public class RaceRat extends MonsterRace{

	public RaceRat(Game game) {
		super(game);
		name="rat";
		//set Position classes
		position1Classes.add(new RatWarrior(game));
		position2Classes.add(new RatWarrior(game));
		position3Classes.add(new RatWarrior(game));
		position4Classes.add(new RatWarrior(game));
		position5Classes.add(new RatWarrior(game));
	}

	public void modifyHero(Hero hero) {
		super.modifyHero(hero);
		//all stats		
		hero.setStrength(8);
		hero.setDexterity(19);
		hero.setVitality(11);
		hero.setIntelligence(6);
		//main attributes
		hero.setAttackSkill(5);
		hero.setBlockSkill(0);
		hero.setAccuracy(21);
		hero.setDodge(13);
		hero.setSpellPower(6);
		hero.setSpellDuration(4);
		//
		hero.setArmor(3);
		hero.setSpeed(17);					
		hero.setThorns(0);
		hero.setDraw(4);
		hero.setManaPower(1);
		//offensive
		hero.setCritChance(9);
		hero.setCritDamage(30);
		//elemental bonus
		hero.setStunChance(0);
		hero.setFireDmg(0);
		hero.setColdDmg(0);
		hero.setLightningDmg(5);
		hero.setPoisonDmg(5);
		hero.setBleedDmg(35);
		hero.setMagicDmg(5);		
		//resistance
		hero.setResistSpell(-20);
		hero.setResistFire(5);
		hero.setResistLightning(5);
		hero.setResistCold(15);
		hero.setResistPoison(40);
		hero.setResistBleed(10);
		hero.setResistStun(10);
		hero.setResistStress(-20);
		hero.setStressCap(81);
		//
		hero.setTrapDisarm(10);
		hero.setBaseHp(40);		
		//
		hero.setImageNumber(40);	
		//
		hero.setGood(false);
		hero.setGold(0);
		hero.setExperienceValue(4);
		hero.setImageNumber(54);	
	}
	private class RatWarrior extends CharacterClass{

		public RatWarrior(Game game) {	
			super(game);
			name="";			
			for (int i=0; i<6;i++) {
				cards.add(game.cardBuilder.buildCard("bite"));
			}
			for (int i=0; i<3;i++) {
				cards.add(game.cardBuilder.buildCard("basicBlock"));
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
}
