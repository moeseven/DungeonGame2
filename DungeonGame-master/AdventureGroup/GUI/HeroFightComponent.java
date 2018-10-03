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

public class HeroFightComponent extends HeroComponent{
	protected Hero hero;
	protected FightWindow fw;
	protected MyMouseListener ml;
	public static final int width=120;
	public HeroFightComponent(FightWindow fw, Hero hero) {
		super(hero, fw.getGame());
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
		int number=fw.getGuiFight().getFight().getTurnOrder().indexOf(hero)-fw.getGuiFight().getFight().getTurnOrderCounter();
		g.drawString("moves in "+number+" turns", 8, 25);
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
