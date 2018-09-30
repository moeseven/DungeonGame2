package gameEncounter.CardLibrary;

import gameEncounter.Hero;

public class requiresBow extends CastCondition{
	
	
	public requiresBow() {
		super();
		this.explanation="requieres a bow";
	}

	@Override
	public boolean checkCondition(Hero hero) {
		if (hero.getEquipment().getHand1().getItemClass().equals("bow")) {
			return true;
		}
		return false;
	}

}
