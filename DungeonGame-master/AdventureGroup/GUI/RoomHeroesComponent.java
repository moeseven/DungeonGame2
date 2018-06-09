package GUI;

import java.awt.Graphics;

import javax.swing.JComponent;

public class RoomHeroesComponent extends JComponent{
	private RoomWindow rw;
	public RoomHeroesComponent(RoomWindow rw) {
		this.rw=rw;
		
	}
	protected void paintComponent(Graphics g){
		super.paintComponent(g);
	}
}
