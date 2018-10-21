package gameEncounter.EffectLibrary;

import java.util.LinkedList;

import game.MonsterRace;
import game.monsters.RaceZombie;
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
	public boolean applyEffect(Hero self, Card_new card) {
		//check if there is space to summon
		if(self.getPlayer().getGroupSize()-self.getPlayer().getHeroes().size()>0) {
			//resolve monster type
			if (pars.get(1).equals("zombie")) {
				MonsterRace monsterRace= new RaceZombie(self.getPlayer().getGame());
				Hero monster=new Hero("", self.getPlayer(), monsterRace, monsterRace.getPositionClasses(1).getFirst());
				monster.buffHero(new summonBuff(monster, 1+self.getSpellDuration()));
				self.getPlayer().getGame().getRoom().getFight().addHeroToFight(monster);
				return true;
			}else {
				self.getPlayer().getGame().log.addLine("failed summon (no such thing)");
				return false;
			}
			
		}else {
			self.getPlayer().getGame().log.addLine("failed summon (too many units)");
			self.setMana(self.getMana()+card.getManaCost());
			return false;
		}		
	}

	@Override
	public String generateCardText(Hero self, Card_new card) {
		return "summons a "+pars.get(1)+".";
	}

}
