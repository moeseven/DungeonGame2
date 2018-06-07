package tools;

import java.util.LinkedList;

public class RectangleClicker {
	public LinkedList<ClickableRectangle> rectAngles;
	public RectangleClicker() {
		// TODO Auto-generated constructor stub
		rectAngles= new LinkedList<ClickableRectangle>();
	}
	public void addRect(ClickableRectangle rect) {
		rectAngles.add(rect);
	}
	public void triggerClick(int x, int y) {		
		for(int i=0; i<rectAngles.size();i++) {
			if(rectAngles.get(i).isClicked(x, y)){
				rectAngles.get(i).onClick();
			}
		}				
	}
	public void updateCaptions() {
		for(int i=0; i<rectAngles.size();i++) {
			rectAngles.get(i).updateCaption();
		}
	}
}
