package gameEncounter.buffLibrary;

import gameEncounter.Buff;
import gameEncounter.Hero;

public class addCardsToHandBuff extends Buff{
	private String cardName;
	private int cardAmount;
	public addCardsToHandBuff(Hero hero, String cardName, int cardAmount) {
		this.cardName=cardName;
		this.cardAmount=cardAmount;
	}
	@Override
	public void onTick(Hero hero) {
		for (int j = 0; j < cardAmount; j++) {
			hero.getHand().add(hero.getPlayer().getGame().cardBuilder.buildCard(cardName));				
		}
		hero.getPlayer().getGame().log.addLine("added "+cardAmount+" "+cardName+" to "+hero.getName()+" hand.");
	}

	@Override
	public void mod(Hero hero) {

	}

	@Override
	public void demod(Hero hero) {
		hero.getPlayer().getGame().log.addLine("buff ended.");
	}

}
