package GUI.grafics;

import java.awt.Color;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import javax.imageio.ImageIO;

public class MyImageLoader {
	private BufferedImage image;
	private BufferedImage[] sprites= new BufferedImage[20*20];
	public MyImageLoader(){
		try {
			image= ImageIO.read(new File("./res/SpriteSheetBig.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		Color color;
		for(int h=0; h<image.getHeight();h++){
			for(int w=0; w<image.getWidth();w++){
				color=new Color(image.getRGB(w, h));
				if(color.getRed()>200&&color.getBlue()>200&&color.getGreen()<25){
					image.setRGB(w, h, 0);
				}
			}
		}
		for(int a=0; a<20; a++){
			for(int b=0; b<20; b++){
				sprites[a*20+b]=image.getSubimage(b*60, a*51, 60, 51);
			}
		}
	}
	public BufferedImage getImage(int a){
		return sprites[a];
	}
	public Image getScaledImage(int a,int s){
		return  sprites[a].getScaledInstance(60*s, 51*s, s);
	}
	
	//
	private void writeObject(ObjectOutputStream out) throws IOException {
        out.defaultWriteObject();
        out.writeInt(sprites.length); // how many images are serialized?
        for (BufferedImage eachImage : sprites) {
            ImageIO.write(eachImage, "png", out); // png is lossless
        }
    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        in.defaultReadObject();
        final int imageCount = in.readInt();
        sprites=new BufferedImage[20*20];        
        for (int i=0; i<imageCount; i++) {
        	sprites[imageCount]=ImageIO.read(in);
        }
    }
}
