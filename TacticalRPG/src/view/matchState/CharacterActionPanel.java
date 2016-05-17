package view.matchState;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

import gameStates.matchWindows.CharacterAction;

@SuppressWarnings("serial")
public class CharacterActionPanel extends JPanel{
	private CharacterAction c;
	private int buttonWidth;
	private int buttonHeight;
	
	public CharacterActionPanel(CharacterAction a){
		this.setBounds(0, 0, 100, 100);
		this.buttonWidth = 80;
		this.buttonWidth = 80;
		this.c = a;
	}
	
	public void paint(Graphics g){
		g.setColor(Color.BLUE);
		g.fillRect(this.getX(), this.getY(), this.getWidth(), this.getHeight());
		g.setColor(Color.GREEN);
		g.fillRect(this.getX()+(this.getWidth()/6),this.getY()+(this.getHeight()/6),this.buttonWidth,this.buttonHeight);
	}
	
	public void moveWindow(int x, int y){
		this.setBounds(x,y,this.getWidth(),this.getHeight());
	}
	
	public void setCharacterAction(CharacterAction a){
		this.c = a;
	}
}
