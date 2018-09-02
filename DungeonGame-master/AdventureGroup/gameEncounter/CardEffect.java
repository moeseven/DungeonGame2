package gameEncounter;

public abstract class CardEffect {
	public abstract boolean applyEffect(Hero self, Card_new card);
	public abstract String generateCardText(Hero self, Card_new card);
}
