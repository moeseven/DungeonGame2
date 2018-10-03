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
//		hero.setImage(hero.getPlayer().getGame().imageLoader.getImage(54));
		hero.setImageNumber(54);
		hero.setSpeed(17);
		hero.setBaseHp(43);		
		//stats
		hero.setStrength(8);
		hero.setDexterity(19);
		hero.setIntelligence(11);
		hero.setVitality(7);
		//
		//attack/defence
		hero.setAttackSkill(9);
		hero.setBlockSkill(3);
		hero.setAccuracy(21);
		hero.setDodge(13);
		hero.setSpellPower(8);
		hero.setSpellResist(5);
		//
		//resistances
		hero.setResistFire(10);
		hero.setResistCold(10);
		hero.setResistBleed(6);
		hero.setResistPoison(45);
		hero.setResistStun(5);
		//
		hero.setGood(false);
		hero.setGold(0);
		hero.setExperienceValue(8);
		//zombieslow
		hero.setManaPower(1);
		//deck		
		
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
