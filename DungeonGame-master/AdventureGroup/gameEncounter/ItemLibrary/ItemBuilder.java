package gameEncounter.ItemLibrary;

import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Properties;

import gameEncounter.Equipment;
import gameEncounter.Hero;
import gameEncounter.Item;
import gameEncounter.Item_new;
import gameEncounter.ModableHeroStats;

public class ItemBuilder extends Item{
	HashMap<String,String> map;
	public ItemBuilder() {
		super();
		//put all card data into hashmap
		map = new HashMap<String,String>();
		Properties prop = new Properties();
		InputStream input = null;
		try {
			String filename = "res/items.properties";
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
	public Item buildItem(String name) {
		return new Item_new(map.get(name+".weight"), map.get(name+".goldValue"), map.get(name+".category"), map.get(name+".droppable"), map.get(name+".critChance"), map.get(name+".attack"), map.get(name+".block"), map.get(name+".spell"), map.get(name+".accuracy"), map.get(name+".dodge"), map.get(name+".speed"), map.get(name+".draw"), map.get(name+".mana"), map.get(name+".thorns"),map.get(name+".armor"), map.get(name+".health"), map.get(name+".resistSpell"), map.get(name+".resistFire"), map.get(name+".resistCold"), map.get(name+".resistPoison"), map.get(name+".resistBleed"), map.get(name+".resistStun"), map.get(name+".resistStress"),name);
	}
	public HashMap<String, String> getMap() {
		return map;
	}
	public void setMap(HashMap<String, String> map) {
		this.map = map;
	}
	
}
