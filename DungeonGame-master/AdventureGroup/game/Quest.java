package game;

import java.util.LinkedList;

public class Quest {
private String description;
private boolean finished;
private LinkedList<Room> rooms;
	public Quest() {
		finished=false;
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
