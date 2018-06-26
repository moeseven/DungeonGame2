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

public class StatsSkillComponent extends JComponent{
		private Hero hero;
		private StatsWindow gw;
		private int cardHeight=20;
		private int cardWidth=80;
		public StatsSkillComponent(StatsWindow gw,Hero hero){
			this.gw=gw;
			this.hero=hero;
			setBorder(new LineBorder(Color.ORANGE));
			super.setPreferredSize(new Dimension(cardWidth+1,hero.getLvlUpCards().size()*(cardHeight+6)));
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
				if (i==0) {
					gw.getGame().getPlayer().getSelectedHero().setSkillPoints(gw.getGame().getPlayer().getSelectedHero().getSkillPoints()-1);
					gw.getGame().getPlayer().getSelectedHero().setStrength(gw.getGame().getPlayer().getSelectedHero().getStrength()+1);
				}
				if (i==1) {
					gw.getGame().getPlayer().getSelectedHero().setSkillPoints(gw.getGame().getPlayer().getSelectedHero().getSkillPoints()-1);
					gw.getGame().getPlayer().getSelectedHero().setDexterity(gw.getGame().getPlayer().getSelectedHero().getDexterity()+1);				
								}
				if (i==2) {
					gw.getGame().getPlayer().getSelectedHero().setSkillPoints(gw.getGame().getPlayer().getSelectedHero().getSkillPoints()-1);
					gw.getGame().getPlayer().getSelectedHero().setIntelligence(gw.getGame().getPlayer().getSelectedHero().getIntelligence()+1);
				}
				if (i==3) {
					gw.getGame().getPlayer().getSelectedHero().setSkillPoints(gw.getGame().getPlayer().getSelectedHero().getSkillPoints()-1);
					gw.getGame().getPlayer().getSelectedHero().setVitality(gw.getGame().getPlayer().getSelectedHero().getVitality()+1);
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
		//g.drawImage(image,0,0,null)
		g.setColor(Color.black);
		g.drawString("+strength+", 10, 15);
		g.drawString("+dexterity+", 10, 15+1*cardHeight);
		g.drawString("+intelligence+", 10, 15+2*cardHeight);
		g.drawString("+vitality+", 10, 15+3*cardHeight);
	}
}

