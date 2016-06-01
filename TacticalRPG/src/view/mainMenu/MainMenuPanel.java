package view.mainMenu;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import view.GameElementPanel;
import view.GamePanel;

@SuppressWarnings("serial")
public class MainMenuPanel extends GamePanel{
	private GameElementPanel modeButton;
	private GameElementPanel loadButton;
	private GameElementPanel exitButton;

	public MainMenuPanel(){
		this.init = true;
		
		//ajout du layout
		this.setLayout(null);

		//creation des boutons
		this.modeButton = new ModeButtonPanel("ressources/menu/mainMenu/modeButton.png");
		this.loadButton = new ModeButtonPanel("ressources/menu/mainMenu/loadButton.png");
		this.exitButton = new ModeButtonPanel("ressources/menu/mainMenu/exitButton.png");
		
		this.modeButton.setBounds(220, 60, 200, 80);
		this.loadButton.setBounds(220, 200, 200, 80);
		this.exitButton.setBounds(220, 340, 200, 80);

		//chargement des images
		BufferedImage buttonBg = this.load("ressources/menu/mainMenu/buttonBackground.png");
		BufferedImage buttonSelectBg = this.load("ressources/menu/mainMenu/buttonSelected.png");
		
		this.modeButton.setBackgroundImage(buttonBg);
		this.loadButton.setBackgroundImage(buttonBg);
		this.exitButton.setBackgroundImage(buttonBg);
		
		this.modeButton.setBgSelected(buttonSelectBg);
		this.loadButton.setBgSelected(buttonSelectBg);
		this.exitButton.setBgSelected(buttonSelectBg);

		//ajouts des composents
		this.add(this.modeButton);
		this.add(this.loadButton);
		this.add(this.exitButton);
		
		this.init = false;
	}
	public void paint(Graphics g){
		if (this.init){
			g.drawImage(this.bg, 0, 0, this.width, this.height, this);
			this.init = false;
		}

		this.modeButton.paint(g);
		this.loadButton.paint(g);
		this.exitButton.paint(g);
	}
	
	public void init(){
		this.init = true;
	}
	
	public void resetPanel(){
		this.modeButton.setSelected(false);
		this.loadButton.setSelected(false);
		this.exitButton.setSelected(false);
	}

	public GameElementPanel getModeButton() {
		return modeButton;
	}

	public GameElementPanel getLoadButton() {
		return loadButton;
	}

	public GameElementPanel getExitButton() {
		return exitButton;
	}
}
