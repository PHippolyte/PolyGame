package view.mainMenu;

import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import view.GamePanel;
import view.GamePanelComponent;

@SuppressWarnings("serial")
public class MainMenuPanel extends GamePanel{
	private GamePanelComponent modeButton;
	private GamePanelComponent loadButton;
	private GamePanelComponent exitButton;

	private GridBagLayout layout;
	private GridBagConstraints constraints;

	private Boolean paintBg;
	private Boolean paintCursor;

	public MainMenuPanel(){
		this.loadBackground("ressources/menu/mainMenu/Background.jpg");
		this.paintBg = true;
		//this.paintCursor = true;

		//ajout du layout
		this.layout = new GridBagLayout();
		this.setLayout(this.layout);

		//contraintes du layout
		this.constraints = new GridBagConstraints();
		this.constraints.gridx = 1;
		this.constraints.insets.bottom = 30;

		//creation des boutons
		this.modeButton = new ModeButtonPanel(200,80);
		this.loadButton = new ModeButtonPanel(200,80);
		this.exitButton = new ModeButtonPanel(200,80);

		//config des boutons
		this.modeButton.loadBackground("ressources/menu/mainMenu/NewGame.jpg");
		this.loadButton.loadBackground("ressources/menu/mainMenu/LoadGame.jpg");
		this.exitButton.loadBackground("ressources/menu/mainMenu/ExitGame.jpg");

		this.layout.setConstraints(this.modeButton, this.constraints);
		this.layout.setConstraints(this.loadButton, this.constraints);
		this.layout.setConstraints(this.exitButton, this.constraints);

		//ajouts des composents
		this.add(this.modeButton);
		this.add(this.loadButton);
		this.add(this.exitButton);
	}
	public void paint(Graphics g){
		if (this.paintBg){
			g.drawImage(this.bg, 0, 0, this.width, this.height, this);
			this.paintBg = false;
		}

		//this.repaintComponent();
	}

	public void repaintComponent(){
		this.modeButton.repaint();
		this.loadButton.repaint();
		this.exitButton.repaint();
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
