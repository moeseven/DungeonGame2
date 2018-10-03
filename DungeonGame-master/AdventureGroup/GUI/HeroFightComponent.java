package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JComponent;

import GUI.grafics.StaticImageLoader;
import game.DungeonMaster;
import gameEncounter.Card;
import gameEncounter.GameEquations;
import gameEncounter.Hero;

public class HeroFightComponent extends JComponent{
	protected Hero hero;
	protected FightWindow fw;
	protected MyMouseListener ml;
	public static final int width=120;
	public HeroFightComponent(FightWindow fw, Hero hero) {
		this.hero=hero;
		this.fw=fw;
		super.setPreferredSize(new Dimension(width,170));
		ml = new MyMouseListener();
		super.addMouseListener(ml);
		setLayout(new BorderLayout());
		setVisible(true);
	}

	private class MyMouseListener extends MouseAdapter{
		public void mouseEntered(MouseEvent e) {
			fw.getGame().getPlayer().getSelectedHero().setNewTarget(hero);
			fw.repaint();
		}
		public void mouseExited(MouseEvent e) {
			fw.getGame().getPlayer().getSelectedHero().setNewTarget(null);
			fw.repaint();
		}
		public void mousePressed(MouseEvent e){
			if(e.getButton()==1){
				if (!(hero.getPlayer() instanceof DungeonMaster)) {
					fw.getGame().getPlayer().setSelectedHero(hero);		
				}								
			}else{
				if (e.getButton()==3){
					fw.getGame().getPlayer().getSelectedHero().setNewTarget(hero);
					if (fw.getGame().getPlayer().getSelectedHero().getSelectedCard().playable(fw.getGame().getPlayer().getSelectedHero())) {
						fw.getGame().getPlayer().getSelectedHero().getSelectedCard().cast(fw.getGame().getPlayer().getSelectedHero());
					}
				}
			}
			fw.revalidate();
			fw.repaint();
			fw.getGuiFight().upadate();
		} 
	}
	protected void paintComponent(Graphics g){
		super.paintComponent(g);
		g.drawImage(StaticImageLoader.getImage(hero.getImageNumber()).getScaledInstance(60*hero.getImageScale(), 51*hero.getImageScale(), hero.getImageScale()),-40,0,null);
		int number=fw.getGuiFight().getFight().getTurnOrder().indexOf(hero)-fw.getGuiFight().getFight().getTurnOrderCounter();
		g.drawString("moves in "+number+" turns", 8, 25);
		if(fw!=null){			
			if(fw.getGame().getPlayer().getSelectedHero()==hero){
				g.setColor(Color.green);
				g.drawRect(1, 1, 98, 148);
			}
			if(hero.isDead()){
				g.setColor(Color.BLACK);
				g.fillRect(50, 30, 10, 60);
				g.fillRect(35, 45, 40, 10);
			}
		}
		for(int i=0; i<hero.getBuffs().size();i++) {
			g.setColor(Color.YELLOW);
			g.fillOval(10+i*6,95, 6, 6);
		}
		g.setColor(Color.black);
		g.drawString(hero.getName(), 8, 15);
		if(hero.getPoison()>0) {
			g.setColor(Color.GREEN);
			g.drawString(""+hero.getPoison(), 10, 35);
		}
		if(hero.getBleed()>0) {
			g.setColor(Color.RED);
			g.drawString(""+hero.getBleed(), 25, 35);
		}
		if(hero.getCold()>0) {
			g.setColor(Color.WHITE);
			g.drawString(""+hero.getCold(), 40, 35);
		}
		if(hero.getBlock()>0) {
			g.setColor(Color.blue);
			g.drawString(""+hero.getBlock(), 14, 155);
		}
		g.setColor(Color.red);
		g.drawString(""+hero.getHp()+"/"+GameEquations.maxHealthCalc(hero), 30, 155);
		g.setColor(Color.GRAY);
		if (!(hero.getPlayer() instanceof DungeonMaster)) {
			g.drawString(""+hero.getStress()+"/"+hero.getStressCap(), 30, 170);
			if (fw.getGame().getPlayer().getSelectedHero().getTarget()!=null&&fw.getGame().getRoom().getFight().getTargetMap().containsKey(fw.getGame().getPlayer().getSelectedHero().getTarget())) {
				if (fw.getGame().getRoom().getFight().getTargetMap().get(fw.getGame().getPlayer().getSelectedHero().getTarget()).containsValue(hero)) {
					g.setColor(Color.RED);
					g.drawOval(35, 35, 40, 40);
					g.drawOval(40, 40, 30, 30);
					g.drawOval(47, 47, 15, 15);
				}
			}
		}
		if (hero.isStunned()) {
			g.setColor(Color.WHITE);
			g.drawOval(35, 35, 50, 40);
			g.drawOval(40, 40, 40, 30);
			g.drawOval(47, 47, 20, 15);
		}
		
	}
}
