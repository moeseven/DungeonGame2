package GUI;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JComponent;

import GUI.grafics.StaticImageLoader;
import game.DungeonMaster;
import game.Game;
import gameEncounter.GameEquations;
import gameEncounter.Hero;

public class HeroComponent extends JComponent{
	protected Hero hero;
	private Game game;
	public HeroComponent(Hero hero,Game game) {
		this.hero=hero;
		this.game=game;
	}
	protected void paintComponent(Graphics g){
		super.paintComponent(g);
		g.drawImage(StaticImageLoader.getImage(hero.getImageNumber()).getScaledInstance(60*hero.getImageScale(), 51*hero.getImageScale(), hero.getImageScale()),-40,0,null);
		if(game.getPlayer().getSelectedHero()==hero){
			g.setColor(Color.green);
			g.drawRect(1, 1, 98, 148);
		}
		if(hero.isDead()){
			g.setColor(Color.BLACK);
			g.fillRect(50, 30, 10, 60);
			g.fillRect(35, 45, 40, 10);
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
		if(hero.getFire()>0) {
			g.setColor(Color.ORANGE);
			g.drawString(""+hero.getFire(), 40, 35);
		}
		if(hero.getBlock()>0) {
			g.setColor(Color.blue);
			g.drawString(""+hero.getBlock()+"/"+hero.getArmor(), 14, 140);
		}
		g.setColor(Color.red);
		g.drawString(""+hero.getHp()+"/"+GameEquations.maxHealthCalc(hero), 30, 155);		

		g.setColor(Color.GRAY);
		g.drawString(""+hero.getStress()+"/"+hero.getStressCap(), 30, 170);

	}
}
