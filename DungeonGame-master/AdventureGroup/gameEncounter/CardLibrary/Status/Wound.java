package gameEncounter.CardLibrary.Status;

import java.util.LinkedList;

import gameEncounter.Hero;
import gameEncounter.CardLibrary.SpellnoTarget;

public class Wound extends SpellnoTarget{
	public Wound() {
		// TODO Auto-generated constructor stub
		manaCost =0;
		legalCastPositions[0]=false;
		legalCastPositions[1]=false;
		legalCastPositions[2]=false;
		legalCastPositions[3]=false;
		legalCastPositions[4]=false;
	}
	public boolean applyEffect(Hero self) {
		return true;
	}
	@Override
	public String getName() {
		return "wound";
	}
	@Override
	public LinkedList<String> getCardText(Hero hero) {
		LinkedList<String> textList= super.getCardText(hero);
		textList.add(" wound");
		return textList;
	}
	@Override
	public boolean isFriendly() {
		// TODO Auto-generated method stub
		return false;
	}
}
