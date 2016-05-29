package view;

import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class GameComponent extends JPanel{
	protected BufferedImage bg;
	
	public void loadBackground(String path){
		try {
			this.bg = ImageIO.read(new File(path));

		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	public BufferedImage load(String path){
		try {
			BufferedImage img = ImageIO.read(new File(path));
			return img;

		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}
	
	public void setBackgroundImage(BufferedImage img){
		this.bg = img;
	}
}
