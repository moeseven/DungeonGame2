package GUI;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GridLayout;

import javax.swing.JComponent;
import javax.swing.JPanel;

public class RoomHeroesComponent extends JComponent{
	private RoomWindow rw;
	private JPanel jp1;
	private JPanel jp2;
	public RoomHeroesComponent(RoomWindow rw) {
		this.rw=rw;
		setLayout(new BorderLayout());
		jp1=new JPanel();
		jp2=new JPanel();
		jp1.setLayout(new FlowLayout());
		for (int i=rw.getGame().getPlayer().getHeroes().size()-1;i>=0;i--) {
			jp1.add(new HeroRoomComponent(rw,rw.getGame().getPlayer().getHeroes().get(i)));
		}
		jp2.setLayout(new BorderLayout());
		jp2.add(new LogComponent(rw.getGame().log));
		add(jp1,BorderLayout.CENTER);
		add(jp2,BorderLayout.SOUTH);
		this.setVisible(true);
	}
	protected void paintComponent(Graphics g){
		super.paintComponent(g);
	}
}
