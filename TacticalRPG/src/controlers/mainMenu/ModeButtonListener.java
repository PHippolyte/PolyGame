package controlers.mainMenu;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import gameStates.menus.MainMenu;

public class ModeButtonListener implements MouseListener {
	private MainMenu model;
	
	public ModeButtonListener(MainMenu model){
		this.model = model;
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		this.model.doAction();
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		this.model.setCurrentButton(0);
		
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
