package game.monsters;

import java.util.LinkedList;

import game.CharacterClass;
import game.CharacterRace;
import game.Game;
import game.MonsterRace;
import gameEncounter.Deck;
import gameEncounter.Hero;

public class RaceGoblin extends MonsterRace{

	public RaceGoblin(Game game) {
		super(game);
		name="goblin";
		//set Position classes
		position1Classes.add(new GoblinWarrior(game));position1Classes.add(new GoblinDefender(game));
		position2Classes.add(new GoblinWarrior(game));
		position3Classes.add(new GoblinArcher(game));position3Classes.add(new GoblinShaman(game));position3Classes.add(new GoblinWarrior(game));position3Classes.add(new GoblinPiker(game));
		position4Classes.add(new GoblinArcher(game));position4Classes.add(new GoblinShaman(game));position4Classes.add(new GoblinArcher(game));position4Classes.add(new GoblinPiker(game));
		position5Classes.add(new GoblinShaman(game));position5Classes.add(new GoblinArcher(game));
	}

	public void modifyHero(Hero hero) {
		super.modifyHero(hero);
//		hero.setImage(hero.getPlayer().getGame().imageLoader.getImage(40));
		hero.setImageNumber(40);
		hero.setSpeed(11);
		hero.setBaseHp(55);		
		//stats
		hero.setStrength(5);
		hero.setDexterity(7);
		hero.setIntelligence(5);
		hero.setVitality(5);
		//
		//attack/defence
		hero.setAttackSkill(5);
		hero.setBlockSkill(5);
		hero.setAccuracy(9);
		hero.setDodge(12);
		hero.setSpellPower(8);
		hero.setSpellResist(6);
		//
		//resistances
		hero.setResistFire(12);
		hero.setResistCold(3);
		hero.setResistBleed(7);
		hero.setResistPoison(15);
		hero.setResistStun(5);
		//
		hero.setArmor(8);
		hero.setGood(false);
		hero.setGold((int)(Math.random()*9.0));
		hero.setExperienceValue(22);
		hero.setDraw(4);
		hero.setStressCap(71);
		//deck		
		
	}
	private class GoblinWarrior extends CharacterClass{

		public GoblinWarrior(Game game) {	
			super(game);
			name="warrior";		
			items.add(game.itemBuilder.buildItem("rustyBlade",4));	
			for (int i=0; i<2;i++) {
				cards.add(game.cardBuilder.buildCard("meeleAttack"));
				cards.add(game.cardBuilder.buildCard("shortStrike"));
				cards.add(game.cardBuilder.buildCard("basicAttack"));
			}			
			cards.add(game.cardBuilder.buildCard("advancingAttack"));
			for (int i=0; i<6;i++) {
				cards.add(game.cardBuilder.buildCard("basicBlock"));
			}
			cards.add(game.cardBuilder.buildCard("bleedingSlice"));
			cards.add(game.cardBuilder.buildCard("bleedingSlice"));
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
			
			hero.setBlockSkill(hero.getBlockSkill()+8);
		}
	}
	private class GoblinDefender extends CharacterClass{

		public GoblinDefender(Game game) {	
			super(game);
			name="defender";		
			items.add(game.itemBuilder.buildItem("rustyBlade",5));	
			items.add(game.itemBuilder.buildItem("buckler", 5));
			for (int i=0; i<2;i++) {
				cards.add(game.cardBuilder.buildCard("meeleAttack"));
				cards.add(game.cardBuilder.buildCard("shortStrike"));
				cards.add(game.cardBuilder.buildCard("basicAttack"));
			}
			cards.add(game.cardBuilder.buildCard("advancingAttack"));
			for (int i=0; i<6;i++) {
				cards.add(game.cardBuilder.buildCard("basicBlock"));
			}
			cards.add(game.cardBuilder.buildCard("sideStep"));
		}

		public void modifyHero(Hero hero) {
			// TODO Auto-generated method stub
			super.modifyHero(hero);
			//mainstats
			hero.setImageNumber(46);
			hero.setStrength(hero.getStrength()+4);
			hero.setDodge(hero.getDodge()-7);
			hero.setIntelligence(hero.getIntelligence()+0);
			hero.setVitality(hero.getVitality()+9);
			//
			hero.setArmor(hero.getArmor()+20);
			
			hero.setBlockSkill(hero.getBlockSkill()+8);
		}
	}
	private class GoblinPiker extends CharacterClass{

		public GoblinPiker(Game game) {	
			super(game);
			name="piker";		
			items.add(game.itemBuilder.buildItem("spear",8));	
			for (int i=0; i<2;i++) {
				cards.add(game.cardBuilder.buildCard("meeleAttack"));				
				cards.add(game.cardBuilder.buildCard("basicAttack"));
			}
			
			for (int i=0; i<3;i++) {
				cards.add(game.cardBuilder.buildCard("basicBlock"));
			}
			cards.add(game.cardBuilder.buildCard("carefulSlash"));
			cards.add(game.cardBuilder.buildCard("chargeAttack"));
		}

		public void modifyHero(Hero hero) {
			// TODO Auto-generated method stub
			super.modifyHero(hero);
			//mainstats
			hero.setImageNumber(45);
			hero.setAttackSkill(hero.getAttackSkill()+10);
			hero.setDexterity(hero.getDexterity()-2);
			//
			hero.setArmor(hero.getArmor()+1);			
			hero.setBlockSkill(hero.getBlockSkill()-3);
		}
	}
	private class GoblinArcher extends CharacterClass{

		public GoblinArcher(Game game) {
			super(game);
			name="archer";	
			items.add(game.itemBuilder.buildItem("shortBow",4));	
			for (int i=0; i<5;i++) {
				cards.add(game.cardBuilder.buildCard("rangedAttack"));
			}
			cards.add(game.cardBuilder.buildCard("basicBlock"));
			cards.add(game.cardBuilder.buildCard("basicBlock"));
			cards.add(game.cardBuilder.buildCard("basicBlock"));
			cards.add(game.cardBuilder.buildCard("poisonShot"));
			cards.add(game.cardBuilder.buildCard("basicAttack"));
			cards.add(game.cardBuilder.buildCard("basicAttack"));
		}

		public void modifyHero(Hero hero) {
			// TODO Auto-generated method stub
			super.modifyHero(hero);
			//hero.setImage(hero.getPlayer().getGame().imageLoader.getImage(41));
			hero.setImageNumber(41);
			//mainstats
			hero.setStrength(hero.getStrength()+1);
			hero.setDexterity(hero.getDexterity()+2);
			hero.setIntelligence(hero.getIntelligence()+1);
			hero.setVitality(hero.getVitality()-1);
			//
			hero.setAccuracy(hero.getAccuracy()+2);
			hero.setAttackSkill(hero.getAttackSkill()+7);
		}


	}
	private class GoblinShaman extends CharacterClass{

		public GoblinShaman(Game game) {
			super(game);
			name="shaman";	
			items.add(game.itemBuilder.buildItem("rootWand",5));	
			for (int i=0; i<5;i++) {
				cards.add(game.cardBuilder.buildCard("basicAttack"));
				cards.add(game.cardBuilder.buildCard("basicBlock"));
			}			
			cards.add(game.cardBuilder.buildCard("growth"));
			cards.add(game.cardBuilder.buildCard("growth"));
			cards.add(game.cardBuilder.buildCard("magicMissile"));
			cards.add(game.cardBuilder.buildCard("fireBall"));
		}

		public void modifyHero(Hero hero) {
			// TODO Auto-generated method stub
			super.modifyHero(hero);
			//hero.setImage(hero.getPlayer().getGame().imageLoader.getImage(41));
			hero.setImageNumber(68);
			//mainstats
			hero.setStrength(hero.getStrength()-1);
			hero.setDexterity(hero.getDexterity()-2);
			hero.setIntelligence(hero.getIntelligence()+9);
			hero.setSpellDuration(12);
			hero.setVitality(hero.getVitality()-4);
			//
			hero.setAccuracy(hero.getAccuracy()-2);
			hero.setAttackSkill(hero.getAttackSkill()-2);
		}


	}


}
