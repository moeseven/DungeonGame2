package gameEncounter;

import java.io.Serializable;

public abstract class CardEffect implements Serializable{
	public abstract boolean applyEffect(Hero self, Card_new card);
	public abstract String generateCardText(Hero self, Card_new card);
}
