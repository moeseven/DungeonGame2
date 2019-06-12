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
import game.Room;
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
						public void onClick(MouseEvent e) {		
							//move to clicked room if adjacent
							int currentRoomX=game.getRoom().getxCoordinate();
							int currentRoomY=game.getRoom().getyCoordinate();
							Room room=game.getActiveAct().getRoomMap()[getX()/roomSquareSize][getY()/roomSquareSize];
							int distance=Math.abs(currentRoomX-getX()/roomSquareSize)+Math.abs(currentRoomY-getY()/roomSquareSize);
							if(distance==1 || (game.getPlayer().hasCheat()&&distance>0)) {
								if (room!=null) {
									if (room.isVisited()&&!room.isHasFight()) {
										game.enterRoom(room);
									}else {
										game.enterRoom(room);
										windowswitch();
									}											
								}else {
									//solid walls
								}
							}else if (distance==0) {
								windowswitch();
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
					rc.triggerClick(e);
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
			g.setColor(Color.BLACK);
			int currentRoomX=game.getRoom().getxCoordinate();
			int currentRoomY=game.getRoom().getyCoordinate();
			for(int i=0; i<rc.rectAngles.size();i++) {						
				if (game.getActiveAct().getRoomMap()[rc.rectAngles.get(i).getX()/roomSquareSize][rc.rectAngles.get(i).getY()/roomSquareSize]==null) {
					g.fillRect(rc.rectAngles.get(i).getX(), rc.rectAngles.get(i).getY(), rc.rectAngles.get(i).getLength(), rc.rectAngles.get(i).getHeight());
				}else if (!game.getActiveAct().getRoomMap()[rc.rectAngles.get(i).getX()/roomSquareSize][rc.rectAngles.get(i).getY()/roomSquareSize].isVisited()) {					
					g.setColor(Color.GRAY);
					g.fillRect(rc.rectAngles.get(i).getX(), rc.rectAngles.get(i).getY(), rc.rectAngles.get(i).getLength(), rc.rectAngles.get(i).getHeight());
					g.setColor(Color.BLACK);
				}else {
					if (game.getActiveAct().getRoomMap()[rc.rectAngles.get(i).getX()/roomSquareSize][rc.rectAngles.get(i).getY()/roomSquareSize]==game.getTown()) {
						g.setColor(new Color(230, 168, 32));
						g.fillRect(rc.rectAngles.get(i).getX(), rc.rectAngles.get(i).getY(), rc.rectAngles.get(i).getLength(), rc.rectAngles.get(i).getHeight());
						g.setColor(Color.BLACK);
					}
					if (game.getActiveAct().getRoomMap()[rc.rectAngles.get(i).getX()/roomSquareSize][rc.rectAngles.get(i).getY()/roomSquareSize].isHasFight()) {
						g.setColor(Color.red);
						g.fillRect(rc.rectAngles.get(i).getX(), rc.rectAngles.get(i).getY(), rc.rectAngles.get(i).getLength(), rc.rectAngles.get(i).getHeight());
						g.setColor(Color.BLACK);
					}
					g.drawRect(rc.rectAngles.get(i).getX(), rc.rectAngles.get(i).getY(), rc.rectAngles.get(i).getLength(), rc.rectAngles.get(i).getHeight());
				}
				if (currentRoomX-rc.rectAngles.get(i).getX()/roomSquareSize==0&&currentRoomY-rc.rectAngles.get(i).getY()/roomSquareSize==0) {
					for (int j = 0; j < game.getPlayer().getHeroes().size(); j++) {
						g.drawImage(StaticImageLoader.getImage(game.getPlayer().getHeroes().get(j).getImageNumber()),rc.rectAngles.get(i).getX()+roomSquareSize/4-(j*18),rc.rectAngles.get(i).getY()-roomSquareSize/8,null);
					}					
					//g.fillOval(rc.rectAngles.get(i).getX(), rc.rectAngles.get(i).getY(), rc.rectAngles.get(i).getLength(), rc.rectAngles.get(i).getHeight());
				}
				
//				for(int a=0; a<rc.rectAngles.get(i).getCaption().size();a++) {
//					g.drawString(rc.rectAngles.get(i).getCaption().get(a), rc.rectAngles.get(i).getX()*roomSquareSize+3, rc.rectAngles.get(i).getY()*roomSquareSize+11+a*11);
//				
//				}
			}
		}
	}
	
}
