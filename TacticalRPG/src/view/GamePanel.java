package view;

import java.awt.Dimension;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public abstract class GamePanel extends JPanel{
	protected int width;
	protected int height;

	protected BufferedImage bg;
	protected BufferedImage cursorUL;
	protected BufferedImage cursorUR;
	protected BufferedImage cursorDL;
	protected BufferedImage cursorDR;

	protected boolean init;
	
	public GamePanel(){
		this.width = 640;
		this.height = 480;
		this.setPreferredSize(new Dimension(this.width,this.height));
		this.loadCursor();
	}

	public int getWidth(){
		return this.width;
	}
	public int getHeight(){
		return this.height;
	}

	protected void loadBackground(String path){
		try {
			this.bg = ImageIO.read(new File(path));

		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	public abstract void init();
	
	protected BufferedImage load(String path){
		try {
			BufferedImage img = ImageIO.read(new File(path));
			return img;

		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}

	private void loadCursor(){
		try {
			this.cursorUL = ImageIO.read(new File("ressources/cursor/CursorUL.jpg"));
			this.cursorUR = ImageIO.read(new File("ressources/cursor/CursorUR.jpg"));
			this.cursorDL = ImageIO.read(new File("ressources/cursor/CursorDL.jpg"));
			this.cursorDR = ImageIO.read(new File("ressources/cursor/CursorDR.jpg"));

		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
