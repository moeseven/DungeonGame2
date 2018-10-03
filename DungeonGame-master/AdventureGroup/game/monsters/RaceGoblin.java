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
		position1Classes.add(new GoblinWarrior(game));
		position2Classes.add(new GoblinWarrior(game));
		position3Classes.add(new GoblinArcher(game));
		position4Classes.add(new GoblinArcher(game));
		position5Classes.add(new GoblinArcher(game));
	}

	public void modifyHero(Hero hero) {
		super.modifyHero(hero);
//		hero.setImage(hero.getPlayer().getGame().imageLoader.getImage(40));
		hero.setImageNumber(40);
		hero.setSpeed(11);
		hero.setBaseHp(60);		
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
		hero.setResistBleed(7);
		hero.setResistPoison(15);
		hero.setResistStun(5);
		//
		hero.setGood(false);
		hero.setGold((int)(Math.random()*9.0));
		hero.setExperienceValue(10);
		hero.setStressCap(71);
		//deck		
		
	}
	private class GoblinWarrior extends CharacterClass{

		public GoblinWarrior(Game game) {	
			super(game);
			name="warrior";		
			items.add(game.itemBuilder.buildItem("rustyBlade",4));	
			for (int i=0; i<4;i++) {
				cards.add(game.cardBuilder.buildCard("meeleAttack"));
			}
			cards.add(game.cardBuilder.buildCard("basicAttack"));
			for (int i=0; i<6;i++) {
				cards.add(game.cardBuilder.buildCard("basicBlock"));
			}
			cards.add(game.cardBuilder.buildCard("carefulSlash"));
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
			hero.setVitality(hero.getVitality()+1);
			//
			hero.setAccuracy(hero.getAccuracy()+2);
			hero.setAttackSkill(hero.getAttackSkill()+7);
		}


	}


}
