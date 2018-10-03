package game.monsters;

import java.util.LinkedList;

import game.CharacterClass;
import game.CharacterRace;
import game.Game;
import game.MonsterRace;
import gameEncounter.Deck;
import gameEncounter.GameEquations;
import gameEncounter.Hero;

public class Spectre extends MonsterRace{

	public Spectre(Game game) {
		super(game);
		name="spectre";
		//set Position classes
		position1Classes.add(new SpectreNormal(game));
		position2Classes.add(new SpectreNormal(game));
		position3Classes.add(new SpectreNormal(game));
		position4Classes.add(new SpectreNormal(game));
		position5Classes.add(new SpectreNormal(game));
	}

	public void modifyHero(Hero hero) {
		super.modifyHero(hero);
		//hero.setImage(hero.getPlayer().getGame().imageLoader.getImage(51));
		hero.setImageNumber(51);
		hero.setSpeed(8);
		hero.setBaseHp(62);		
		//stats
		hero.setStrength(7);
		hero.setDexterity(8);
		hero.setIntelligence(19);
		hero.setVitality(6);
		//
		//attack/defence
		hero.setAttackSkill(45);
		hero.setBlockSkill(8);
		hero.setAccuracy(9);
		hero.setDodge(29);
		hero.setSpellPower(11);
		hero.setSpellResist(7);
		//
		//resistances
		hero.setResistFire(0);
		hero.setResistCold(15);
		hero.setResistBleed(5);
		hero.setResistPoison(5);
		hero.setResistStun(5);
		//
		hero.setGood(false);
		hero.setGold((int)(Math.random()*5.0));
		hero.setExperienceValue(30);
		hero.setStressCap(81);
		//deck		
		
	}
	private class SpectreNormal extends CharacterClass{

		public SpectreNormal(Game game) {
			super(game);
			name="";				
			for (int i=0; i<3;i++) {			
				cards.add(game.cardBuilder.buildCard("meeleAttack"));
			}
			//aoe cold spell			
			for (int i=0; i<4;i++) {
				cards.add(game.cardBuilder.buildCard("basicAttack"));
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
