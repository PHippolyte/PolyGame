package view;

import java.awt.Dimension;
import java.awt.color.ColorSpace;
import java.awt.image.BufferedImage;
import java.awt.image.ColorConvertOp;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public abstract class GamePanel extends JPanel{
	protected int width;
	protected int height;

	protected BufferedImage bg;

	protected boolean init;
	
	public GamePanel(){
		this.width = 640;
		this.height = 480;
		this.setPreferredSize(new Dimension(this.width,this.height));
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
	
	protected BufferedImage grayRender(BufferedImage img){
		ColorConvertOp op = new ColorConvertOp(ColorSpace.getInstance(ColorSpace.CS_GRAY),null);
		return op.filter(img, null);
	}
}
