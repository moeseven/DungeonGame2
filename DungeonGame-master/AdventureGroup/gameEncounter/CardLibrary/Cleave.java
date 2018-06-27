package gameEncounter.CardLibrary;

import gameEncounter.Card;
import gameEncounter.Hero;

public class Cleave extends AttackCard{
	public Cleave() {
		// TODO Auto-generated constructor stub
		manaCost =2;
		damageMult=1.8;
		legalPositions[1]=false;
		legalPositions[2]=false;
		legalPositions[3]=false;
		legalPositions[4]=false;
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
	public String getCardText() {
		return super.getCardText()+"(hits the target behind as well)";
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
