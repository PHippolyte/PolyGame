package gameObject;

import java.awt.image.BufferedImage;

public abstract class GameObject {
	protected int x;
	protected int y;
	private BufferedImage img;
	
	public GameObject(int x, int y){
		this.setPosition(x,y);
	}
	
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	
	public void setPosition(int x, int y){
		this.setX(x);
		this.setY(y);
	}
	
	public BufferedImage getImage(){
		return this.img;
	}
	
	//public abstract void loadImage();
}
