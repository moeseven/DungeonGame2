package tools;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class UsefulFunctions1 {

	public static ArrayList<String> getAllKeysFromMapWithValue(HashMap<String,String> map,String value){
		ArrayList<String> keyList = new ArrayList<String>();
		if(map.containsValue(value)){	
			// Create an Empty List
			keyList = new ArrayList<String>();					
			// Iterate over each entry of map using entrySet
			for (Map.Entry<String,String> entry : map.entrySet()){ 			
				// Check if value matches with given value
				if (entry.getValue().equals(value))
				{
					// Store the key from entry to the list
					keyList.add(entry.getKey());
				}
			}
		}
		return keyList;
	}
	
	public static HashMap<String,String> getMapWithAllKeysTruncatedFromMapWithValue(HashMap<String,String> map,String value){
		//this is very specific
		HashMap<String,String> keyMap = new HashMap<String,String>();
		if(map.containsValue(value)){	
			// Create an Empty map
			keyMap = new HashMap<String,String>();					
			// Iterate over each entry of map using entrySet
			for (Map.Entry<String,String> entry : map.entrySet()){ 			
				// Check if value matches with given value
				if (entry.getValue().equals(value))
				{
					//truncate key
					String keyString = entry.getKey();
					// Store the key from entry to the 
					keyMap.put(keyString,"");
					//System.out.println(keyString.split(".")[0]);
					System.out.println(keyString);
				}
			}
		}
		return keyMap;
	}
}
