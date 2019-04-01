package tools;

import java.util.LinkedList;

import java.awt.event.MouseEvent;
import java.io.Serializable;

public class RectangleClicker implements Serializable{
	public LinkedList<ClickableRectangle> rectAngles;
	public RectangleClicker() {
		// TODO Auto-generated constructor stub
		rectAngles= new LinkedList<ClickableRectangle>();
	}
	public void addRect(ClickableRectangle rect) {
		rectAngles.add(rect);
	}
	public void triggerClick(MouseEvent e) {
		int x= e.getX(); int y= e.getY();
		for(int i=0; i<rectAngles.size();i++) {
			if(rectAngles.get(i).isClicked(x, y)){
				rectAngles.get(i).onClick(e);
			}
		}				
	}
	public void updateCaptions() {
		for(int i=0; i<rectAngles.size();i++) {
			rectAngles.get(i).updateCaption();
		}
	}
	//getters and setters
	public LinkedList<ClickableRectangle> getRectAngles() {
		return rectAngles;
	}
	public void setRectAngles(LinkedList<ClickableRectangle> rectAngles) {
		this.rectAngles = rectAngles;
	}
	
}
