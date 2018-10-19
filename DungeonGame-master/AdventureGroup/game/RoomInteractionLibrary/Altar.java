package game.RoomInteractionLibrary;

import java.util.LinkedList;

import game.Game;
import game.RoomInteraction;
import gameEncounter.Hero;
import gameEncounter.Item;
import gameEncounter.ItemLibrary.*;
import gameEncounter.ItemLibrary.usables.ExperienceBook;
import gameEncounter.ItemLibrary.usables.HealingPotion;

public class Altar extends RoomInteraction{
	public int sacrefices=2;
	public Altar(Game game) {
		super(game);
		//image=game.imageLoader.getImage(86);
		setImageNumber(86);
		name="altar";
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onEnter(Game game) {
		// TODO Auto-generated method stub
	}

	@Override
	public void onInteraction(Hero hero) {
		// TODO Auto-generated method stub
		//setup shop here
		if(!hero.isDead()) {
			hero.getPlayer().getGame().log.addLine("visiting altar");
			hero.getPlayer().getGame().getRoom().setAltar(this);
			hero.getPlayer().getGame().getRoom().setAltarOpen(true);
		}
		
	}
	public void goldForBlood(Hero hero) {
		if(sacrefices>0) {
			int gold=(int) (hero.getHp()*Math.random());
			hero.finalDamage(gold);
			hero.getPlayer().gainGold(gold);
			sacrefices--;
		}		
	}
	public void itemForExperience(Hero hero, Item item) {
		if(sacrefices>0&&hero.getPlayer().getInventory().contains(item)) {
			hero.getPlayer().getInventory().remove(item);
			hero.gainExp((int) (item.getItemQuality()*50));
			sacrefices--;
		}
	}
	public void pray(Hero hero) {
		if (sacrefices>0) {
			hero.healStress(hero.getStress()/2);
			sacrefices--;
		}
	}
}
