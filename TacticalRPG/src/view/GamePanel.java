package view;

import java.awt.Dimension;

@SuppressWarnings("serial")
public abstract class GamePanel extends GameComponent{
	protected int width;
	protected int height;

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
	
	public abstract void init();
}
