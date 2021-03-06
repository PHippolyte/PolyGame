package controlers.modeMenu;

import controlers.GameStateControler;
import gameStates.menus.ModeMenu;
import view.GamePanel;
import view.ModeMenu.ModeMenuPanel;

public class ModeMenuControler extends GameStateControler{
	private ModeMenuPanel view;
	private ModeMenu model;
	
	private ModeMenuObserver observer;
	
	public ModeMenuControler(ModeMenu model) {
		this.view = new ModeMenuPanel();
		this.model = model;
		// TODO Auto-generated constructor stub
		
		this.observer = new ModeMenuObserver(this.view);
		
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
