package view;

import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.JPanel;


@SuppressWarnings("serial")
public class GamePanelComponent extends JPanel{
	protected BufferedImage bg;

	protected int width;
	protected int height;

	protected GamePanelComponent(int width, int height){
		this.width = width;
		this.height = height;
	}

	public void loadBackground(String path){
		try {
			this.bg = ImageIO.read(new File(path));

		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
