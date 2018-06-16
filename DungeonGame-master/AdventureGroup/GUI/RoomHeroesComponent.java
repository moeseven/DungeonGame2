package GUI;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GridLayout;

import javax.swing.JComponent;

public class RoomHeroesComponent extends JComponent{
	private RoomWindow rw;
	public RoomHeroesComponent(RoomWindow rw) {
		this.rw=rw;
		this.setLayout(new FlowLayout());
		for (int i=0;i<rw.getGame().getHeroes().size();i++) {
			add(new HeroRoomComponent(rw,rw.getGame().getHeroes().get(i)));
		}
		this.setVisible(true);
	}
	protected void paintComponent(Graphics g){
		super.paintComponent(g);
	}
}
