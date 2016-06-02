package gameStates;

public class Screen {
	private int x1;
	private int y1;
	private int x2;
	private int y2;
	
	public Screen(){
		this.x1 = 0;
		this.y1 = 0;
		this.x2 = 19;
		this.y2 = 14;
	}
	
	public boolean isInScreen(int x, int y){
		return (x >= this.x1 && x <= this.x2 && y >= this.y1 && y <= this.y2);
	}
	
	public void moveRight(){
		this.x1++;
		this.x2++;
	}
	public void moveLeft(){
		this.x1--;
		this.x2--;
	}
	public void moveUp(){
		this.y1--;
		this.y2--;	
	}
	public void moveDown(){
		this.y1++;
		this.y2++;
	}
	
	public int getX1() {
		return x1;
	}
	public void setX(int x) {
		this.x1 = x;
	}
	public int getY1() {
		return y1;
	}
	public void setY(int y) {
		this.y1 = y;
	}
	public int getX2() {
		return this.x2;
	}
	public void setX2(int x) {
		this.x2 = x;
	}
	public int getY2() {
		return this.y2;
	}
	public void setY2(int y) {
		this.y2 = y;
	}
	
	public int getWidth(){
		return (this.x2 - this.x1+1);
	}
	
	public int getHeight(){
		return (this.y2 - this.y1+1);
	}
	
	public void setPosition(int x, int y){
		int dx = x - this.x1;
		int dy = y - this.y1;
		this.x1 = x;
		this.x2 += dx;
		this.y1 = y;
		this.y2 += dy;
	}
	
	public void tryCenter(int x, int y, int maxX, int maxY){
		int aimedX = x-this.getWidth()/2;
		int aimedY = y-this.getHeight()/2;
		while (aimedX < 0) aimedX++;
		while (aimedY < 0) aimedY++;
		while (aimedX+this.getWidth() > maxX) aimedX--;
		while (aimedY+this.getHeight() > maxY) aimedY--;
		this.setPosition(aimedX, aimedY);
	}
	
	
	
}
