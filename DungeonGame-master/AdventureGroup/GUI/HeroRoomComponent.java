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

import GUI.grafics.StaticImageLoader;
import gameEncounter.Card;
import gameEncounter.GameEquations;
import gameEncounter.Hero;

public class HeroRoomComponent extends HeroComponent{
	private RoomWindow rw;
	public HeroRoomComponent(RoomWindow rw, Hero hero) {
		super(hero,rw.getGame());
		this.rw=rw;
		super.setPreferredSize(new Dimension(120,170));
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
//		if(rw!=null){
//			g.drawImage(StaticImageLoader.getImage(hero.getImageNumber()).getScaledInstance(180, 153, 3),-40,0,null);	
//			if(rw.getGame().getPlayer().getSelectedHero()==hero){
//				g.setColor(Color.green);
//				g.drawRect(1, 1, 98, 148);
//			}
//		}
		
//		g.setColor(Color.black);
//		g.drawString(hero.getName(), 10, 15);
//		g.setColor(Color.blue);
//		g.drawString(""+hero.getBlock(), 10, 45);
//		g.setColor(Color.red);
//		g.drawString(""+hero.getHp()+"/"+GameEquations.maxHealthCalc(hero), 30, 155);
//		g.setColor(Color.GRAY);
//		g.drawString(""+hero.getStress()+"/"+hero.getStressCap(), 30, 170);
		
	}
}
