package gameEncounter.ItemLibrary;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;
import java.util.Random;

import gameEncounter.Equipment;
import gameEncounter.Hero;
import gameEncounter.Item;
import gameEncounter.Item_new;
import gameEncounter.ModableHeroStats;
import tools.UsefulFunctions1;

public class ItemSuffixBuilder extends Item{
	HashMap<String,String> map;
	HashMap<String,String> mapJustNames;
	public ItemSuffixBuilder() {
		super();
		//put all card data into hashmap
		map = new HashMap<String,String>();
		Properties prop = new Properties();
		InputStream input = null;
		try {
			String filename = "resources/itemSuffix.properties";
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
		mapJustNames = new HashMap<String,String>();
		prop = new Properties();
		input = null;
		try {
			String filename = "resources/itemSuffix.properties";
			input = getClass().getClassLoader().getResourceAsStream(filename);
			if (input == null) {
				System.out.println("Sorry, unable to find " + filename);
				return;
			}
			prop.load(input);
			Enumeration<?> e = prop.propertyNames();
			while (e.hasMoreElements()) {
				String key = (String) e.nextElement();
				if (key.contains(".")) {
					String[] justName = key.split("\\.");
					mapJustNames.put(justName[0], "");
				}
				
				
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
	public ItemSuffix buildRandomSuffix(double power) {
		//extract itemslot specific suffixes
		Random       random    = new Random();
		List<String> keys      = new ArrayList<String>(mapJustNames.keySet());		 
		String       randomKey = keys.get( (int) Math.min(Math.random()*keys.size(), keys.size()-1) );
		return buildSuffix(randomKey, power);		
	}
	public ItemSuffix buildSuffix(String name,double power) {
		return new ItemSuffix(power,map.get(name+".weight"), map.get(name+".goldValue"), map.get(name+".category"), map.get(name+".droppable"), map.get(name+".critChance"), map.get(name+".critDamage"), map.get(name+".attack"), map.get(name+".block"), map.get(name+".spell"), map.get(name+".accuracy"), map.get(name+".dodge"), map.get(name+".speed"), map.get(name+".draw"), map.get(name+".mana"), map.get(name+".thorns"),map.get(name+".armor"), map.get(name+".health"), map.get(name+".resistSpell"),map.get(name+".resistLightning"), map.get(name+".resistFire"), map.get(name+".resistCold"), map.get(name+".resistPoison"), map.get(name+".resistBleed"), map.get(name+".resistStun"), map.get(name+".resistStress"), map.get(name+".duration")
				, map.get(name+".fireDmg"), map.get(name+".coldDmg"), map.get(name+".lightningDmg"), map.get(name+".bleedDmg")	, map.get(name+".poisonDmg"), map.get(name+".magicDmg"), map.get(name+".stunChance"),map.get(name+".itemClass"),map.get(name+".imageNumber"),map.get(name+".turnBlock"),map.get(name+".bonusExp"),name);
	}
	public HashMap<String, String> getMap() {
		return map;
	}
	public void setMap(HashMap<String, String> map) {
		this.map = map;
	}
	
}
