package gameEncounter.ItemLibrary;

import gameEncounter.Card;
import gameEncounter.Equipment;
import gameEncounter.Hero;
import gameEncounter.Item;
import gameEncounter.ModableHeroStats;
import gameEncounter.CardLibrary.DaggerThrow;

public class Dagger extends ItemHand2{
private Card extraCard;
	public Dagger() {
		super();
		name="dagger";
		setGoldValue(110);
		extraCard= new DaggerThrow();
		stats.getStats()[ModableHeroStats.nameResolveStat("dexterity")]=1;
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
	

}
