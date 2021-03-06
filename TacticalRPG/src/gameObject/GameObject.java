package gameObject;

import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

public abstract class GameObject {
	protected int x;
	protected int y;
	protected BufferedImage sprite;
	
	public GameObject(){
		this.x = 0;
		this.y = 0;
		this.sprite = null;
	}
	
	public GameObject(int x, int y){
		this.setPosition(x,y);
		this.sprite = null;
	}
	
	public void load(String path){
		try {
			this.sprite = ImageIO.read(new File(path));
			
		} catch (Exception e) {
			
			System.out.println("Erreur lecture fichier : "+path);
		}
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
		return this.sprite;
	}
}
