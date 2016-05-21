package view.mainMenu;

import java.awt.Graphics;

import view.GamePanelComponent;

@SuppressWarnings("serial")
public class ModeButtonPanel extends GamePanelComponent{

	public void paint(Graphics g){
		g.drawImage(this.bg, 0, 0,this);
	}


}
