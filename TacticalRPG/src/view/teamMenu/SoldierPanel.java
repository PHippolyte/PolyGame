package view.teamMenu;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.awt.Color;

import view.GameComponent;

@SuppressWarnings("serial")
public class SoldierPanel extends GameComponent{
	private boolean selected;
	private BufferedImage soldierIcone;
	private int num;
	
	private BufferedImage bgSelected;
	
	public SoldierPanel(int num){
		this.selected = false;
		this.num = num;
	}
	
	public void paint(Graphics g){
		
		int dy = 0;
		if (this.soldierIcone != null){
			dy = (this.getHeight()-this.soldierIcone.getHeight())/2;
		}
		
		if (this.selected) g.drawImage(this.bgSelected, this.getX(), this.getY(), this.getWidth(), this.getHeight(),this); 
		else g.drawImage(this.bg, this.getX(), this.getY(), this.getWidth(), this.getHeight(),this); 

		g.drawImage(this.soldierIcone, this.getX()+15, this.getY()+dy, this);
	}
	
	public void setSelected(boolean b){
		this.selected = b;
	}
	
	public void setIcone(BufferedImage img){
		this.soldierIcone = img;
	}
	
	public int getNum(){
		return this.num;
	}
	
	public void setBgSelected(BufferedImage img){
		this.bgSelected = img;
	}
}
