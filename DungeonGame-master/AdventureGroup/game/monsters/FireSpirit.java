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
//		hero.setImage(hero.getPlayer().getGame().imageLoader.getImage(52));
		hero.setImageNumber(52);
		hero.setSpeed(19);
		hero.setBaseHp(52);		
		//stats
		hero.setStrength(7);
		hero.setDexterity(8);
		hero.setIntelligence(9);
		hero.setVitality(6);
		//
		//attack/defence
		hero.setAttackSkill(88);
		hero.setBlockSkill(25);
		hero.setAccuracy(9);
		hero.setDodge(9);
		hero.setSpellPower(9);
		hero.setSpellResist(0);
		//
		//resistances
		hero.setResistFire(95);
		hero.setResistCold(0);
		hero.setResistBleed(95);
		hero.setResistPoison(15);
		hero.setResistStun(5);
		//
		hero.setGood(false);
		hero.setGold((int)(Math.random()*5.0));
		hero.setExperienceValue(60);
		hero.setStressCap(61);
		//deck		
		
	}
	private class FireSpiritNormal extends CharacterClass{

		public FireSpiritNormal(Game game) {
			super(game);
			name="";				
			for (int i=0; i<3;i++) {
				cards.add(game.cardBuilder.buildCard("fireFist"));
			}
//			cards.add(new FireFist());
//			cards.add(new FireFist());
//			cards.add(new FireFist());
//			cards.add(new FireFist());
			for (int i=0; i<7;i++) {
				cards.add(game.cardBuilder.buildCard("basicBlock"));
			}
//			cards.add(new Blaze());
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
