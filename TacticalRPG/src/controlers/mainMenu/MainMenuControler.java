package controlers.mainMenu;

import javax.swing.JPanel;

import controlers.GameStateControler;
import gameStates.menus.MainMenu;
import view.mainMenu.MainMenuPanel;

public class MainMenuControler extends GameStateControler{
	//vue et model
	private MainMenuPanel view;
	private MainMenu model;
	
	//observer du model
	private MainMenuObserver observer;
	
	//les listeners des bouton
	private ModeButtonListener modeListener;
	private LoadButtonListener loadListener;
	private ExitButtonListener exitListener;
	
	
	public MainMenuControler(MainMenu model){
		this.model = model;
		this.view = new MainMenuPanel();
		
		//creation de l'observer
		this.observer = new MainMenuObserver(this.view);
		
		//ajout de l'observer au model
		this.model.addObserver(this.observer);
		
		//création des listener
		this.modeListener = new ModeButtonListener(this.model);
		this.loadListener = new LoadButtonListener(this.model);
		this.exitListener = new ExitButtonListener(this.model);
		
		//association des boutons aux actions
		this.view.getModeButton().addMouseListener(this.modeListener);
		this.view.getLoadButton().addMouseListener(this.loadListener);
		this.view.getExitButton().addMouseListener(this.exitListener);
		
		//initialisation
		this.model.setCurrentButton(0);
	}

	@Override
	public JPanel getView() {
		// TODO Auto-generated method stub
		return this.view;
	}
}
