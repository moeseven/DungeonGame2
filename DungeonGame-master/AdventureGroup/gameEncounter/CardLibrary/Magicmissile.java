package gameEncounter.CardLibrary;

import gameEncounter.Card;
import gameEncounter.Hero;
import gameEncounter.Weapon;

public class Magicmissile extends Spell{
	public Magicmissile() {
		// TODO Auto-generated constructor stub
		manaCost =1;
		legalPositions[0]=false;
	}
	public boolean applyEffect(Hero self) {
			if(self.castSpellOnHero(self.getTarget())) {	
				self.getPlayer().getGame().log.addLine("casting "+getName()+" on "+self.getTarget().getName());
				self.getTarget().takeDamage(self, (int)(1+self.getSpellPower()/1.5));
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
	public String getCardText(Hero self) {
		//TODO correct number display
		return "damaging spell";
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
