package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JComponent;

import GUI.grafics.StaticImageLoader;
import game.RoomInteraction;

public class RoomInteractionComponent extends JComponent{
	protected RoomWindow rw;
	public RoomInteractionComponent(RoomWindow rw) {
		this.rw=rw;
		this.setLayout(new FlowLayout());
		for (int i=0;i<rw.getGame().getRoom().getInteractions().size();i++) {
			if(!rw.getGame().getRoom().getInteractions().get(i).isHidden()){			
				add(new Ri(rw.getGame().getRoom().getInteractions().get(i)));
			}			
		}
		super.setPreferredSize(new Dimension(600,200));
		this.setVisible(true);
	}
	private class Ri extends JComponent{
		private RoomInteraction ri;
		public Ri(RoomInteraction ri) {
			this.ri=ri;
			super.setPreferredSize(new Dimension(120,150));
			MyMouseListener ml = new MyMouseListener();
			super.addMouseListener(ml);
			setLayout(new BorderLayout());
			setVisible(true);
		}

		private class MyMouseListener extends MouseAdapter{
			public void mousePressed(MouseEvent e){
				if(e.getButton()==1){
					ri.onInteraction(rw.getGame().getPlayer().getSelectedHero());
					rw.getGuiRoom().upadate();
					if(rw.getGame().getRoom().isHasFight()){
						rw.setUpFightWindow();
						rw.setVisible(false);
					}
				}else{
					if (e.getButton()==3){
						
					}
				}
				rw.revalidate();
				rw.repaint();
			} 
		}
		protected void paintComponent(Graphics g){
			super.paintComponent(g);
			//g.drawImage(image,0,0,null);
			g.drawImage(StaticImageLoader.getImage(ri.getImageNumber()).getScaledInstance(180, 153, 3),-40,0,null);		
			g.setColor(Color.black);
			g.drawString(ri.getName(), 15, 75);
			//g.drawRect(5, 5, 110, 140);
			
		}
	}
}
