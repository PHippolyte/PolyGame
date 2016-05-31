package controlers.saveMenu;

import controlers.GameStateControler;
import gameStates.menus.SaveMenu;
import view.GamePanel;
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
	public GamePanel getView() {
		// TODO Auto-generated method stub
		return this.view;
	}
	
	public void init(){
		
	}

	@Override
	public void updateObserver() {
		// TODO Auto-generated method stub
		
	}
}
