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
//		try {
//		    image=ImageIO.read(new File(card.getImage())).getScaledInstance(100, 150, image.SCALE_SMOOTH);
//		} catch (IOException e) {
//		}
		this.monster=monster;
		this.fw=fw;
		super.setPreferredSize(new Dimension(120,150));
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
		//g.drawImage(image,0,0,null);
		if(fw!=null){			
			if(fw.getGame().getPlayer().getSelectedHero().getTarget()==monster){
				g.setColor(Color.red);
				g.drawRect(1, 1, 98, 148);
			}
			if(monster.isDead()){
				g.setColor(Color.BLACK);
				g.fillRect(50, 30, 10, 60);
				g.fillRect(35, 45, 40, 10);
			}
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
