package gameEncounter.EffectLibrary;

import java.util.LinkedList;

import game.MonsterRace;
import game.monsters.RaceWall;
import game.monsters.RaceZombie;
import gameEncounter.Card;
import gameEncounter.CardEffect;
import gameEncounter.Card_new;
import gameEncounter.GameEquations;
import gameEncounter.Hero;
import gameEncounter.buffLibrary.summonBuff;

public class summonEffect extends CardEffect{

	public summonEffect(LinkedList<String> pars) {
		super(pars);
		assert pars.size()>1;
	}

	@Override
	public boolean applyEffect(Hero self, Card card) {
		boolean returnValue=false;
		//check if there is space to summon as extra cast condition
		MonsterRace monsterRace;
		Hero monster;
		//resolve monster type
		if (pars.get(1).equals("zombie")) {
			monsterRace= new RaceZombie(self.getPlayer().getGame());
			monster=new Hero("", self.getPlayer(), monsterRace, monsterRace.getPositionClasses(1).getFirst());			
			returnValue= true;
		}else {
			if (pars.get(1).equals("iceWall")) {
				monsterRace= new RaceWall(self.getPlayer().getGame());
				monster=new Hero("", self.getPlayer(), monsterRace, monsterRace.getPositionClasses(1).getFirst());			
				returnValue= true;
			}else {
				self.getPlayer().getGame().log.addLine("failed summon (no such thing)");
				return false;
			}				
		}
		monster.buffHero(new summonBuff(monster, 1+self.getSpellDuration()));
		if (pars.size()>2) {
			monster.enhance(GameEquations.calculateSpellDamage(80, self,pars.get(2)));
		}else {
			monster.enhance(GameEquations.calculateSpellMagicDamage(80, self));
		}		
		self.getPlayer().getGame().getRoom().getFight().addSummonToFight(monster);
		return returnValue;		
	}

	@Override
	public String generateCardText(Hero self, Card card) {
		return "summons a "+pars.get(1)+"("+pars.get(2)+").";
	}

}
