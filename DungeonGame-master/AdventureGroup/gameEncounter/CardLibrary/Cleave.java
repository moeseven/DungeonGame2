package gameEncounter.CardLibrary;

import gameEncounter.Card;
import gameEncounter.Hero;

public class Cleave extends Card{
	public Cleave() {
		// TODO Auto-generated constructor stub
		manaCost =2;
		legalPositions[1]=false;
		legalPositions[2]=false;
		legalPositions[3]=false;
		legalPositions[4]=false;
	}
	public boolean applyEffect(Hero self) {
		if(self.getFight().getHeroes().contains(self)) {
			for(int i=0; i<self.getFight().getMonsters().size();i++) {
				if(self.getFight().getMonsters().get(i).isDead()==false) {
					if(self.attackHero(self.getFight().getMonsters().get(i))) {
						self.dealWeaponDamage(self.getFight().getMonsters().get(i), self.getEquipment().getHand1(),1);
						return true;
					}
				}	
			}
		}else {
			for(int i=0; i<self.getFight().getHeroes().size();i++) {
				if(self.getFight().getHeroes().get(i).isDead()==false) {
					if(self.attackHero(self.getFight().getHeroes().get(i))) {
						self.dealWeaponDamage(self.getFight().getHeroes().get(i), self.getEquipment().getHand1(),1);
						return true;
					}
				}	
			}
		}
		return false;
	}
	@Override
	public String getName() {
		return "cleave";
	}
	@Override
	public String getCardText() {
		return "100% damage to all enemies";
	}
	@Override
	public int rangeOfCard(Hero hero) {
		// TODO Auto-generated method stub
		return 8;
	}
	@Override
	public boolean isFriendly() {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public void buildLogEntry(Hero self) {
		// TODO Auto-generated method stub
		self.getPlayer().getGame().log.addLine(getName());
	}

}
