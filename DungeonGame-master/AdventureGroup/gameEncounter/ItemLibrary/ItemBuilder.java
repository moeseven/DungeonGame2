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

public class ItemBuilder extends Item{
	HashMap<String,String> map;
	Game game;
	double suffixProbability;
	int maxSuffixes;
	public ItemBuilder(Game game) {
		super();
		this.game=game;
		suffixProbability=0.2;
		maxSuffixes=3;
		//put all card data into hashmap
		map = new HashMap<String,String>();
		Properties prop = new Properties();
		InputStream input = null;
		try {
			String filename = "resources/items.properties";
			input = getClass().getClassLoader().getResourceAsStream(filename);
			if (input == null) {
				System.out.println("Sorry, unable to find " + filename);
				return;
			}
			prop.load(input);
			Enumeration<?> e = prop.propertyNames();
			while (e.hasMoreElements()) {
				String key = (String) e.nextElement();
				String value = prop.getProperty(key);
				map.put(key, value);
				//System.out.println("Key : " + key + ", Value : " + value);
			}

		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}	
	public Item buildItem(String name,double power) {
		Item_new item=new Item_new(power,map.get(name+".weight"), map.get(name+".goldValue"), map.get(name+".category"), map.get(name+".droppable"), map.get(name+".critChance"), map.get(name+".critDamage"), map.get(name+".attack"), map.get(name+".block"), map.get(name+".spell"), map.get(name+".accuracy"), map.get(name+".dodge"), map.get(name+".speed"), map.get(name+".draw"), map.get(name+".mana"), map.get(name+".thorns"),map.get(name+".armor"), map.get(name+".health"), map.get(name+".resistSpell"),map.get(name+".resistLightning"), map.get(name+".resistFire"), map.get(name+".resistCold"), map.get(name+".resistPoison"), map.get(name+".resistBleed"), map.get(name+".resistStun"), map.get(name+".resistStress"), map.get(name+".duration")
				, map.get(name+".fireDmg"), map.get(name+".coldDmg"), map.get(name+".lightningDmg"), map.get(name+".bleedDmg")	, map.get(name+".poisonDmg"), map.get(name+".magicDmg"), map.get(name+".stunChance"),map.get(name+".itemClass"),map.get(name+".imageNumber"),name);
		if (item.getCategory()==6) {
			item.addSuffix(game.itemSuffixBuilder.buildRandomSuffix(2));
		}
		for (int i = 0; i < maxSuffixes; i++) {
			if (Math.random()<suffixProbability) {
				item.addSuffix(game.itemSuffixBuilder.buildRandomSuffix(3));
			}
		}
		
		return item;
	}
	public HashMap<String, String> getMap() {
		return map;
	}
	public void setMap(HashMap<String, String> map) {
		this.map = map;
	}
	
}
