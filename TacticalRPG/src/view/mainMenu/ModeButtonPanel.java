package view.mainMenu;

import java.awt.Dimension;
import java.awt.Graphics;

import view.GamePanelComponent;

@SuppressWarnings("serial")
public class ModeButtonPanel extends GamePanelComponent{
	private boolean paintCursor;
	
	protected ModeButtonPanel(int width, int height) {
		super(width, height);
		this.setPreferredSize(new Dimension(this.width,this.height));
	}

	public void paint(Graphics g){
		g.drawImage(this.bg, 0, 0, this.width, this.height, this);
	}


}
