package controlers.saveMenu;

import java.awt.Color;
import java.util.Observable;
import java.util.Observer;

import gameStates.menus.SaveMenu;
import view.saveMenu.SaveMenuPanel;

public class SaveMenuObserver implements Observer{
	private SaveMenuPanel view;
	
	public SaveMenuObserver(SaveMenuPanel view){
		this.view = view;
	}
	@Override
	public void update(Observable arg0, Object arg1) {
		// TODO Auto-generated method stub
		SaveMenu model = (SaveMenu)arg0;
		int button = model.getCursor().getY();

		this.view.getSave1().setBackground(Color.LIGHT_GRAY);
		this.view.getSave2().setBackground(Color.LIGHT_GRAY);
		this.view.getSave3().setBackground(Color.LIGHT_GRAY);
		switch(button){
		case(0):
			this.view.getSave1().setBackground(Color.GREEN);
			break;
		case(1):
			this.view.getSave2().setBackground(Color.GREEN);
			break;
		case(2):
			this.view.getSave3().setBackground(Color.GREEN);
			break;
		}
	}
}
