package gameEncounter.CardLibrary;

import java.io.Serializable;

import gameEncounter.Card;
import gameEncounter.Card_new;
import gameEncounter.Hero;
import gameEncounter.Weapon;
import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Properties;
public class CardBuilder implements Serializable{
	private HashMap<String, String> map;
	public CardBuilder() {
		//put all card data into hashmap
		map = new HashMap<String,String>();
		Properties prop = new Properties();
		InputStream input = null;
		try {
			String filename = "res/cards.properties";
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
	public Card buildCard(String name) {
		return new Card_new(map.get(name+".manaCost"), map.get(name+".legalCastPositions"), map.get(name+".legalTargetPositions"), name, map.get(name+".accuracy"), map.get(name+".critChance"), map.get(name+".block"), map.get(name+".attackDamage"), map.get(name+".spellDamage"), map.get(name+".effect"), map.get(name+".effect2"), map.get(name+".effect3"),map.get(name+".isFriendly"), map.get(name+".text"), map.get(name+".extra"), map.get(name+".extra2"));
	}
	public HashMap<String, String> getMap() {
		return map;
	}
	public void setMap(HashMap<String, String> map) {
		this.map = map;
	}
	public void printMap() {
		System.out.println(map.toString());
	}

}
