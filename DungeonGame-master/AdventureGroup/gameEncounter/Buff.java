package gameEncounter;

public abstract class Buff {
protected int duration=2;
public abstract void onTick(Hero hero);
public abstract void mod(Hero hero);
public abstract void demod(Hero hero);
public void tick(Hero hero) {	
	duration+=-1;
	if(duration<=0) {
		removeBuff(hero);
	}else {
		onTick(hero);
	}	
}
public void removeBuff(Hero hero) {
	demod(hero);
	hero.getBuffs().remove(this);
}
}
