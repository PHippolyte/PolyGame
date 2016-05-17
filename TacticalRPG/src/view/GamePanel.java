package view;

import java.awt.Dimension;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public abstract class GamePanel extends JPanel{
	protected int width;
	protected int height;
	
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

}
