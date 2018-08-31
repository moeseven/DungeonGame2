package game.RoomInteractionLibrary;

import java.util.LinkedList;

import game.Game;
import game.Quest;
import game.RoomInteraction;
import gameEncounter.Hero;


public class MedicineMan extends RoomInteraction{
	private LinkedList<Hero> heroestress=new LinkedList<Hero>();
	private LinkedList<Hero> heroeswound=new LinkedList<Hero>();
	public MedicineMan(Game game) {
		super(game);
		image=game.imageLoader.getImage(107);
		name="medicine man";

	}

	@Override
	public void onEnter(Game game) {
		// TODO Auto-generated method stub
		for(int i=0; i<heroestress.size();i++) {
			game.getPlayer().getAvailableHeroes().add(heroestress.get(i));
			heroestress.get(i).setStress(0);
		}
		heroestress=new LinkedList<Hero>();
		for(int i=0; i<heroeswound.size();i++) {
			game.getPlayer().getAvailableHeroes().add(heroeswound.get(i));
			heroeswound.get(i).setWounds(0);
		}
		heroeswound=new LinkedList<Hero>();
	}

	@Override
	public void onInteraction(Hero hero) {
		// TODO Auto-generated method stub
		if(hero!=null) {
			hero.getPlayer().getGame().log.addLine("entering medicine hut");
			hero.getPlayer().getGame().getRoom().setMedicine(this);
			hero.getPlayer().getGame().getRoom().setMedicineOpen(true);
		}
		
	}
	public LinkedList<Hero> getHeroestress() {
		return heroestress;
	}

	public void setHeroestress(LinkedList<Hero> heroestress) {
		this.heroestress = heroestress;
	}

	public LinkedList<Hero> getHeroeswound() {
		return heroeswound;
	}

	public void setHeroeswound(LinkedList<Hero> heroeswound) {
		this.heroeswound = heroeswound;
	}

}
