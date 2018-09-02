package gameEncounter.CardLibrary;

import gameEncounter.Card;
import gameEncounter.Hero;
import gameEncounter.Weapon;

public class Firewave extends Spell{
	public Firewave() {
		// TODO Auto-generated constructor stub
		manaCost =2;
	}
	public boolean applyEffect(Hero self) {
			if(self.castSpellOnHero(self.getTarget())) {	
				for(int i=0; i<self.getTarget().getPlayer().getHeroes().size();i++) {
					self.getTarget().getPlayer().getHeroes().get(i).takeFireDamage(self, self.computeSpellPower()+5);
				}
				return true;
			}else {
				return false;
			}
	}
	@Override
	public String getName() {
		return "fire wave";
	}
	@Override
	public String getCardText(Hero hero) {
		//TODO correct number display
		return super.getCardText(hero)+"fire damage to all enemies";
	}

	@Override
	public boolean isFriendly() {
		// TODO Auto-generated method stub
		return false;
	}
}
