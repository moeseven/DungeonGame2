package GUI;

import java.awt.Graphics;
import javax.swing.JComponent;

public class CharcterBuilderInfoComponent extends JComponent{
	private FrameCharacterBuilder fcb;
	public CharcterBuilderInfoComponent(FrameCharacterBuilder fcb) {
		this.fcb=fcb;
		this.setVisible(true);
	}
	protected void paintComponent(Graphics g){
		super.paintComponent(g);
		g.drawString("create your starting hero", 100, 10);
		g.drawString("hero class: "+fcb.getCb().getCharClass().getInfo(), 10, 50);
		g.drawString("hero race : "+fcb.getCb().getCharRace().getInfo(), 10, 64);
	}
}
