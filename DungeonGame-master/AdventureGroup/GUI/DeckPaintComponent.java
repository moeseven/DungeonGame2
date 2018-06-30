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

public class DeckPaintComponent extends JComponent{
		private Hero hero;
		private StatsWindow gw;
		private int cardHeight=100;
		private int cardWidth=80;
		public DeckPaintComponent(StatsWindow gw,Hero hero){
			this.gw=gw;
			this.hero=hero;
			setBorder(new LineBorder(Color.YELLOW));
			super.setPreferredSize(new Dimension(cardWidth+1,hero.getDeck().getCards().size()*cardHeight+10));
			MyMouseListener ml = new MyMouseListener();
			addMouseListener(ml);
			setVisible(true);
		}

	private class MyMouseListener extends MouseAdapter{
		public void mousePressed(MouseEvent e){	
			if(e.getButton()==1){
				int x=e.getX();
				int y=e.getY();
				//get card position from click
				int i=Math.round(y/cardHeight);
				if (i<hero.getDeck().getCards().size()) {
					gw.getGame().getPlayer().getSelectedHero().setSelectedCard(hero.getDeck().getCards().get(i));					
				}	
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
		for (int i=0;i<hero.getDeck().getCards().size();i++){
			g.setColor(Color.black);
			g.drawString(hero.getDeck().getCards().get(i).getName(), 10, 15+i*cardHeight);
			g.drawString(""+hero.getDeck().getCards().get(i).getManaCost(), 5, 10+i*cardHeight);
			for(int b=hero.getPlayer().getGroupSize()-1;b>=0;b--) {
				if(hero.getPlayer().getSelectedHero().getDeck().getCards().get(i).getLegalPositions()[b]) {
					g.setColor(Color.WHITE);
				}else {
					g.setColor(Color.DARK_GRAY);
				}
				g.fillOval(10+15*(hero.getPlayer().getGroupSize()-1)-b*15, 25+i*cardHeight, 12, 12);
			}
			if(gw.getGame().getPlayer().getSelectedHero().getSelectedCard()==hero.getDeck().getCards().get(i)){
				g.setColor(Color.red);
				g.drawRect(1, 1+i*cardHeight, cardWidth, cardHeight);
				
			}
		}
	}
}

