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

public class HandPaintComponent extends JComponent{
		private Hero hero;
		private JPanel jp;
		private JScrollPane sp;
		private GameWindow gf;
		public HandPaintComponent(GameWindow gf,Hero hero){
			this.gf=gf;
			this.hero=hero;
			setBorder(new LineBorder(Color.YELLOW));
			super.setPreferredSize(new Dimension(1000,90));
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
				//get card position from click
				int i=Math.round(x/100);
				if (i<hero.getHand().size()) {
					gf.getGame().getPlayer().getSelectedHero().setSelectedCard(hero.getHand().get(i));;	
					gf.repaint();
				}				
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
		for (int i=0;i<hero.getHand().size();i++){
			g.setColor(Color.black);
			g.drawString(hero.getHand().get(i).getName(), 20+i*100, 15);
			g.drawString(""+hero.getHand().get(i).getManaCost(), 5+i*100, 10);
			if(gf.getGame().getPlayer().getSelectedHero().getSelectedCard()==hero.getHand().get(i)){
				g.setColor(Color.red);
				g.drawRect(1+i*100, 1, 100, 80);
			}
		}
	}
}

