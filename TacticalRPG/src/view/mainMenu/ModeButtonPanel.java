package view.mainMenu;

import java.awt.Graphics;

import view.GameComponent;

@SuppressWarnings("serial")
public class ModeButtonPanel extends GameComponent{

	public void paint(Graphics g){
		g.drawImage(this.bg, this.getX(), this.getY(),this);
	}


}
