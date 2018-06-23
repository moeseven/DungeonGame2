package gameEncounter;

public abstract class Buff {
private int duration;
public abstract void mod(Hero hero);
public abstract void demod(Hero hero);
public void tick(Hero hero) {
	duration+=-1;
	if(duration<=0) {
		removeBuff(hero);
	}
}
public void removeBuff(Hero hero) {
	demod(hero);
	hero.getBuffs().remove(this);
}
}
