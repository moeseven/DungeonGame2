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

import gameEncounter.Card;
import gameEncounter.Hero;

public class HeroStatsComponent extends JComponent{
	private GameWindow gf;
	private Hero hero;
	public HeroStatsComponent(GameWindow gf, Hero hero) {
		this.gf=gf;
		this.hero=hero;
		super.setPreferredSize(new Dimension(100,80));
		setLayout(new BorderLayout());
		setVisible(true);
	}
	protected void paintComponent(Graphics g){
		super.paintComponent(g);		
		g.setColor(Color.red);
		g.drawString(hero.getHp()+"", 5, 25);
		g.setColor(Color.blue);
		g.drawString(""+hero.getBlock(), 5, 10);
		g.setColor(Color.black);
		g.drawString(""+hero.getMana(), 20, 35);
	}
}
