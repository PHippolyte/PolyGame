package controlers.teamMenu;

import java.util.Observable;
import java.util.Observer;

import gameStates.menus.TeamMenu;
import view.teamMenu.TeamMenuPanel;

public class TeamMenuObserver implements Observer{
	private TeamMenuPanel view;
	private boolean init;
	
	public TeamMenuObserver(TeamMenuPanel view){
		this.view = view;
		this.init = false;
	}
	@Override
	public void update(Observable arg0, Object arg1) {
		// TODO Auto-generated method stub
		TeamMenu model = (TeamMenu)arg0;
		
		if(this.init){
			this.view.getSelectSoldierPanel().addIcone(model.getIcones());
			this.view.getSelectSoldierPanel().addNameImage(model.getNames());
			this.setInit(false);
		}
		
		view.getSelectSoldierPanel().resetPanel();
		view.getSelectSoldierPanel().selectSoldierPanel(model.getCurrentButton());
		view.repaint();
	}
	
	public void setInit(boolean b){
		this.init = b;
	}
}
