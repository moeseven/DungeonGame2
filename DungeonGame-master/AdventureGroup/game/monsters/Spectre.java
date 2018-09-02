package game.monsters;

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
import gameEncounter.CardLibrary.FireFist;
import gameEncounter.CardLibrary.FrostArrow;
import gameEncounter.CardLibrary.HeadShot;
import gameEncounter.CardLibrary.MeeleAttack;
import gameEncounter.CardLibrary.RangedAttack;
import gameEncounter.CardLibrary.Spell;
import gameEncounter.CardLibrary.PoisonShot;
import gameEncounter.ItemLibrary.GoblinBow;
import gameEncounter.ItemLibrary.ItemHand1;
import gameEncounter.ItemLibrary.RustyBlade;
import gameEncounter.CardLibrary.AttackCard;
import gameEncounter.CardLibrary.Bash;
import gameEncounter.CardLibrary.BasicAttack;
import gameEncounter.CardLibrary.Blaze;
import gameEncounter.CardLibrary.BleedingSlice;

public class Spectre extends MonsterRace{

	public Spectre() {
		name="spectre";
		//set Position classes
		position1Classes.add(new SpectreNormal());
		position2Classes.add(new SpectreNormal());
		position3Classes.add(new SpectreNormal());
		position4Classes.add(new SpectreNormal());
		position5Classes.add(new SpectreNormal());
	}

	public void modifyHero(Hero hero) {
		super.modifyHero(hero);
		hero.setImage(hero.getPlayer().getGame().imageLoader.getImage(51));
		hero.setSpeed(8);
		hero.setBaseHp(62);		
		//stats
		hero.setStrength(7);
		hero.setDexterity(8);
		hero.setIntelligence(19);
		hero.setVitality(6);
		//
		//attack/defence
		hero.setAttackSkill(8);
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

		public SpectreNormal() {			
			name="";
			items.add(new SpectreClaw());				
			for (int i=0; i<3;i++) {			
				cards.add(new MeeleAttack());
			}
			cards.add(new Breeze());
			cards.add(new Breeze());
			cards.add(new RangedAttack());
			cards.add(new BasicAttack());
			for (int i=0; i<4;i++) {
				cards.add(new Block());
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
	private class SpectreClaw extends ItemHand1{
		public SpectreClaw(){
			super();
			droppable=false;
			name="spectre claw";
			setGoldValue(1);
			this.baseDamage=17;
			this.damageRange=14;
			this.facStr=0.6;
			this.weaponRange=2;
		}
		

	}
	private class Breeze extends Spell{
		public Breeze() {
			// TODO Auto-generated constructor stub
			manaCost =1;
		}
		public boolean applyEffect(Hero self) {
				if(self.castSpellOnHero(self.getTarget())) {	
					self.getTarget().takeColdDamage(self, (int) (self.computeSpellPower()/2.3));
					return true;
				}else {
					return false;
				}
		}
		@Override
		public String getName() {
			return "breeze";
		}
		@Override
		public String getCardText(Hero hero) {
			//TODO correct number display
			return super.getCardText(hero)+"cold damage";
		}
		@Override
		public int rangeOfCard(Hero hero) {
			// TODO Auto-generated method stub
			return 10;
		}
		@Override
		public boolean isFriendly() {
			// TODO Auto-generated method stub
			return false;
		}
	}

}
