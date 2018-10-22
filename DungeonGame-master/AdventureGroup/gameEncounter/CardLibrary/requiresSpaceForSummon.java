package gameEncounter.CardLibrary;

import gameEncounter.Hero;

public class requiresSpaceForSummon extends CastCondition{
	
	
	public requiresSpaceForSummon() {
		super();
		this.explanation="requieres free summon slot";
	}

	@Override
	public boolean checkCondition(Hero hero) {
		//5 for now
		if(5-hero.getPlayer().getHeroes().size()>0) {
			return true;
		}else {
			return false;
		}		
	}

}
