package game.monsters;

import java.util.LinkedList;

import game.CharacterClass;
import game.CharacterRace;
import game.Game;
import game.MonsterRace;
import gameEncounter.Deck;
import gameEncounter.Hero;
import gameEncounter.Weapon;

public class Thornback extends MonsterRace{

	public Thornback(Game game) {
		super(game);
		name="thorn back";
		//set Position classes
		position1Classes.add(new NormalThornback(game));
		position2Classes.add(new NormalThornback(game));
		position3Classes.add(new NormalThornback(game));
		position4Classes.add(new NormalThornback(game));
		position5Classes.add(new NormalThornback(game));
	}

	public void modifyHero(Hero hero) {
		super.modifyHero(hero);
		hero.setImageNumber(53);
		hero.setSpeed(7);
		hero.setBaseHp(65);		
		//stats
		hero.setStrength(15);
		hero.setDexterity(13);
		hero.setIntelligence(11);
		hero.setVitality(9);
		//
		//attack/defence
		hero.setAttackSkill(15);
		hero.setBlockSkill(30);
		hero.setAccuracy(11);
		hero.setDodge(7);
		hero.setSpellPower(8);
		hero.setSpellResist(8);
		//
		//resistances
		hero.setArmor(40);
		hero.setThorns(10);
		hero.setResistFire(5);
		hero.setResistCold(30);
		hero.setResistBleed(6);
		hero.setResistPoison(2);
		hero.setResistStun(25);
		//
		hero.setGood(false);
		hero.setGold(0);
		hero.setExperienceValue(25);
		
		//
		hero.setManaPower(2);
		//deck		
		
	}
	private class NormalThornback extends CharacterClass{

		public NormalThornback(Game game) {		
			super(game);
			name="";			
			for (int i=0; i<3;i++) {
				cards.add(game.cardBuilder.buildCard("meeleAttack"));
			}
			cards.add(game.cardBuilder.buildCard("basicAttack"));
			cards.add(game.cardBuilder.buildCard("basicAttack"));
			for (int i=0; i<5;i++) {
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
