package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.LinkedList;

import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.LineBorder;

import gameEncounter.Card;
import gameEncounter.Hero;

public class HeroInventoryPaintComponent extends JComponent{
		private Hero hero;
		private JPanel jp;
		private JScrollPane sp;
		private GameWindow gw;
		public HeroInventoryPaintComponent(GameWindow gw,Hero hero){
			this.gw=gw;
			this.hero=hero;
			setBorder(new LineBorder(Color.YELLOW));
			super.setPreferredSize(new Dimension(600,120));
			MyMouseListener ml = new MyMouseListener();
			super.addMouseListener(ml);
			setLayout(new BorderLayout());
			setVisible(true);
		}

	private class MyMouseListener extends MouseAdapter{
		public void mouseClicked(MouseEvent e){	
			if(e.getButton()==1){
				int x=e.getX();
				int y=e.getY();
				//get equipment position from click
					gw.repaint();				
			}else{
				if (e.getButton()==3){
					//new CardView(card);
				}
			}
		} 
	}
	protected void paintComponent(Graphics g){
		super.paintComponent(g);
		//g.drawImage(image,0,0,null);		
			g.setColor(Color.black);
			g.drawRect(10, 20, 40, 40);//hand1
			g.drawString("hand1", 13, 31);
			g.drawRect(110, 20, 40, 40);//hand2
			g.drawString("hand2", 113, 31);
			//armor
			g.drawRect(60, 60, 40, 40);			
			if(hero.getInventory().getArmor()!=null) {
				g.drawString(hero.getInventory().getArmor().toString(), 63, 71);
			}else {
				g.drawString("body", 63, 71);
			}
			//head
			g.drawRect(60, 10, 40, 40);		
			g.drawString("head", 63, 21);
			
			//g.drawString(hero.getInventory().getHand1().toString(), 10, 35);
			//g.drawString(hero.getInventory().getHand2().toString(), 50, 35);
	}
}

