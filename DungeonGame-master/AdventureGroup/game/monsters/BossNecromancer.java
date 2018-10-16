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
		position2Classes.add(null);
		position3Classes.add(null);
		position4Classes.add(null);
		position5Classes.add(null);
	}

	public void modifyHero(Hero hero) {
		super.modifyHero(hero);
		//hero.setImage(hero.getPlayer().getGame().imageLoader.getImage(66));
		hero.setImageNumber(66);
		hero.setSpeed(12);
		hero.setBaseHp(220);		
		//stats
		hero.setStrength(12);
		hero.setDexterity(14);
		hero.setIntelligence(34);
		hero.setVitality(12);
		//
		//attack/defence
		hero.setAttackSkill(12);
		hero.setBlockSkill(10);
		hero.setAccuracy(14);
		hero.setDodge(13);
		hero.setSpellPower(35);
		hero.setSpellResist(14);
		//
		//resistances
		hero.setResistFire(4);
		hero.setResistCold(10);
		hero.setResistBleed(10);
		hero.setResistPoison(30);
		hero.setResistStun(30);
		//
		hero.setArmor(4);
		hero.setGood(false);
		hero.setGold((int)(Math.random()*45.0));
		hero.setExperienceValue(300);
		//boss
		hero.setManaPower(3);
		hero.setDraw(5);
		//deck		
		
	}
	private class NecromancerAspirant extends CharacterClass{

		public NecromancerAspirant(Game game) {	
			super(game);
			name="";				
			for (int i=0; i<5;i++) {	
				cards.add(game.cardBuilder.buildCard("basicBlock"));
				cards.add(game.cardBuilder.buildCard("basicAttack"));
			}
			//attacks
			cards.add(game.cardBuilder.buildCard("meeleAttack"));
			//spells
			cards.add(game.cardBuilder.buildCard("growth"));
			cards.add(game.cardBuilder.buildCard("magicMissile"));
			cards.add(game.cardBuilder.buildCard("magicMissile"));
			cards.add(game.cardBuilder.buildCard("magicMissile"));
			cards.add(game.cardBuilder.buildCard("channel"));
			cards.add(new SummonZombie());
			cards.add(new SummonZombie());
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
	private class SummonZombie extends SpellnoTarget{

		public SummonZombie() {
			super();
			manaCost=3;
		}

		@Override
		public boolean extraCastConditions(Hero hero) {
			boolean isThereSpace=false;
			if(hero.getPlayer().getGroupSize()-1-hero.getPlayer().getHeroes().size()>0) {
				isThereSpace=true;
			}
			return isThereSpace;
		}

		@Override
		public boolean applyEffect(Hero self) {
			MonsterRace monster= new RaceZombie(game);
			self.getPlayer().addHero(new Hero("", self.getPlayer(), monster, monster.getPositionClasses(1).getFirst()));
			self.getPlayer().getHeroes().getFirst().setUpDrawPile();
			self.getPlayer().getGame().getRoom().getFight().precalculateMonsterTurn(self.getPlayer().getHeroes().getFirst());
			return true;
		}

		@Override
		public String getName() {
			// TODO Auto-generated method stub
			return "summon Zombie";
		}

		@Override
		public boolean isFriendly() {
			// TODO Auto-generated method stub
			return false;
		}
		
	}

}
