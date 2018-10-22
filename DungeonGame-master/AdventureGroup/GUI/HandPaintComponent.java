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
import gameEncounter.GameEquations;
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
			g.drawImage(StaticImageLoader.getImage(fw.getGame().getPlayer().getSelectedHero().getHand().get(i).getImageNumber()).getScaledInstance(120,102, 2),20+i*100, 15,null);			
			g.setColor(Color.black);
			g.drawString(fw.getGame().getPlayer().getSelectedHero().getHand().get(i).getName(), 20+i*100, 15);
			g.drawString(""+fw.getGame().getPlayer().getSelectedHero().getHand().get(i).computeManaCost(fw.getGame().getPlayer().getSelectedHero()), 5+i*100, 10);
			//mana bubbles
			for(int m = 0;m<fw.getGame().getPlayer().getSelectedHero().getHand().get(i).computeManaCost(fw.getGame().getPlayer().getSelectedHero());m++) {			
				g.setColor(Color.BLUE);				
				g.fillOval(5+m*10+i*100, 15, 8, 8);
			}
			for(int b=fw.getGame().getPlayer().getHeroes().size()-1;b>=0;b--) {
				if(fw.getGame().getPlayer().getSelectedHero().getHand().get(i).getLegalCastPositions()[b]) {
					g.setColor(Color.WHITE);
				}else {
					g.setColor(Color.DARK_GRAY);
				}
				g.fillOval(5+8*(fw.getGame().getPlayer().getGroupSize()-1)-b*8+i*100, 25, 8, 8);
			}
			if (!fw.getGame().getPlayer().getSelectedHero().getHand().get(i).isFriendly()) {
				for(int b=0;b<fw.getGame().dungeonMaster.getHeroes().size();b++) {
					if(fw.getGame().getPlayer().getSelectedHero().getHand().get(i).getLegalTargetPositions()[b]) {
						g.setColor(Color.ORANGE);
					}else {
						g.setColor(Color.DARK_GRAY);
					}
					g.fillOval(42+b*8+i*100, 25, 8, 8);
				}
			}	
			Hero hero =fw.getGame().getPlayer().getSelectedHero();
			Card card=hero.getSelectedCard();
			if(card==fw.getGame().getPlayer().getSelectedHero().getHand().get(i)){
				g.setColor(Color.red);
				g.drawRect(1+i*100, 1, 100, 80);
								
				if (hero.getTarget()!=null) {
					if (card.getAttackDamage()>0) {
						g.drawString("damage: "+(GameEquations.calculateAttackDamage(card, hero)+"("+GameEquations.damageReducedByArmor(GameEquations.calculateAttackDamage(card, hero), hero.getTarget().getArmor()))+")", 10, 95);
					}	
					if (card.getAttackDamage()>0||card.getSpellDamage()>0) {
						g.drawString("crit chance: "+GameEquations.critChanceCalc(hero), 10, 115);
						g.drawString("accuracy: "+(card.getAccuracy()+GameEquations.accuracyCalc(hero,hero.getTarget())), 10, 105);
					}
				}
				
			}
		}
	}
}

