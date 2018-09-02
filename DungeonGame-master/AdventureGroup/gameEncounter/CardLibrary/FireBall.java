package gameEncounter.CardLibrary;

import gameEncounter.Card;
import gameEncounter.Hero;
import gameEncounter.Weapon;

public class FireBall extends Spell{
	public FireBall() {
		// TODO Auto-generated constructor stub
		manaCost =1;
		legalCastPositions[0]=false;
	}
	public boolean applyEffect(Hero self) {
		int mana=self.getMana();
		self.setMana(0);
			if(self.castSpellOnHero(self.getTarget())) {	
				self.getTarget().takeFireDamage(self, (int)((Math.pow(mana+1, 1.4))*self.computeSpellPower()/1.5));
				
				return true;
			}else {
				return false;
			}
	}
	@Override
	public String getName() {
		return "fire ball";
	}
	@Override
	public String getCardText(Hero hero) {
		//TODO correct number display
		return super.getCardText(hero)+"consumes all mana and does fire damage";
	}

	@Override
	public boolean isFriendly() {
		// TODO Auto-generated method stub
		return false;
	}
}