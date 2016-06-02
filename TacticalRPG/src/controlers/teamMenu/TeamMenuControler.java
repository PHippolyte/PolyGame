package controlers.teamMenu;

import controlers.GameStateControler;
import gameStates.menus.TeamMenu;
import view.GamePanel;
import view.teamMenu.SoldierPanel;
import view.teamMenu.TeamMenuPanel;

public class TeamMenuControler extends GameStateControler{
	private TeamMenuPanel view;
	private TeamMenu model;
	
	private TeamMenuObserver observer;
	
	public TeamMenuControler(TeamMenu model){
		this.model = model;
		this.view = new TeamMenuPanel(model.getNbButton());
		
		this.observer = new TeamMenuObserver(this.view);
		this.model.addObserver(this.observer);
		
		for (int i=0; i<this.model.getNbButton(); i++){
			SoldierPanel panel = this.view.getSelectSoldierPanel().getSoldierPanel(i);
			panel.addMouseListener(new SoldierPanelListener(this.model,panel));
		}
	}

	@Override
	public GamePanel getView() {
		// TODO Auto-generated method stub
		return this.view;
	}
	
	public void updateObserver(){
		this.observer.update(model, null);
	}
	
	public void init(){
		this.observer.setInit(true);
	}
}
