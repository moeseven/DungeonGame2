package game.monsters;

import java.util.LinkedList;

import game.CharacterClass;
import game.CharacterRace;
import game.Game;
import game.MonsterRace;
import gameEncounter.Deck;
import gameEncounter.Hero;

public class FireSpirit extends MonsterRace{

	public FireSpirit(Game game) {
		super(game);
		name="fire spirit";
		//set Position classes
		position1Classes.add(new FireSpiritNormal(game));
		position2Classes.add(new FireSpiritNormal(game));
		position3Classes.add(new FireSpiritNormal(game));
		position4Classes.add(new FireSpiritNormal(game));
		position5Classes.add(new FireSpiritNormal(game));
	}

	public void modifyHero(Hero hero) {
		super.modifyHero(hero);
		//all stats		
		hero.setStrength(7);
		hero.setDexterity(8);		
		hero.setIntelligence(9);
		hero.setVitality(6);
		//main attributes
		hero.setAttackSkill(88);
		hero.setBlockSkill(55);
		hero.setAccuracy(20);
		hero.setDodge(22);
		hero.setSpellPower(15);
		hero.setSpellDuration(3);
		//
		hero.setArmor(19);
		hero.setSpeed(13);					
		hero.setThorns(0);
		hero.setDraw(4);
		hero.setManaPower(2);
		//offensive
		hero.setCritChance(5);
		hero.setCritDamage(40);
		//elemental bonus
		hero.setStunChance(0);
		hero.setFireDmg(10);
		hero.setColdDmg(0);
		hero.setLightningDmg(5);
		hero.setPoisonDmg(5);
		hero.setBleedDmg(5);
		hero.setMagicDmg(5);		
		//resistance		
		hero.setResistFire(95);
		hero.setResistCold(-50);
		hero.setResistLightning(5);
		hero.setResistBleed(95);
		hero.setResistPoison(55);
		hero.setResistStun(5);
		hero.setResistSpell(7);
		hero.setStressCap(81);
		//
		hero.setTrapDisarm(10);
		hero.setBaseHp(90);		
		//
		hero.setImageNumber(52);	
		//
		hero.setGood(false);
		hero.setGold((int)(Math.random()*19.0));
		hero.setExperienceValue(20);
		//deck		
		
	}
	private class FireSpiritNormal extends CharacterClass{

		public FireSpiritNormal(Game game) {
			super(game);
			name="";				
			for (int i=0; i<3;i++) {
				cards.add(game.cardBuilder.buildCard("fireFist"));
				cards.add(game.cardBuilder.buildCard("basicAttack"));
			}
			cards.add(game.cardBuilder.buildCard("delayedCombustion"));
			for (int i=0; i<7;i++) {
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
			hero.setVitality(hero.getVitality()+3);
			//
			hero.setArmor(hero.getArmor()+1);
			hero.setAttackSkill(hero.getAttackSkill()+1);
			hero.setBlockSkill(hero.getBlockSkill()+1);
		}
	}
}
