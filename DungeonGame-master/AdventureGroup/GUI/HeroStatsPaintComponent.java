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
import gameEncounter.GameEquations;
import gameEncounter.Hero;
import gameEncounter.ModableHeroStats;
import gameEncounter.Weapon;

public class HeroStatsPaintComponent extends JComponent{
		private StatsWindow gf;
		public HeroStatsPaintComponent(StatsWindow gf){
			this.gf=gf;
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
		g.drawString(gf.getGame().getPlayer().getSelectedHero().getName()+" ("+gf.getGame().getPlayer().getSelectedHero().getCharRace().getName()+", "+gf.getGame().getPlayer().getSelectedHero().getCharClass().getName()+")", 10, 10);
		g.drawString("HP: "+gf.getGame().getPlayer().getSelectedHero().getHp()+"/"+gf.getGame().getPlayer().getSelectedHero().computeMaxHp(), 10, 10+1*11);
		if(gf.getGame().getPlayer().getSelectedHero().getEquipment().getHand1() instanceof Weapon) {
			Weapon weapon= (Weapon) gf.getGame().getPlayer().getSelectedHero().getEquipment().getHand1();
			g.drawString("damage: "+weapon.AttackDamageToString(gf.getGame().getPlayer().getSelectedHero().getStrength()), 10, 10+2*11);
		}else {
			g.drawString("damage: "+GameEquations.FistDamageToString(gf.getGame().getPlayer().getSelectedHero().getStrength(), gf.getGame().getPlayer().getSelectedHero().getDexterity()), 10, 10+2*11);
		}
		g.drawString("block skill: "+gf.getGame().getPlayer().getSelectedHero().getBlockSkill(), 10, 10+3*11);
		g.drawString("wisdom: "+gf.getGame().getPlayer().getSelectedHero().getDraw(), 10, 10+7*11);
		g.drawString("mana: "+gf.getGame().getPlayer().getSelectedHero().getManaPower(), 10, 10+5*11);
		g.drawString("thorns: "+gf.getGame().getPlayer().getSelectedHero().getThorns(), 10, 10+6*11);
		g.drawString("armor: "+gf.getGame().getPlayer().getSelectedHero().getArmor(), 10, 10+4*11);
		g.drawString("strength: "+gf.getGame().getPlayer().getSelectedHero().getStrength(), 10, 10+8*11);
		g.drawString("dexterity: "+gf.getGame().getPlayer().getSelectedHero().getDexterity(), 10, 10+9*11);
		g.drawString("intelligence: "+gf.getGame().getPlayer().getSelectedHero().getIntelligence(), 10, 10+10*11);
		g.drawString("vitality: "+gf.getGame().getPlayer().getSelectedHero().getVitality(), 10, 10+11*11);
		g.drawString("speed: "+gf.getGame().getPlayer().getSelectedHero().getSpeed(), 10, 10+12*11);
	}
}

