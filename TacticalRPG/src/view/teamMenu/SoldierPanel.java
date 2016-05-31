package view.teamMenu;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import view.GameComponent;

@SuppressWarnings("serial")
public class SoldierPanel extends GameComponent{
	private boolean selected;
	private BufferedImage soldierIcone;
	private BufferedImage soldierName;
	private int num;
	
	private BufferedImage bgSelected;
	
	public SoldierPanel(int num){
		this.selected = false;
		this.num = num;
	}
	
	public void paint(Graphics g){
		
		int dy = 0;
		int dy2 = 0;
		
		//CENTRAGE DES IMAGES
		if (this.soldierIcone != null){
			dy = (this.getHeight()-this.soldierIcone.getHeight())/2;
		}
		if (this.soldierName != null){
			dy2 = (this.getHeight()-this.soldierName.getHeight())/2;
		}
		
		//SELECTION DU BACKGROUND
		if (this.selected) g.drawImage(this.bgSelected, this.getX(), this.getY(), this.getWidth(), this.getHeight(),this); 
		else g.drawImage(this.bg, this.getX(), this.getY(), this.getWidth(), this.getHeight(),this); 

		//DESSIN DES ICONE PERSONNAGE ET LEURS NOMS
		g.drawImage(this.soldierIcone, this.getX()+15, this.getY()+dy, this);
		g.drawImage(this.soldierName, this.getX()+this.soldierIcone.getWidth()+30, this.getY()+dy2, this);
	}
	
	public void setSelected(boolean b){
		this.selected = b;
	}
	
	public void setIcone(BufferedImage img){
		this.soldierIcone = img;
	}
	
	public void setNameImage(BufferedImage img){
		this.soldierName = img;
	}
	
	public int getNum(){
		return this.num;
	}
	
	public void setBgSelected(BufferedImage img){
		this.bgSelected = img;
	}
}
