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
import gameEncounter.ModableHeroStats;

public class HeroStatsPaintComponent extends JComponent{
		private Hero hero;
		private StatsWindow gf;
		public HeroStatsPaintComponent(StatsWindow gf,Hero hero){
			this.gf=gf;
			this.hero=hero;
			setBorder(new LineBorder(Color.GREEN));
			super.setPreferredSize(new Dimension(300,200));
			setVisible(true);
		}

	private class MyMouseListener extends MouseAdapter{
		public void mouseClicked(MouseEvent e){	
			if(e.getButton()==1){
				int x=e.getX();
				int y=e.getY();
				//get card position from click
				int i=Math.round(x/100);
				//handle clicks in hero info
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
		//paint Hero info
		g.drawString(hero.getName(), 10, 10);
		g.drawString("HP: "+hero.getHp()+"/"+hero.getMaxHp(), 10, 10+1*11);		
		g.drawString("attack skill: "+hero.getAttackSkill(), 10, 10+2*11);
		g.drawString("block skill: "+hero.getBlockSkill(), 10, 10+3*11);
		g.drawString("wisdom: "+hero.getDraw(), 10, 10+7*11);
		g.drawString("mana: "+hero.getManaPower(), 10, 10+5*11);
		g.drawString("thorns: "+hero.getThorns(), 10, 10+6*11);
		g.drawString("armor: "+hero.getArmor(), 10, 10+4*11);
	}
}

