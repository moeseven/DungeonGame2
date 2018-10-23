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
import java.util.StringTokenizer;

import javax.imageio.ImageIO;
import javax.swing.JComponent;

import GUI.grafics.StaticImageLoader;
import gameEncounter.Card;
import gameEncounter.Hero;
import tools.ClickableRectangle;
import tools.RectangleClicker;

public class HeroFightManaComponent extends JComponent{
	private FightWindow fw;
	private RectangleClicker rc;
	public HeroFightManaComponent(FightWindow fwindow) {
		this.fw=fwindow;
		rc=new RectangleClicker();
		super.setPreferredSize(new Dimension(180,300));
		setLayout(new BorderLayout());
		setVisible(true);
		//use potion
		ClickableRectangle potion = new ClickableRectangle("",94,0,30,30) {
			@Override
			public void onClick() {
				// TODO Auto-generated method stub
				if(fw.getGame().getPlayer().getHeroes().contains(fw.getGame().getPlayer().getSelectedHero())&&fw.getGame().getPlayer().getSelectedHero().getEquipment().getPotion()!=null) {
					fw.getGame().getPlayer().getSelectedHero().getEquipment().drinkPotion();
					fw.getGuiFight().upadate();
				}
					
			}
			@Override
			public void updateCaption() {
				if (fw.getGame().getPlayer().getSelectedHero().getEquipment().getPotion()!=null) {
					setImageNumber(fw.getGame().getPlayer().getSelectedHero().getEquipment().getPotion().getImageNumber());
				}else {
					cleanImageNumber();
				}
			}		
		};
		if (fw.getGame().getPlayer().getSelectedHero().getEquipment().getPotion()!=null) {
			potion.setImageNumber(fw.getGame().getPlayer().getSelectedHero().getEquipment().getPotion().getImageNumber());
		}
		rc.addRect(potion);
		//move forward fight movement
		rc.addRect(new ClickableRectangle(">",70,10,20,10) {
			@Override
			public void onClick() {
				// TODO Auto-generated method stub
				if(fw.getGame().getPlayer().getHeroes().contains(fw.getGame().getPlayer().getSelectedHero())&&fw.getGame().getPlayer().getSelectedHero().getMana()>=1&&fw.getGame().getPlayer().getSelectedHero().getPosition()>0) {
					fw.getGame().getPlayer().getSelectedHero().setMana(fw.getGame().getPlayer().getSelectedHero().getMana()-1);
					fw.getGame().getPlayer().getSelectedHero().moveForward();
					fw.getGuiFight().upadate();
				}
					
			}
			@Override
			public void updateCaption() {
				// TODO Auto-generated method stub					
			}		
		});
		//move backward fight movement
		rc.addRect(new ClickableRectangle("<",50,10,20,10) {
			@Override
			public void onClick() {
				// TODO Auto-generated method stub
				if(fw.getGame().getPlayer().getHeroes().contains(fw.getGame().getPlayer().getSelectedHero())&&fw.getGame().getPlayer().getSelectedHero().getMana()>=1&&fw.getGame().getPlayer().getSelectedHero().getPosition()<fw.getGame().getPlayer().getHeroes().size()-1) {
					fw.getGame().getPlayer().getSelectedHero().setMana(fw.getGame().getPlayer().getSelectedHero().getMana()-1);
					fw.getGame().getPlayer().getSelectedHero().moveBack();
					fw.getGuiFight().upadate();
				}
					
			}
			@Override
			public void updateCaption() {
				// TODO Auto-generated method stub					
			}		
		});
		setVisible(true);
		this.addMouseListener(new MyMouseListener());
	}
	private class MyMouseListener extends MouseAdapter{
		public void mousePressed(MouseEvent e){	
			if(e.getButton()==1){
				//get equipment position from click
				rc.triggerClick(e.getX(), e.getY());
				rc.updateCaptions();
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
		g.setColor(Color.BLUE);
		for(int i=0;i<fw.getGame().getPlayer().getSelectedHero().getMana();i++) {			
			g.fillOval(30, 1+i*12, 10, 10);		
		}
		g.setColor(Color.black);
		for(int i=0; i<rc.rectAngles.size();i++) {
			g.drawRect(rc.rectAngles.get(i).getX(), rc.rectAngles.get(i).getY(), rc.rectAngles.get(i).getLength(), rc.rectAngles.get(i).getHeight());
			for(int a=0; a<rc.rectAngles.get(i).getCaption().size();a++) {
				g.drawString(rc.rectAngles.get(i).getCaption().get(a), rc.rectAngles.get(i).getX()+3, rc.rectAngles.get(i).getY()+11+a*11);
			}			
			if (rc.rectAngles.get(i).getImageNumber()!=1) {
				g.drawImage(StaticImageLoader.getImage(rc.rectAngles.get(i).getImageNumber()).getScaledInstance(120,102, 2),rc.rectAngles.get(i).getX()-26,rc.rectAngles.get(i).getY()-18,null);
			}
		}				
		if (fw.getGame().getPlayer().getSelectedHero().getSelectedCard()!=null) {
			int skippedLines=0;
			for (int i = 0; i < fw.getGame().getPlayer().getSelectedHero().getSelectedCard().getCardText(fw.getGame().getPlayer().getSelectedHero()).size(); i++) {
				if (fw.getGame().getPlayer().getSelectedHero().getSelectedCard().getCardText(fw.getGame().getPlayer().getSelectedHero()).equals("")) {
					//skip empty lines
					skippedLines++;
				}else {
					if (fw.getGame().getPlayer().getSelectedHero().getSelectedCard().getCardText(fw.getGame().getPlayer().getSelectedHero()).get(i).length()>20) {
						String[] split= addLinebreaks(fw.getGame().getPlayer().getSelectedHero().getSelectedCard().getCardText(fw.getGame().getPlayer().getSelectedHero()).get(i), 20).split("#");
						for (int j = 0; j < split.length; j++) {
							g.drawString(split[j], 50, 12*(i-skippedLines+j)+40);
						}
						skippedLines-=split.length-1;
					}else {
						g.drawString(""+fw.getGame().getPlayer().getSelectedHero().getSelectedCard().getCardText(fw.getGame().getPlayer().getSelectedHero()).get(i), 50, 12*(i-skippedLines)+40);
					}			
				}	
			}
		}
		
	}
	public String addLinebreaks(String input, int maxLineLength) {
	    StringTokenizer tok = new StringTokenizer(input, " ");
	    StringBuilder output = new StringBuilder(input.length());
	    int lineLen = 0;
	    while (tok.hasMoreTokens()) {
	        String word = tok.nextToken();

	        if (lineLen + word.length() > maxLineLength) {
	            output.append("#");
	            lineLen = 0;
	        }
	        output.append(word);
	        lineLen += word.length();
	    }
	    return output.toString();
	}
}
