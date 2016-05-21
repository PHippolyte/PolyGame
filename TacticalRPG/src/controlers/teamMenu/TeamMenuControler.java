package controlers.teamMenu;

import controlers.GameStateControler;
import gameStates.menus.TeamMenu;
import view.GamePanel;
import view.teamMenu.TeamMenuPanel;

public class TeamMenuControler extends GameStateControler{
	private TeamMenuPanel view;
	private TeamMenu model;
	
	private teamMenuObserver observer;
	//private TeamMenuObserver observer;
	
	public TeamMenuControler(TeamMenu model){
		this.model = model;
		this.view = new TeamMenuPanel();
		
		this.observer = new teamMenuObserver(this.view);
		this.model.addObserver(this.observer);
	}

	@Override
	public GamePanel getView() {
		// TODO Auto-generated method stub
		return this.view;
	}
}
