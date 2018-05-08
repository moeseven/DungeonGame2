package GUI;

import java.awt.BorderLayout;

import javax.swing.JFrame;

import game.Game;

public class GameWindow extends JFrame{
	private Game game;
	private GuiFight guiFight;
	private GuiRoom guiRoom;
	public GameWindow(Game game) {
		this.game=game;
		this.setVisible(true);
		this.setSize(1300, 650);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		if(this.game.getRoom().getFight()!=null) {
			guiFight=new GuiFight(this);
			add(guiFight,BorderLayout.CENTER);
		}else {//show right gui not handled
			guiRoom=new GuiRoom(this);
		}
		setLocation(10, 10);
		
	}
	public Game getGame() {
		return game;
	}
	public void setGame(Game game) {
		this.game = game;
	}
	public void updateHand() {
		guiFight.getHc().setHandComponent(new HandComponent(this,game.getHeroes().getFirst()));
	}
}
