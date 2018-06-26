package gameEncounter.CardLibrary;

import gameEncounter.Card;
import gameEncounter.Hero;
import gameEncounter.Weapon;

public class FireBall extends Spell{
	public FireBall() {
		// TODO Auto-generated constructor stub
		manaCost =1;
		legalPositions[0]=false;
	}
	public boolean applyEffect(Hero self) {
		int mana=self.getMana();
		self.setMana(0);
			if(self.castSpellOnHero(self.getTarget())) {	
				self.getTarget().takeFireDamage(self, (int)((Math.pow(mana+1, 1.4))*self.getSpellPower()/2.5));
				
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
	public String getCardText() {
		//TODO correct number display
		return super.getCardText()+"consumes all mana and does fire damage";
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
