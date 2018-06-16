package GUI;

import java.awt.BorderLayout;
import java.awt.Graphics;
import javax.swing.JComponent;
import javax.swing.JTextField;

public class CharcterBuilderInfoComponent extends JComponent{
	private FrameCharacterBuilder fcb;
	private JTextField tf;
	public CharcterBuilderInfoComponent(FrameCharacterBuilder fcb) {
		this.fcb=fcb;
		this.setLayout(new BorderLayout());
		tf=new JTextField();
		tf.setText("type name here");
		this.add(tf, BorderLayout.NORTH);
		this.setVisible(true);
	}
	protected void paintComponent(Graphics g){
		super.paintComponent(g);
		g.drawString("create your starting hero", 100, 10);
		g.drawString("hero class: "+fcb.getCb().getCharClass().getInfo(), 10, 50);
		g.drawString("hero race : "+fcb.getCb().getCharRace().getInfo(), 10, 64);
	}
	public JTextField getTf() {
		return tf;
	}
	public void setTf(JTextField tf) {
		this.tf = tf;
	}
	
}
