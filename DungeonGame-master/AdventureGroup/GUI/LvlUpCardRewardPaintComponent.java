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

public class LvlUpCardRewardPaintComponent extends JComponent{
		private Hero hero;
		private StatsWindow gw;
		private int cardHeight=100;
		private int cardWidth=80;
		public LvlUpCardRewardPaintComponent(StatsWindow gw,Hero hero){
			this.gw=gw;
			this.hero=hero;
			setBorder(new LineBorder(Color.ORANGE));
			super.setPreferredSize(new Dimension(cardWidth+1,hero.getLvlUpCards().size()*cardHeight+10));
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
				if (i<hero.getCharClass().getCardPool().size()) {					
					gw.getGame().getPlayer().getSelectedHero().setSelectedCard(hero.getLvlUpCards().get(i));
					gw.getGame().getPlayer().getSelectedHero().getDeck().addCard(gw.getGame().getPlayer().getSelectedHero().getSelectedCard());
					gw.getGame().getPlayer().getSelectedHero().setCardPoints(gw.getGame().getPlayer().getSelectedHero().getCardPoints()-1);
					gw.getGame().getPlayer().getSelectedHero().setLvlUpCards(new LinkedList<Card>());
					if(gw.getGame().getPlayer().getSelectedHero().getCardPoints()>0) {
						gw.getGame().getPlayer().getSelectedHero().generatelvlUpCards();
					}
					
				}	
				gw.myUpdate();
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
		for (int i=0;i<hero.getLvlUpCards().size();i++){
			g.setColor(Color.black);
			g.drawString(hero.getLvlUpCards().get(i).getName(), 10, 15+i*cardHeight);
			g.drawString(""+hero.getLvlUpCards().get(i).getManaCost(), 5, 10+i*cardHeight);
			if(gw.getGame().getPlayer().getSelectedHero().getSelectedCard()==hero.getLvlUpCards().get(i)){
				g.setColor(Color.red);
				g.drawRect(1, 1+i*cardHeight, cardWidth, cardHeight);
			}
		}
	}
}

