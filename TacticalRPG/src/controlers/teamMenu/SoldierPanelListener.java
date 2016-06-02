package controlers.teamMenu;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import gameStates.menus.TeamMenu;
import view.teamMenu.SoldierPanel;

public class SoldierPanelListener implements MouseListener{
	private TeamMenu model;
	private SoldierPanel view;
	
	public SoldierPanelListener(TeamMenu model, SoldierPanel view){
		this.model = model;
		this.view = view;
	}
	
	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		this.model.doAction();
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		System.out.println("Entered");
		this.model.setCurrentButton(this.view.getNum());
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
