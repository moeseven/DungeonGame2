package game.monsters;

import java.util.LinkedList;

import game.CharacterClass;
import game.CharacterRace;
import game.Game;
import game.MonsterRace;
import gameEncounter.Deck;
import gameEncounter.Hero;
import gameEncounter.Weapon;
import gameEncounter.CardLibrary.SpellnoTarget;
import gameEncounter.ItemLibrary.GoblinBow;
import gameEncounter.ItemLibrary.ItemHand1;
import gameEncounter.ItemLibrary.RustyBlade;
import gameEncounter.buffLibrary.Bashed;

public class BossNecromancer extends MonsterRace{

	public BossNecromancer(Game game) {
		super(game);
		name="necromancer";
		//set Position classes
		position1Classes.add(new NecromancerAspirant(game));
		position2Classes.add(new NecromancerAspirant(game));
		position3Classes.add(new NecromancerAspirant(game));
		position4Classes.add(new NecromancerAspirant(game));
		position5Classes.add(new NecromancerAspirant(game));
	}

	public void modifyHero(Hero hero) {
		super.modifyHero(hero);
		//all stats		
		hero.setStrength(12);
		hero.setDexterity(14);		
		hero.setIntelligence(34);
		hero.setVitality(12);
		//main attributes
		hero.setAttackSkill(12);
		hero.setBlockSkill(10);
		hero.setAccuracy(14);
		hero.setDodge(13);
		hero.setSpellPower(35);
		hero.setSpellDuration(7);
		//
		hero.setArmor(9);
		hero.setSpeed(16);					
		hero.setThorns(0);
		hero.setDraw(6);
		hero.setManaPower(3);
		//offensive
		hero.setCritChance(5);
		hero.setCritDamage(40);
		//elemental bonus
		hero.setStunChance(0);
		hero.setFireDmg(10);
		hero.setColdDmg(10);
		hero.setLightningDmg(25);
		hero.setPoisonDmg(5);
		hero.setBleedDmg(15);
		hero.setMagicDmg(5);		
		//resistance
		hero.setResistSpell(10);
		hero.setResistFire(0);
		hero.setResistLightning(5);
		hero.setResistCold(20);
		hero.setResistPoison(35);
		hero.setResistBleed(10);
		hero.setResistStun(30);
		hero.setResistStress(30);
		hero.setStressCap(100);
		//
		hero.setTrapDisarm(10);
		hero.setBaseHp(220);		
		//
		hero.setImageNumber(40);	
		//
		hero.setGood(false);
		hero.setGold((int)(Math.random()*99.0));
		hero.setExperienceValue(110);
		hero.setImageNumber(66);		
		hero.setUndead(true);
		items.add(game.itemBuilder.buildItem("crystalOrb", 3));
		
	}
	private class NecromancerAspirant extends CharacterClass{

		public NecromancerAspirant(Game game) {	
			super(game);
			name="";				
			for (int i=0; i<5;i++) {	
				cards.add(game.cardBuilder.buildCard("basicBlock"));				
			}
			cards.add(game.cardBuilder.buildCard("basicAttack"));
			cards.add(game.cardBuilder.buildCard("basicAttack"));
			cards.add(game.cardBuilder.buildCard("basicAttack"));
			cards.add(game.cardBuilder.buildCard("magicShield"));
			cards.add(game.cardBuilder.buildCard("energize"));
			cards.add(game.cardBuilder.buildCard("energize"));
			//attacks
			cards.add(game.cardBuilder.buildCard("poisonousSlice"));
			//spells
			cards.add(game.cardBuilder.buildCard("sparks"));
			cards.add(game.cardBuilder.buildCard("growth"));
			cards.add(game.cardBuilder.buildCard("growth"));
			cards.add(game.cardBuilder.buildCard("magicMissile"));
			cards.add(game.cardBuilder.buildCard("magicMissile"));
			cards.add(game.cardBuilder.buildCard("magicMissile"));
			cards.add(game.cardBuilder.buildCard("channel"));
			cards.add(game.cardBuilder.buildCard("sleepCharm"));
			cards.add(game.cardBuilder.buildCard("sleepCharm"));
			cards.add(game.cardBuilder.buildCard("summonZombie"));
			cards.add(game.cardBuilder.buildCard("summonZombie"));
			cards.add(game.cardBuilder.buildCard("summonZombie"));
			cards.add(game.cardBuilder.buildCard("summonZombie"));
			cards.add(game.cardBuilder.buildCard("summonZombie"));
			cards.add(game.cardBuilder.buildCard("summonZombie"));
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

}
