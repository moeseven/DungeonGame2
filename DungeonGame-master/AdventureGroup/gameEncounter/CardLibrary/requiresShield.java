package gameEncounter.CardLibrary;

import gameEncounter.Hero;

public class requiresShield extends CastCondition{
	
	
	public requiresShield() {
		super();
		this.explanation="requieres a shield";
	}

	@Override
	public boolean checkCondition(Hero hero) {
		if (hero.getEquipment().getHand2()!=null) {
			if (hero.getEquipment().getHand2().getItemClass().equals("shield")) {
				return true;
			}
		}	
		return false;
	}

}
