package game;

import java.util.LinkedList;

public class Quest {
private String description;
private LinkedList<Room> rooms;
	public Quest() {
		
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public LinkedList<Room> getRooms() {
		return rooms;
	}
	public void setRooms(LinkedList<Room> rooms) {
		this.rooms = rooms;
	}
	
}
