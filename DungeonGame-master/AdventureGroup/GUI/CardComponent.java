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

public class CardComponent extends JComponent{
	private Card card;
	private Image image;
	private FightWindow fw;
	public CardComponent(FightWindow fw, Card card) {
//		try {
//		    image=ImageIO.read(new File(card.getImage())).getScaledInstance(100, 150, image.SCALE_SMOOTH);
//		} catch (IOException e) {
//		}
		this.fw=fw;
		this.card=card;
		super.setPreferredSize(new Dimension(100,80));
		MyMouseListener ml = new MyMouseListener();
		super.addMouseListener(ml);
		setLayout(new BorderLayout());
		setVisible(true);
	}

	private class MyMouseListener extends MouseAdapter{
		public void mouseClicked(MouseEvent e){
			if(e.getButton()==1){
				fw.getGame().getPlayer().getSelectedHero().setSelectedCard(card);;	
				fw.repaint();
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
		if(fw!=null){			
			if(fw.getGame().getPlayer().getSelectedHero().getSelectedCard()==card){
				g.setColor(Color.red);
				g.drawRect(1, 1, 100, 80);
			}
		}
		g.setColor(Color.black);
		g.drawString(card.getName(), 20, 15);
		g.drawString(""+card.getManaCost(), 5, 10);
	}
}
