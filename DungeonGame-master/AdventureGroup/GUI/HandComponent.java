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
		private Hero hero;
		private JPanel jp;
		private JScrollPane sp;
		private FightWindow fw;
		public HandComponent(FightWindow fw,Hero hero){
			this.fw=fw;
			this.hero=hero;
			setBorder(new LineBorder(Color.YELLOW));
			setLayout(new GridLayout());
			jp=new JPanel();
			for (int i=0;i<hero.getHand().size();i++){
				jp.add(new CardComponent(fw,hero.getHand().get(i)));
			}
			sp= new JScrollPane(jp);
			add(sp,BorderLayout.CENTER);
		}
		public void myUpdate() {
			jp=new JPanel();
			for (int i=0;i<hero.getHand().size();i++){
				jp.add(new CardComponent(fw,hero.getHand().get(i)));
			}
		}
}

