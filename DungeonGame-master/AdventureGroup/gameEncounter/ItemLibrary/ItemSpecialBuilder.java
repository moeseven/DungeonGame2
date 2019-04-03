package gameEncounter.ItemLibrary;

import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Properties;

import game.Game;
import gameEncounter.Equipment;
import gameEncounter.Hero;
import gameEncounter.Item;
import gameEncounter.Item_new;
import gameEncounter.ModableHeroStats;

public class ItemSpecialBuilder extends ItemBuilder{
	public ItemSpecialBuilder(Game game, String fileName) {
		super(game,fileName);
	}	
	public Item buildItem(String name,double power) {
		//category = 10 (relic)
		Item_new item=new Item_new(power,map.get(name+".weight"), map.get(name+".goldValue"),"relic", map.get(name+".droppable"),null, null,null,null, null, null, null, null, null, null, null,null,null, null,null, null, null, null, null, null, null, null
				,null, null, null, null, null, null, null,map.get(name+".itemClass"),map.get(name+".imageNumber"),null,null,name);					
		return item;
	}
	
}
