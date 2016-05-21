package view.mainMenu;

import java.awt.Graphics;

import javax.swing.JPanel;

import view.GamePanel;
import view.GamePanelComponent;

@SuppressWarnings("serial")
public class MainMenuPanel extends GamePanel{
	private GamePanelComponent modeButton;
	private GamePanelComponent loadButton;
	private GamePanelComponent exitButton;

	private Boolean paintCursor;

	public MainMenuPanel(){
		this.init = true;
		
		this.loadBackground("ressources/menu/mainMenu/Background.jpg");
		//this.paintCursor = true;

		//ajout du layout
		this.setLayout(null);

		//creation des boutons
		this.modeButton = new ModeButtonPanel();
		this.loadButton = new ModeButtonPanel();
		this.exitButton = new ModeButtonPanel();
		
		this.modeButton.setBounds(220, 60, 200, 80);
		this.loadButton.setBounds(220, 200, 200, 80);
		this.exitButton.setBounds(220, 340, 200, 80);

		//config des boutons
		this.modeButton.loadBackground("ressources/menu/mainMenu/NewGame.jpg");
		this.loadButton.loadBackground("ressources/menu/mainMenu/LoadGame.jpg");
		this.exitButton.loadBackground("ressources/menu/mainMenu/ExitGame.jpg");

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
			System.out.println("Done");
		}

		this.modeButton.repaint();
		this.loadButton.repaint();
		this.exitButton.repaint();
	}
	
	public void init(){
		this.init = true;
	}

	public JPanel getModeButton() {
		return modeButton;
	}

	public JPanel getLoadButton() {
		return loadButton;
	}

	public JPanel getExitButton() {
		return exitButton;
	}
}
