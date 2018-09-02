package gameEncounter.CardLibrary;

import gameEncounter.Card;
import gameEncounter.Hero;

public class Cleave extends AttackCard{
	public Cleave() {
		// TODO Auto-generated constructor stub
		manaCost =2;
		damageMult=1.9;
		legalCastPositions[1]=false;
		legalCastPositions[2]=false;
		legalCastPositions[3]=false;
		legalCastPositions[4]=false;
	}
	public boolean applyEffect(Hero self) {
		boolean success=false;
		if(self.attackHero(self.getTarget())) {
			damageTarget(self);
			success=true;
		}
		if(self.getTarget().getPlayer().getHeroes().size()>self.getTarget().getPlayer().getHeroes().indexOf(self.getTarget())+1) {
			Hero secondTarget=self.getTarget().getPlayer().getHeroes().get(self.getTarget().getPlayer().getHeroes().indexOf(self.getTarget())+1);
			self.setTarget(secondTarget);
			if(self.attackHero(self.getTarget())) {				
				damageTarget(self);
				success=true;
			}
		}
		return success;
	}
	@Override
	public String getName() {
		return "cleave";
	}
	@Override
	public String getCardText(Hero hero) {
		return super.getCardText(hero)+"(hits the target behind as well)";
	}
	@Override
	public int rangeOfCard(Hero hero) {
		// TODO Auto-generated method stub
		return 1;
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
