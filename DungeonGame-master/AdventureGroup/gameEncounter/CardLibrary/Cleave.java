package gameEncounter.CardLibrary;

import gameEncounter.Card;
import gameEncounter.Hero;

public class Cleave extends Card{
	public Cleave() {
		// TODO Auto-generated constructor stub
		manaCost =2;
		
	}
	public void applyEffect(Hero self) {
		if(self.isGood()) {
			for(int i=0; i<self.getFight().getMonsters().size();i++) {
				if(self.getFight().getMonsters().get(i).isDead()==false) {
					self.dealDamage(self.getFight().getMonsters().get(i), self.getAttackSkill()+5);
				}	
			}
		}else {
			for(int i=0; i<self.getFight().getHeroes().size();i++) {
				if(self.getFight().getHeroes().get(i).isDead()==false) {
					self.dealDamage(self.getFight().getHeroes().get(i), self.getAttackSkill()+5);
				}	
			}
		}				
	}
	@Override
	public String getName() {
		return "cleave";
	}
	@Override
	public String getCardText(Hero self) {
		return "deal "+ (self.getAttackSkill()+5)+" attack damage to all enemies";
	}

}
