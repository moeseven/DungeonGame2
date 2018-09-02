package gameEncounter.CardLibrary;

import gameEncounter.Buff;
import gameEncounter.Hero;

public class IntimidatingCry extends SpellnoTarget{
	public IntimidatingCry() {
		// TODO Auto-generated constructor stub
		manaCost =1;
		
	}
	public boolean applyEffect(Hero self) {
		for(int i=0;i<self.getTarget().getPlayer().getHeroes().size();i++) {
			self.getTarget().getPlayer().getHeroes().get(i).becomeStressed(10);
			self.getTarget().getPlayer().getHeroes().get(i).buffHero(new Intimidated(self.getTarget().getPlayer().getHeroes().get(i)));
		}
		self.block((int) (self.computeBlockSkill()*0.6));
		return true;
	}
	@Override
	public String getName() {
		return "intimidating cry";
	}
	@Override
	public String getCardText(Hero hero) {
		return super.getCardText(hero)+"stresses enemies and reduces their strength";
	}

	@Override
	public boolean isFriendly() {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public void buildLogEntry(Hero self) {
		self.getPlayer().getGame().log.addLine(getName());
		
	}
	private class Intimidated extends Buff{
		private int modifier=0;
		public Intimidated(Hero hero) {
			modifier=(int) (hero.getStrength()/2.0);
			duration=2;
		}
		@Override
		public void onTick(Hero hero) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mod(Hero hero) {
			// TODO Auto-generated method stub
			hero.setStrength(hero.getStrength()-modifier);
		}

		@Override
		public void demod(Hero hero) {
			// TODO Auto-generated method stub
			hero.setStrength(hero.getStrength()+modifier);
		}
		
	}

}
