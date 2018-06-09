package gameEncounter;

public abstract class Card {
	protected int manaCost;
	private String type;
	protected String name;
	public Card() {
		// TODO Auto-generated constructor stub
	}
	public boolean playCard(Hero self){
		if(self.getMana()>=manaCost&&self.getHand().contains(this)) {
			self.setMana(self.getMana()-manaCost);
			this.applyEffect(self);
			self.getHand().remove(this);
			self.getDrawPile().add(this);
			return true;
		}else {
			return false;
		}
	}
	public abstract void applyEffect(Hero self);// here happens the magic
	public abstract String getName();
	public abstract String getCardText(Hero self);
	//getters and setters
	public int getManaCost() {
		return manaCost;
	}
	public void setManaCost(int manaCost) {
		this.manaCost = manaCost;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
