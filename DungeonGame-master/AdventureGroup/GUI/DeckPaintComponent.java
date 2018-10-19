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

import GUI.grafics.StaticImageLoader;
import gameEncounter.Card;
import gameEncounter.Hero;

public class DeckPaintComponent extends JComponent{
		private Hero hero;
		private StatsWindow gw;
		private int cardHeight=100;
		private int cardWidth=80;
		private HeroInfoComponent hic;
		public DeckPaintComponent(StatsWindow gw,HeroInfoComponent hic,Hero hero){
			this.gw=gw;
			this.hic=hic;
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
				if (gw.getGame().getPlayer().getSelectedHero().getSelectedCard()==hero.getDeck().getCards().get(i)&&hic.removeCard) {
					hic.removeCard=false;					
					if(hero.getDeck().getCards().remove(hero.getSelectedCard())) {
						hero.setCardPoints(hero.getCardPoints()-1);
						if (hero.getCardPoints()>0) {
							hic.decide=true;
							hic.upadate();
						}
					}
					hero.setSelectedCard(hero.getDeck().getCards().getFirst());
					
				}
				if (i<hero.getDeck().getCards().size()) {
					gw.getGame().getPlayer().getSelectedHero().setSelectedCard(hero.getDeck().getCards().get(i));					
				}	
				gw.revalidate();
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
		for (int i=0;i<hero.getDeck().getCards().size();i++){	
			g.drawImage(StaticImageLoader.getImage(hero.getDeck().getCards().get(i).getImageNumber()).getScaledInstance(120,102, 2),-15, 10+i*cardHeight,null);		
			g.setColor(Color.WHITE);
			g.drawString(""+hero.getDeck().getCards().get(i).computeManaCost(hero), 5, 10+i*cardHeight);
			g.setColor(Color.black);
			g.drawString(hero.getDeck().getCards().get(i).getName(), 10, 15+i*cardHeight);
			//mana bubbles
			for(int m = 0;m<hero.getDeck().getCards().get(i).computeManaCost(hero);m++) {			
				g.setColor(Color.BLUE);				
				g.fillOval(10+m*10, 15+i*cardHeight, 8, 8);
			}
			//cast positions
			for(int b=hero.getPlayer().getGroupSize()-1;b>=0;b--) {
				if(hero.getPlayer().getSelectedHero().getDeck().getCards().get(i).getLegalCastPositions()[b]) {
					g.setColor(Color.WHITE);
				}else {
					g.setColor(Color.DARK_GRAY);
				}
				g.fillOval(10+10*(hero.getPlayer().getGroupSize()-1)-b*10, 25+i*cardHeight, 8, 8);
			}
			//target positions
			if (!hero.getDeck().getCards().get(i).isFriendly()) {
				for(int b=0;b<hero.getPlayer().getGame().dungeonMaster.getGroupSize();b++) {
					if(hero.getDeck().getCards().get(i).getLegalTargetPositions()[b]) {
						g.setColor(Color.ORANGE);
					}else {
						g.setColor(Color.DARK_GRAY);
					}
					g.fillOval(42+b*10, 25+i*cardHeight, 8, 8);
				}
			}			
			if(gw.getGame().getPlayer().getSelectedHero().getSelectedCard()==hero.getDeck().getCards().get(i)){
				g.setColor(Color.red);
				g.drawRect(1, 1+i*cardHeight, cardWidth, cardHeight);
				
			}
		}
	}
}

