package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.util.LinkedList;

import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.LineBorder;

import gameEncounter.Card;
import gameEncounter.Hero;

public class HandComponent extends JComponent{
		private JPanel jp;
		private JScrollPane sp;
		private FightWindow fw;
		public HandComponent(FightWindow fw){
			this.fw=fw;
			setBorder(new LineBorder(Color.YELLOW));
			setLayout(new GridLayout());
			jp=new JPanel();
			for (int i=0;i<fw.getGame().getPlayer().getSelectedHero().getHand().size();i++){
				jp.add(new CardComponent(fw,fw.getGame().getPlayer().getSelectedHero().getHand().get(i)));
			}
			sp= new JScrollPane(jp);
			add(sp,BorderLayout.CENTER);
		}
		public void myUpdate() {
			jp=new JPanel();
			for (int i=0;i<fw.getGame().getPlayer().getSelectedHero().getHand().size();i++){
				jp.add(new CardComponent(fw,fw.getGame().getPlayer().getSelectedHero().getHand().get(i)));
			}
		}
}

