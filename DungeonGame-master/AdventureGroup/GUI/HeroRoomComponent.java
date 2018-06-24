package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JComponent;

import gameEncounter.Card;
import gameEncounter.Hero;

public class HeroRoomComponent extends JComponent{
	private Hero hero;
	private Image image;
	private RoomWindow rw;
	public HeroRoomComponent(RoomWindow rw, Hero hero) {
//		try {
//		    image=ImageIO.read(new File(card.getImage())).getScaledInstance(100, 150, image.SCALE_SMOOTH);
//		} catch (IOException e) {
//		}
		this.hero=hero;
		this.rw=rw;
		super.setPreferredSize(new Dimension(120,150));
		MyMouseListener ml = new MyMouseListener();
		super.addMouseListener(ml);
		setLayout(new BorderLayout());
		setVisible(true);
	}

	private class MyMouseListener extends MouseAdapter{
		public void mousePressed(MouseEvent e){
			if(e.getButton()==1){
				rw.getGame().getPlayer().setSelectedHero(hero);						
			}else{
				if (e.getButton()==3){
					//rw.getGame().getPlayer().getSelectedHero().setTarget(hero);
				}
			}
			rw.getGuiRoom().upadate();
		} 
	}
	protected void paintComponent(Graphics g){
		super.paintComponent(g);
		//g.drawImage(image,0,0,null);
		if(rw!=null){			
			if(rw.getGame().getPlayer().getSelectedHero()==hero){
				g.setColor(Color.green);
				g.drawRect(1, 1, 98, 148);
			}
		}
		g.setColor(Color.black);
		g.drawString(hero.getName(), 10, 15);
		g.setColor(Color.blue);
		g.drawString(""+hero.getBlock(), 10, 45);
		g.setColor(Color.red);
		g.drawString(""+hero.getHp(), 10, 65);
	}
}
