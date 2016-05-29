package controlers.teamMenu;

import java.util.Observable;
import java.util.Observer;

import gameStates.menus.TeamMenu;
import view.teamMenu.TeamMenuPanel;

public class TeamMenuObserver implements Observer{
	private TeamMenuPanel view;
	
	public TeamMenuObserver(TeamMenuPanel view){
		this.view = view;
	}
	@Override
	public void update(Observable arg0, Object arg1) {
		// TODO Auto-generated method stub
		TeamMenu model = (TeamMenu)arg0;
		this.view.getSelectSoldierPanel().addIcone(model.getIcones());
		view.getSelectSoldierPanel().resetPanel();
		view.getSelectSoldierPanel().selectSoldierPanel(model.getCurrentButton());
		view.repaint();
	}
}
