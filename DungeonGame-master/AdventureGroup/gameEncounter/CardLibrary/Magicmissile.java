package gameEncounter.CardLibrary;

import gameEncounter.Card;
import gameEncounter.GameEquations;
import gameEncounter.Hero;
import gameEncounter.Weapon;

public class Magicmissile extends Spell{
	public Magicmissile() {
		// TODO Auto-generated constructor stub
		manaCost =1;
		legalCastPositions[0]=false;
	}
	public boolean applyEffect(Hero self) {
			if(self.castMissileSpellOnHero(self.getTarget())) {	
				self.getTarget().takeDamage(self, (int)(1+GameEquations.spellPowerCalc(self)),false);
				return true;
			}else {
				return false;
			}
	}
	@Override
	public String getName() {
		return "magic missile";
	}
	@Override
	public String getCardText(Hero hero) {
		//TODO correct number display
		return super.getCardText(hero)+"damage scales with spellpower";
	}

	@Override
	public boolean isFriendly() {
		// TODO Auto-generated method stub
		return false;
	}
}
