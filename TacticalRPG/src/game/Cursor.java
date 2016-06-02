package game;

import gameObject.GameObject;

public class Cursor extends GameObject{
	
	public Cursor(int x, int y) {
		super(x, y);
		this.load("ressources/cursor/Cursor.png");
	}
	public void moveRight(){
		this.x++;
	}
	public void moveLeft(){
		this.x--;
	}
	public void moveUp(){
		this.y--;
	}
	public void moveDown(){
		this.y++;
	}
	
	public String toString(){
		return "Cursor : ("+this.x+", "+this.y+")";
	}
}
