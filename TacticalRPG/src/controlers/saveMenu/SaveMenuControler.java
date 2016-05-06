package controlers.saveMenu;

import javax.swing.JPanel;

import controlers.GameStateControler;
import gameStates.menus.SaveMenu;
import view.saveMenu.SaveMenuPanel;

public class SaveMenuControler extends GameStateControler{
	private SaveMenuPanel view;
	private SaveMenu model;
	
	private SaveMenuObserver observer;
	
	public SaveMenuControler(SaveMenu model) {
		this.view = new SaveMenuPanel();
		this.model = model;
		// TODO Auto-generated constructor stub
		
		this.observer = new SaveMenuObserver(this.view);
		
		this.model.addObserver(this.observer);
	}

	@Override
	public JPanel getView() {
		// TODO Auto-generated method stub
		return this.view;
	}
}
