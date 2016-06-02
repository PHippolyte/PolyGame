package view.ModeMenu;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import view.GamePanel;

@SuppressWarnings("serial")
public class ModeMenuPanel extends GamePanel{
	private ModePanel mode1;
	
	public ModeMenuPanel(){
		this.init = true;
		
		this.loadBackground("ressources/menu/modeMenu/Background.png");

		
		//ajout du layout
		this.setLayout(null);
		
		//creation des boutons
		this.mode1 = new ModePanel("ressources/menu/modeMenu/mode1.png");
		
		//config bouton
		this.mode1.setBounds(170, 220, 300, 100);
		
		BufferedImage modeBg = this.load("ressources/menu/modeMenu/modeBackground.png");
		BufferedImage modeSelect = this.load("ressources/menu/modeMenu/modeSelected.png");
		
		this.mode1.setBackgroundImage(modeBg);
		this.mode1.setBgSelected(modeSelect);
		
		//ajouts boutons
		this.add(this.mode1);
		
		this.init = false;
	}
	public void init(){
		this.init = true;
	}
	
	public void resetPanel(){
		this.mode1.setSelected(false);
	}
	
	public ModePanel getMode1(){
		return this.mode1;
	}
	
	public void paint(Graphics g){
		if (this.init){
			g.drawImage(this.bg, 0, 0,this.width,this.height, this);
			this.init = false;
		}
		this.mode1.paint(g);
	}
}
