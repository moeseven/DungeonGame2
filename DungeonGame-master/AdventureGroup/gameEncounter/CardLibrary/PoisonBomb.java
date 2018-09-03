package gameEncounter.CardLibrary;

import gameEncounter.Buff;
import gameEncounter.Card;
import gameEncounter.Hero;
import gameEncounter.Weapon;

public class PoisonBomb extends Spell{
	public PoisonBomb() {
		// TODO Auto-generated constructor stub
		manaCost =2;
		legalCastPositions[0]=false;
	}
	public boolean applyEffect(Hero self) {
		if(self.getFight().getHeroes().contains(self)) {
			for(int i=0; i<self.getFight().getMonsters().size();i++) {
				if(self.getFight().getMonsters().get(i).isDead()==false) {
					if(self.attackHero(self.getFight().getMonsters().get(i),this)) {
						self.getTarget().poison(2);
						return true;
					}
				}	
			}
		}else {
			for(int i=0; i<self.getFight().getHeroes().size();i++) {
				if(self.getFight().getHeroes().get(i).isDead()==false) {
					if(self.attackHero(self.getFight().getHeroes().get(i),this)) {
						self.getTarget().poison(2);
						return true;
					}
				}	
			}
		}
		return false;
	}
	@Override
	public String getName() {
		return "poison bomb";
	}
	@Override
	public String getCardText(Hero hero) {
		//TODO correct number display
		return super.getCardText(hero)+"poison all enemies";
	}

	@Override
	public boolean isFriendly() {
		// TODO Auto-generated method stub
		return false;
	}
}
