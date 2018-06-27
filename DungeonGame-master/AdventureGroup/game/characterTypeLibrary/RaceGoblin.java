package game.characterTypeLibrary;

import java.util.LinkedList;

import game.CharacterClass;
import game.CharacterRace;
import game.MonsterRace;
import gameEncounter.Deck;
import gameEncounter.Hero;
import gameEncounter.CardLibrary.Block;
import gameEncounter.CardLibrary.Bullwork;
import gameEncounter.CardLibrary.CarefulSlash;
import gameEncounter.CardLibrary.Concentrate;
import gameEncounter.CardLibrary.FireArrow;
import gameEncounter.CardLibrary.FrostArrow;
import gameEncounter.CardLibrary.HeadShot;
import gameEncounter.CardLibrary.MeeleAttack;
import gameEncounter.CardLibrary.RangedAttack;
import gameEncounter.CardLibrary.PoisonShot;
import gameEncounter.ItemLibrary.GoblinBow;
import gameEncounter.ItemLibrary.RustyBlade;
import gameEncounter.CardLibrary.Bash;
import gameEncounter.CardLibrary.BasicAttack;
import gameEncounter.CardLibrary.BleedingSlice;

public class RaceGoblin extends MonsterRace{

	public RaceGoblin() {
		name="goblin";
		//set Position classes
		position1Classes.add(new GoblinWarrior());
		position2Classes.add(new GoblinWarrior());
		position3Classes.add(new GoblinArcher());
		position4Classes.add(new GoblinArcher());
		position5Classes.add(new GoblinArcher());
	}

	public void modifyHero(Hero hero) {
		super.modifyHero(hero);
		hero.setSpeed(11);
		hero.setBaseHp(70);		
		//stats
		hero.setStrength(7);
		hero.setDexterity(9);
		hero.setIntelligence(7);
		hero.setVitality(6);
		//
		//attack/defence
		hero.setAttackSkill(6);
		hero.setBlockSkill(5);
		hero.setAccuracy(9);
		hero.setDodge(12);
		hero.setSpellPower(8);
		hero.setSpellResist(6);
		//
		//resistances
		hero.setResistFire(12);
		hero.setResistCold(3);
		hero.setResistBleed(4);
		hero.setResistPoison(8);
		hero.setResistStun(0);
		//
		hero.setGood(false);
		hero.setGold((int)(Math.random()*5.0));
		hero.setExperienceValue(10);
		
		//deck		
		
	}
	private class GoblinWarrior extends CharacterClass{

		public GoblinWarrior() {			
			name="warrior";
			items.add(new RustyBlade());				
			for (int i=0; i<4;i++) {
				cards.add(new MeeleAttack());
			}
			cards.add(new BasicAttack());
			for (int i=0; i<5;i++) {
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
			hero.setVitality(hero.getVitality()+6);
			//
			hero.setAttackSkill(hero.getAttackSkill()+1);
			hero.setBlockSkill(hero.getBlockSkill()+1);
		}
	}
	private class GoblinArcher extends CharacterClass{

		public GoblinArcher() {
			name="archer";
			items.add(new GoblinBow());		
			for (int i=0; i<7;i++) {
				cards.add(new RangedAttack());
			}
			cards.add(new BasicAttack());
			cards.add(new Block());
			cards.add(new Block());
			cardPool.add(new PoisonShot());
			cardPool.add(new HeadShot());
		}

		public void modifyHero(Hero hero) {
			// TODO Auto-generated method stub
			super.modifyHero(hero);
			//mainstats
			hero.setStrength(hero.getStrength()+1);
			hero.setDexterity(hero.getDexterity()+2);
			hero.setIntelligence(hero.getIntelligence()+1);
			hero.setVitality(hero.getVitality()+1);
			//
			hero.setAccuracy(hero.getAccuracy()+2);
		}


	}


}
