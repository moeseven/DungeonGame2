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

public class HeroFightManaComponent extends JComponent{
	private FightWindow fw;
	public HeroFightManaComponent(FightWindow fw) {
		this.fw=fw;
		super.setPreferredSize(new Dimension(100,80));
		setLayout(new BorderLayout());
		setVisible(true);
	}
	protected void paintComponent(Graphics g){
		super.paintComponent(g);		
		g.setColor(Color.black);
		for(int i=0;i<fw.getGame().getPlayer().getSelectedHero().getMana();i++) {
			g.drawOval(80, 1+i*12, 10, 10);
		}
	}
}
