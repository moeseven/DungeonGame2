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
		hero.setSpellPower(21);
		hero.setSpellResist(7);
		//
		//resistances
		hero.setResistFire(12);
		hero.setResistCold(24);
		hero.setResistBleed(15);
		hero.setResistPoison(15);
		hero.setResistStun(25);
		//
		hero.setArmor(4);
		hero.setSpellDuration(hero.getSpellDuration()+4);
		hero.setGood(false);
		hero.setGold((int)(Math.random()*15.0));
		hero.setExperienceValue(65);
		hero.setStressCap(100);
		//deck		
		
	}
	private class SpectreNormal extends CharacterClass{

		public SpectreNormal(Game game) {
			super(game);
			name="";				
			cards.add(game.cardBuilder.buildCard("meeleAttack"));
			//aoe cold spell			
			for (int i=0; i<3;i++) {
				cards.add(game.cardBuilder.buildCard("basicAttack"));
				cards.add(game.cardBuilder.buildCard("basicBlock"));
			}
			cards.add(game.cardBuilder.buildCard("breeze"));
			cards.add(game.cardBuilder.buildCard("breeze"));
			cards.add(game.cardBuilder.buildCard("glacierNeedle"));
			cards.add(game.cardBuilder.buildCard("glacierNeedle"));
		}

		public void modifyHero(Hero hero) {
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
