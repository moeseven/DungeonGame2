package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.LayoutManager;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;

import GUI.grafics.StaticImageLoader;
import game.Game;
import tools.ClickableRectangle;
import tools.RectangleClicker;

public class MapWindow extends JFrame{
	protected Game game;
	private RoomWindow rw;
	public MapWindow(Game game, RoomWindow rw) {
		setTitle("Map");
		this.game=game;
		this.rw=rw;		
		GuiMap guiMap= new GuiMap(game);
		this.setSize(1300, 650);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		add(guiMap,BorderLayout.CENTER);
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
		if(rw.getGame().getRoom().isHasFight()){
			rw.setUpFightWindow();
			rw.setVisible(false);
		}else{
			rw.getGuiRoom().upadate();
			rw.setVisible(true);
		}
		this.setVisible(false);
	}	
	private class GuiMap extends JPanel{
		private RectangleClicker rc;
		private Game game;
		private int roomSquareSize;
		public GuiMap(Game gameU) {
			super();
			setVisible(true);
			this.game=gameU;
			roomSquareSize=54;
			super.addMouseListener(new MyMouseListener());
			rc=new RectangleClicker();
			for (int x = 0; x < game.getActiveAct().getRoomMap()[0].length; x++) {
				for (int y = 0;y < game.getActiveAct().getRoomMap()[1].length; y++) {
						rc.addRect(new ClickableRectangle(""+x+"/"+y,x*roomSquareSize,y*roomSquareSize,roomSquareSize-1,roomSquareSize-1) {
						@Override
						public void onClick() {		
							//move to clicked room if adjacent
							int currentRoomX=game.getRoom().getxCoordinate();
							int currentRoomY=game.getRoom().getyCoordinate();
							if(Math.abs(currentRoomX-getX()/roomSquareSize)+Math.abs(currentRoomY-getY()/roomSquareSize)<=1) {
								if (game.getActiveAct().getRoomMap()[getX()/roomSquareSize][getY()/roomSquareSize]!=null) {
									game.enterRoom(game.getActiveAct().getRoomMap()[getX()/roomSquareSize][getY()/roomSquareSize]);
									windowswitch();
									System.out.println("next Room!");
								}else {
									System.out.println("not a room here");
								}
							}																	
						}	
						@Override
						public void updateCaption() {
							// TODO Auto-generated method stub					
						}		
					});
				}				
			}
			
		}
		private class MyMouseListener extends MouseAdapter{
			public void mousePressed(MouseEvent e){	
				if(e.getButton()==1){
					rc.triggerClick(e.getX(), e.getY());
					rc.updateCaptions();
					revalidate();
					repaint();	
				}else{
					if (e.getButton()==3){
					}
				}
			} 
		}
		protected void paintComponent(Graphics g){
			super.paintComponent(g);	
			int currentRoomX=game.getRoom().getxCoordinate();
			int currentRoomY=game.getRoom().getyCoordinate();
			for(int i=0; i<rc.rectAngles.size();i++) {						
				if (game.getActiveAct().getRoomMap()[rc.rectAngles.get(i).getX()/roomSquareSize][rc.rectAngles.get(i).getY()/roomSquareSize]==null) {
					g.fillRect(rc.rectAngles.get(i).getX(), rc.rectAngles.get(i).getY(), rc.rectAngles.get(i).getLength(), rc.rectAngles.get(i).getHeight());
				}else {
					g.drawRect(rc.rectAngles.get(i).getX(), rc.rectAngles.get(i).getY(), rc.rectAngles.get(i).getLength(), rc.rectAngles.get(i).getHeight());
				}
				if (currentRoomX-rc.rectAngles.get(i).getX()/roomSquareSize==0&&currentRoomY-rc.rectAngles.get(i).getY()/roomSquareSize==0) {
					for (int j = 0; j < game.getPlayer().getHeroes().size(); j++) {
						g.drawImage(StaticImageLoader.getImage(game.getPlayer().getHeroes().get(j).getImageNumber()),rc.rectAngles.get(i).getX()+roomSquareSize/4-(j*18),rc.rectAngles.get(i).getY()-roomSquareSize/8,null);
					}					
					//g.fillOval(rc.rectAngles.get(i).getX(), rc.rectAngles.get(i).getY(), rc.rectAngles.get(i).getLength(), rc.rectAngles.get(i).getHeight());
				}
				g.setColor(Color.DARK_GRAY);
//				for(int a=0; a<rc.rectAngles.get(i).getCaption().size();a++) {
//					g.drawString(rc.rectAngles.get(i).getCaption().get(a), rc.rectAngles.get(i).getX()*roomSquareSize+3, rc.rectAngles.get(i).getY()*roomSquareSize+11+a*11);
//				
//				}
			}
		}
	}
	
}
