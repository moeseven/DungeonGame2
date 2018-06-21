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
		for (int i=rw.getGame().getPlayer().getHeroes().size()-1;i>=0;i--) {
			add(new HeroRoomComponent(rw,rw.getGame().getPlayer().getHeroes().get(i)));
		}
		this.setVisible(true);
	}
	protected void paintComponent(Graphics g){
		super.paintComponent(g);
	}
}
