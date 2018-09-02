package gameEncounter.CardLibrary;

import gameEncounter.Buff;
import gameEncounter.Card;
import gameEncounter.Hero;
import gameEncounter.Weapon;

public class BlindingBomb extends SpellnoTarget{
	public BlindingBomb() {
		// TODO Auto-generated constructor stub
		manaCost =2;
		legalCastPositions[0]=false;
	}
	public boolean applyEffect(Hero self) {
		if(self.getFight().getHeroes().contains(self)) {
			for(int i=0; i<self.getFight().getMonsters().size();i++) {
				if(self.getFight().getMonsters().get(i).isDead()==false) {
					if(self.attackHero(self.getFight().getMonsters().get(i))) {
						self.getTarget().buffHero(new Blinded());
						return true;
					}
				}	
			}
		}else {
			for(int i=0; i<self.getFight().getHeroes().size();i++) {
				if(self.getFight().getHeroes().get(i).isDead()==false) {
					if(self.attackHero(self.getFight().getHeroes().get(i))) {
						self.getTarget().buffHero(new Blinded());
						return true;
					}
				}	
			}
		}
		return false;
	}
	@Override
	public String getName() {
		return "blinding bomb";
	}
	@Override
	public String getCardText(Hero hero) {
		//TODO correct number display
		return super.getCardText(hero)+"blind all enemies";
	}

	@Override
	public boolean isFriendly() {
		// TODO Auto-generated method stub
		return false;
	}
	private class Blinded extends Buff{

		public Blinded() {
			super();
			duration=2;
		}

		@Override
		public void onTick(Hero hero) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mod(Hero hero) {
			// TODO Auto-generated method stub
			hero.setAccuracy(hero.getAccuracy()-10);
		}

		@Override
		public void demod(Hero hero) {
			// TODO Auto-generated method stub
			hero.setAccuracy(hero.getAccuracy()+10);
		}

	}
}
