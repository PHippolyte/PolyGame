package controlers.mainMenu;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import gameStates.menus.MainMenu;

public class LoadButtonListener implements MouseListener {
private MainMenu model;
	
	public LoadButtonListener(MainMenu model){
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
		this.model.setCurrentButton(1);
		
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
