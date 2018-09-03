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
		private JPanel jp;
		private JScrollPane sp;
		private FightWindow fw;
		public HandPaintComponent(FightWindow fw){
			this.fw=fw;
			setBorder(new LineBorder(Color.YELLOW));
			super.setPreferredSize(new Dimension(1000,120));
			MyMouseListener ml = new MyMouseListener();
			super.addMouseListener(ml);
			setLayout(new BorderLayout());
			setVisible(true);
		}

	private class MyMouseListener extends MouseAdapter{
		public void mousePressed(MouseEvent e){	
			if(e.getButton()==1){
				int x=e.getX();
				int y=e.getY();
				//get card position from click
				int i=Math.round(x/100);
				if (i<fw.getGame().getPlayer().getSelectedHero().getHand().size()) {
					fw.getGame().getPlayer().getSelectedHero().setSelectedCard(fw.getGame().getPlayer().getSelectedHero().getHand().get(i));;	
					fw.repaint();
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
		for (int i=0;i<fw.getGame().getPlayer().getSelectedHero().getHand().size();i++){
			g.setColor(Color.black);
			g.drawString(fw.getGame().getPlayer().getSelectedHero().getHand().get(i).getName(), 20+i*100, 15);
			g.drawString(""+fw.getGame().getPlayer().getSelectedHero().getHand().get(i).getManaCost(), 5+i*100, 10);
			//mana bubbles
			for(int m = 0;m<fw.getGame().getPlayer().getSelectedHero().getDeck().getCards().get(i).getManaCost();m++) {			
				g.setColor(Color.BLUE);				
				g.fillOval(5+m*10+i*100, 15, 8, 8);
			}
			for(int b=fw.getGame().getPlayer().getGroupSize()-1;b>=0;b--) {
				if(fw.getGame().getPlayer().getSelectedHero().getHand().get(i).getLegalCastPositions()[b]) {
					g.setColor(Color.WHITE);
				}else {
					g.setColor(Color.DARK_GRAY);
				}
				g.fillOval(5+10*(fw.getGame().getPlayer().getGroupSize()-1)-b*10+i*100, 25, 8, 8);
			}
			if (!fw.getGame().getPlayer().getSelectedHero().getHand().get(i).isFriendly()) {
				for(int b=0;b<fw.getGame().dungeonMaster.getGroupSize();b++) {
					if(fw.getGame().getPlayer().getSelectedHero().getHand().get(i).getLegalTargetPositions()[b]) {
						g.setColor(Color.ORANGE);
					}else {
						g.setColor(Color.DARK_GRAY);
					}
					g.fillOval(42+b*10+i*100, 25, 8, 8);
				}
			}			
			if(fw.getGame().getPlayer().getSelectedHero().getSelectedCard()==fw.getGame().getPlayer().getSelectedHero().getHand().get(i)){
				g.setColor(Color.red);
				g.drawRect(1+i*100, 1, 100, 80);
				g.drawString(""+fw.getGame().getPlayer().getSelectedHero().getHand().get(i).getCardText(fw.getGame().getPlayer().getSelectedHero()), 100, 90);
			}
		}
	}
}

