package game.monsters;

import java.util.LinkedList;

import game.CharacterClass;
import game.CharacterRace;
import game.Game;
import game.MonsterRace;
import gameEncounter.Deck;
import gameEncounter.Hero;

public class RaceWall extends MonsterRace{

	public RaceWall(Game game) {
		super(game);
		name="Wall";
		//set Position classes
		position1Classes.add(new IceWall(game));
		position2Classes.add(new IceWall(game));
		position3Classes.add(new IceWall(game));
		position4Classes.add(new IceWall(game));
		position5Classes.add(new IceWall(game));
	}

	public void modifyHero(Hero hero) {
		super.modifyHero(hero);
		//all stats		
		hero.setStrength(0);
		hero.setDexterity(0);		
		hero.setIntelligence(0);
		hero.setVitality(0);
		//main attributes
		hero.setAttackSkill(8);
		hero.setBlockSkill(5);
		hero.setAccuracy(10);
		hero.setDodge(0);
		hero.setSpellPower(8);
		hero.setSpellDuration(8);
		//
		hero.setArmor(10);
		hero.setSpeed(50);					
		hero.setThorns(0);
		hero.setDraw(1);
		hero.setManaPower(1);
		//offensive
		hero.setCritChance(5);
		hero.setCritDamage(40);
		//elemental bonus
		hero.setStunChance(5);
		hero.setFireDmg(5);
		hero.setColdDmg(5);
		hero.setLightningDmg(5);
		hero.setPoisonDmg(5);
		hero.setBleedDmg(5);
		hero.setMagicDmg(5);		
		//resistance
		hero.setResistSpell(10);
		hero.setResistFire(-20);
		hero.setResistLightning(5);
		hero.setResistCold(100);
		hero.setResistPoison(100);
		hero.setResistBleed(100);
		hero.setResistStun(100);
		hero.setResistStress(100);
		hero.setStressCap(1000);
		//
		hero.setTrapDisarm(0);
		hero.setBaseHp(100);		
		//
		hero.setImageNumber(110);	
		//
		hero.setGood(false);
		hero.setGold(0);
		hero.setExperienceValue(1);
		//deck		
		for (int i=0; i<2;i++) {
			cards.add(game.cardBuilder.buildCard("basicBlock"));				
		}
	}
	private class IceWall extends CharacterClass{

		public IceWall(Game game) {	
			super(game);
			name="ice";		
		}

		public void modifyHero(Hero hero) {
			super.modifyHero(hero);
			
			hero.setImageNumber(110);
			hero.setArmor(hero.getArmor()+5);			
			hero.setBlockSkill(hero.getBlockSkill()+10);
		}
	}


}
