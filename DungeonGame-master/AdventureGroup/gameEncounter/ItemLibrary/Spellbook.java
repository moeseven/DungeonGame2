package gameEncounter.ItemLibrary;

import gameEncounter.Card;
import gameEncounter.Equipment;
import gameEncounter.Hero;
import gameEncounter.Item;
import gameEncounter.ModableHeroStats;
import gameEncounter.CardLibrary.DaggerThrow;
import gameEncounter.CardLibrary.Magicmissile;

public class Spellbook extends ItemHand2{
private Card extraCard;
	public Spellbook() {
		super();
		name="spell book";
		setGoldValue(170);
		extraCard= new Magicmissile();
		stats.getStats()[ModableHeroStats.nameResolveStat("draw")]=1;
		stats.getStats()[ModableHeroStats.nameResolveStat("spell")]=3;
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
