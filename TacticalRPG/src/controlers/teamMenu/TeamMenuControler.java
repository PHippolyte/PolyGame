package controlers.teamMenu;

import javax.swing.JPanel;

import controlers.GameStateControler;
import gameStates.menus.TeamMenu;
import view.teamMenu.TeamMenuPanel;

public class TeamMenuControler extends GameStateControler{
	private TeamMenuPanel view;
	private TeamMenu model;
	
	//private TeamMenuObserver observer;
	
	public TeamMenuControler(TeamMenu model){
		this.model = model;
		this.view = new TeamMenuPanel();
		
		//this.observer = new HeroMenuObserver(this.view);
		//this.model.addObserver(this.observer);
	}

	@Override
	public JPanel getView() {
		// TODO Auto-generated method stub
		return this.view;
	}
}
