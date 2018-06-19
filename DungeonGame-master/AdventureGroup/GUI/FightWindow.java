package GUI;

import java.awt.BorderLayout;

import javax.swing.JFrame;

import game.Game;

public class FightWindow extends JFrame{
	private Game game;
	private GuiFight guiFight;
	private RoomWindow rw;
	private GuiInventory guiRoom;
	public FightWindow(Game game, RoomWindow rw) {
		setTitle("Fight");
		this.game=game;
		this.rw=rw;
		
		this.setSize(1300, 650);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		if(this.game.getRoom().getFight()!=null) {
			guiFight=new GuiFight(this);
			add(guiFight,BorderLayout.CENTER);
		}
		setLocation(10, 10);
		this.setVisible(true);
		rw.setVisible(false);
	}
	public Game getGame() {
		return game;
	}
	public void setGame(Game game) {
		this.game = game;
	}
	public void windowswitch() {		
		rw=new RoomWindow(game);
		this.setVisible(false);
	}
}
