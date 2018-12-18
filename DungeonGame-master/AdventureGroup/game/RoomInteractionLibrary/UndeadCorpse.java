package game.RoomInteractionLibrary;

import java.util.LinkedList;

import game.Game;
import game.MonsterRace;
import game.Room;
import game.RoomInteraction;
import game.monsters.RaceRat;
import game.monsters.RaceZombie;
import gameEncounter.Hero;
import gameEncounter.Item;

public class UndeadCorpse extends RoomInteraction{
	private boolean hasBeenLooted;
	private LinkedList<Item> items;
	private int awakeChance;
	private int value;
	
	public UndeadCorpse(Game game,int awakeChance,int value) {
		super(game);
		this.awakeChance=awakeChance;
		this.value=value;
		setImageNumber(240);
		hasBeenLooted=false;
		items= new LinkedList<Item>();		
		name="corpse";
	}

	@Override
	public void onEnter(Game game) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onInteraction(Hero hero) {
		//loot corpse
		if(!hero.isDead()) {
			if(!hasBeenLooted) {
				if (Math.random()<awakeChance/100.0) {
					LinkedList<UndeadCorpse> razeUd= new LinkedList<UndeadCorpse>();
					for (int i = 0; i < game.getRoom().getInteractions().size(); i++) {
						if (game.getRoom().getInteractions().get(i) instanceof UndeadCorpse) {
							razeUd.add((UndeadCorpse) game.getRoom().getInteractions().get(i));
						}						
					}
					razeUndead(razeUd.size());
					for (int i = 0; i < razeUd.size(); i++) {
						game.getRoom().getInteractions().remove(razeUd.get(i));
					}
				}else {
					setImageNumber(241);
					hero.getPlayer().gainGold(value);
				}
		
		}else {
			hero.getPlayer().getGame().log.addLine("allready looted!");
		}
		if(items.size()==0) {
			hasBeenLooted=true;
		}
		}
				
	}
	private void razeUndead(int amount) {
		for (int i=0; i<game.getPlayer().getHeroes().size();i++) {
			game.getPlayer().getHeroes().get(i).looseMoral((int) (Math.random()*12));
		}	
		MonsterRace monsterRace= new RaceZombie(game);
		for(int i=0; i<Math.min(game.dungeonMaster.getGroupSize(),amount);i++) {
			game.getRoom().addMonster(new Hero("", game.dungeonMaster,monsterRace, monsterRace.getPositionClasses(1).get(0)));
		}
		game.getRoom().setHasFight(true);		
		game.getRoom().getInteractions().remove(this);
		game.log.addLine("the dead raze again!");
		game.enterRoom(game.getRoom());
				
	}
	
}
