package GUI;

import java.awt.BorderLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import game.CharacterBuilder;

public class FrameCharacterBuilder extends JFrame{
	private JPanel jp01;
	private JPanel jpDraw;
	private JButton buttonNextRace;
	private JButton buttonNextClass;
	private JButton buttonCreateHero;
	private CharacterBuilder cb;
	protected FrameCharacterBuilder fcb;
	private CharcterBuilderInfoComponent cbi;
	protected MainMenu mainMenu;
	public FrameCharacterBuilder(CharacterBuilder cb, MainMenu mm) {
		this.cb=cb;
		mainMenu=mm;
		fcb=this;
		this.setTitle("character builder");
		cbi=new CharcterBuilderInfoComponent(this);
		setSize(650,500);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setLayout(new BorderLayout());
		
		jp01= new JPanel();
		buttonNextRace= new JButton("race");
		buttonNextRace.addMouseListener(new ButtonRaceListener());
		jp01.add(buttonNextRace);
		buttonNextClass= new JButton("class");
		buttonNextClass.addMouseListener(new ButtonClassListener());
		jp01.add(buttonNextClass);
		buttonCreateHero= new JButton("create");
		buttonCreateHero.addMouseListener(new ButtonCreateHeroListener());
		jp01.add(buttonCreateHero);
		add(jp01, BorderLayout.SOUTH);		
		jpDraw= new JPanel();
		jpDraw.setLayout(new BorderLayout());
		jpDraw.add(cbi, BorderLayout.CENTER);
		add(jpDraw, BorderLayout.CENTER);
		setVisible(true);
	}
	private class ButtonRaceListener extends MouseAdapter{
		public void mousePressed(MouseEvent e){
			cb.scrollThroughCharRaces();
			cb.updateHero(cbi.getTf().getText());
			cbi.repaint();
		} 
	}
	private class ButtonClassListener extends MouseAdapter{
		public void mousePressed(MouseEvent e){
			cb.scrollThroughCharClasses();
			cb.updateHero(cbi.getTf().getText());
			cbi.repaint();
		} 
	}
	private class ButtonCreateHeroListener extends MouseAdapter{
		public void mousePressed(MouseEvent e){
			//TODO set up game window and start game
			cb.createHero(cbi.getTf().getText());
			fcb.setVisible(false);			
			cb.getGame().enterRoom(cb.getGame().getRoom());	
			mainMenu.rw=new RoomWindow(cb.getGame(),mainMenu);
		} 
	}
	public CharacterBuilder getCb() {
		return cb;
	}
	public void setCb(CharacterBuilder cb) {
		this.cb = cb;
	}
	

}
