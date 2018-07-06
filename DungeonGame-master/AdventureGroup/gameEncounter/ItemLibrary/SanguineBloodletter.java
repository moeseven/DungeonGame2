package gameEncounter.ItemLibrary;

import gameEncounter.Card;
import gameEncounter.Equipment;
import gameEncounter.Hero;
import gameEncounter.Item;
import gameEncounter.ModableHeroStats;
import gameEncounter.CardLibrary.AttackCard;
import gameEncounter.CardLibrary.DaggerThrow;

public class SanguineBloodletter extends ItemHand2{
private Card extraCard;
	public SanguineBloodletter() {
		super();
		name="sanguine bloodletter";
		setGoldValue(440);
		extraCard= new SanguineStrike();
	}

	@Override
	public void generateItemDescription() {
		// TODO Auto-generated method stub
		super.generateItemDescription();
		description.add("adds -sanguine strike- to the deck");
	}

	@Override
	public void mod(Hero hero) {
		// TODO Auto-generated method stub
		super.mod(hero);
		hero.getDeck().addCard(extraCard);
	}

	@Override
	public void demod(Hero hero) {
		// TODO Auto-generated method stub
		super.demod(hero);
		hero.getDeck().getCards().remove(extraCard);
	}
	private class SanguineStrike extends AttackCard{
		public SanguineStrike() {
			// TODO Auto-generated constructor stub
			manaCost =1;
			damageMult=1.8;
			legalPositions[2]=false;
			legalPositions[3]=false;
			legalPositions[4]=false;
		}
		public boolean applyEffect(Hero self) {
				if(self.attackHero(self.getTarget())) {
					damageTarget(self);
					self.getDiscardPile().remove(this);
					if(self.getTarget().isDead()) {
						self.setVitality(self.getVitality()+1);
						self.getPlayer().getGame().log.addLine("sanguine strike kill: +1 vitality");
					}
					return true;
				}else {
					return false;
				}
				
		}
		@Override
		public String getName() {
			return "sanguine strike";
		}
		@Override
		public String getCardText() {
			//TODO correct number display
			return super.getCardText()+" bonus to vitality on kill";
		}
	}
}
