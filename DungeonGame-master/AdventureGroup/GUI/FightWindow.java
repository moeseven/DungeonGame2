package GUI;

import java.awt.BorderLayout;

import javax.swing.JFrame;

import game.Game;

public class FightWindow extends JFrame{
	private Game game;
	private GuiFight guiFight;
	private GameWindow gw;
	private GuiRoom guiRoom;
	public FightWindow(Game game, GameWindow gw) {
		this.game=game;
		this.gw=gw;
		this.setVisible(true);
		this.setSize(1300, 650);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		if(this.game.getRoom().getFight()!=null) {
			guiFight=new GuiFight(this);
			add(guiFight,BorderLayout.CENTER);
		}
		setLocation(10, 10);
		
	}
	public Game getGame() {
		return game;
	}
	public void setGame(Game game) {
		this.game = game;
	}
	public void windowswitch() {
		gw.setVisible(true);
		this.setVisible(false);
	}
}
