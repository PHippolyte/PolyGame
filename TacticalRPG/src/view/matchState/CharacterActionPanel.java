package view.matchState;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

import gameStates.matchWindows.CharacterAction;
import view.GameComponent;

@SuppressWarnings("serial")
public class CharacterActionPanel extends GameComponent{
	private CharacterAction c;
	private BufferedImage cursor;
	
	public CharacterActionPanel(CharacterAction a){
		this.setBounds(0, 0, 120, 200);
		this.loadBackground("ressources/match/CharacterAction.png");
		this.c = a;
		
		try {
			this.cursor = ImageIO.read(new File("ressources/match/WindowCursor.png"));
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	public void paint(Graphics g){
		g.drawImage(this.bg, this.getX(), this.getY(), this);
		switch(c.getCurrentButton()){
		case(0):
			g.drawImage(this.cursor, this.getX()+9, this.getY()+51, this);
			break;
		case(1):
			g.drawImage(this.cursor, this.getX()+9, this.getY()+90, this);
			break;
		case(2):
			g.drawImage(this.cursor, this.getX()+9, this.getY()+128, this);
			break;
		case(3):
			g.drawImage(this.cursor, this.getX()+9, this.getY()+164, this);
			break;
		}
	}
	
	public void moveWindow(int x, int y){
		this.setBounds(x,y,this.getWidth(),this.getHeight());
	}
	
	public void setCharacterAction(CharacterAction a){
		this.c = a;
	}
}
