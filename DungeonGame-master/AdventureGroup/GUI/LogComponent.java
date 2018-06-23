package GUI;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;

import tools.MyLog;

public class LogComponent extends JComponent{
		private JTextPane text;
		private JScrollPane scroll;
		private JPanel jp;
		private MyLog combatLog;
		public LogComponent(MyLog combatLog) {
			this.combatLog=combatLog;
			setLayout(new BorderLayout());
			text=new JTextPane();	
			text.setText(combatLog.getLog());
			text.setVisible(true);
			scroll = new JScrollPane(text);		
			this.add(scroll,BorderLayout.CENTER);
			super.setPreferredSize(new Dimension(300,220));
			setVisible(true);
	}
}
