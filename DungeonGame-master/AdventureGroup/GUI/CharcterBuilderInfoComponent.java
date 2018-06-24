package GUI;

import java.awt.BorderLayout;
import java.awt.Graphics;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.JTextField;

import gameEncounter.GameEquations;
import gameEncounter.Weapon;

public class CharcterBuilderInfoComponent extends JComponent{
	private FrameCharacterBuilder fcb;
	private JTextField tf;
	private JPanel jp;
	public CharcterBuilderInfoComponent(FrameCharacterBuilder fcb) {
		this.fcb=fcb;
		this.setLayout(new BorderLayout());
		tf=new JTextField();
		tf.setText("type name here");
		this.add(tf, BorderLayout.NORTH);
		jp= new JPanel();
		jp.add(new HeroStatsPaintComponent(fcb.getCb().getGame().getPlayer()));
		this.add(jp,BorderLayout.CENTER);
		this.setVisible(true);
	}
	public JTextField getTf() {
		return tf;
	}
	public void setTf(JTextField tf) {
		this.tf = tf;
	}
	
}
