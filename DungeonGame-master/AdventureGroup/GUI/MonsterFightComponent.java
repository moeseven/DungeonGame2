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

public class MonsterFightComponent extends JComponent{
	private Hero monster;
	private Image image;
	private FightWindow fw;
	public MonsterFightComponent(FightWindow fw, Hero monster) {
		this.monster=monster;
		this.fw=fw;
		super.setPreferredSize(new Dimension(120,170));
		MyMouseListener ml = new MyMouseListener();
		super.addMouseListener(ml);
		setLayout(new BorderLayout());
		setVisible(true);
	}

	private class MyMouseListener extends MouseAdapter{
		public void mousePressed(MouseEvent e){
			if(e.getButton()==1){				
				//show more details
			}else{
				if (e.getButton()==3){
					fw.getGame().getPlayer().getSelectedHero().setTarget(monster);
					fw.getGame().getPlayer().getSelectedHero().getSelectedCard().playCard(fw.getGame().getPlayer().getSelectedHero());
				}
			}
			fw.getGuiFight().upadate();
			fw.revalidate();
			fw.repaint();
		} 
	}
	protected void paintComponent(Graphics g){
		super.paintComponent(g);
		g.drawImage(monster.getImage().getScaledInstance(180, 153, 3),-40,0,null);	//scaled Instance has bad performance!	
		if(fw!=null){			
			if(fw.getGame().getPlayer().getSelectedHero().getTarget()==monster){
				g.setColor(Color.red);
				int posX=30; int posY=20;
				g.drawOval(posX, posY, 20, 20);
				g.drawOval(posX+3, posY+3, 14, 14);
				g.fillOval(posX+7, posY+7, 6, 6);
				//g.drawRect(1, 1, 98, 148);
			}
			if(monster.isDead()){
				g.setColor(Color.BLACK);
				g.fillRect(50, 30, 10, 60);
				g.fillRect(35, 45, 40, 10);
			}
		}
		for(int i=0; i<monster.getBuffs().size();i++) {
			g.setColor(Color.YELLOW);
			g.fillOval(10+i*6,95, 6, 6);
		}
		g.setColor(Color.black);
		g.drawString(monster.getName(), 10, 15);
		if(monster.getPoison()>0) {
			g.setColor(Color.GREEN);
			g.drawString(""+monster.getPoison(), 10, 35);
		}
		if(monster.getBleed()>0) {
			g.setColor(Color.RED);
			g.drawString(""+monster.getBleed(), 25, 35);
		}
		if(monster.getCold()>0) {
			g.setColor(Color.WHITE);
			g.drawString(""+monster.getCold(), 40, 35);
		}
		if(monster.getBlock()>0) {
			g.setColor(Color.blue);
			g.drawString(""+monster.getBlock(), 10, 45);
		}
	
		g.setColor(Color.red);
		g.drawString(""+monster.getHp(), 10, 65);
	}
}
