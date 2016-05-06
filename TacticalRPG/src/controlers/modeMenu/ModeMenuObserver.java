package controlers.modeMenu;

import java.awt.Color;
import java.util.Observable;
import java.util.Observer;

import gameStates.menus.ModeMenu;
import view.ModeMenu.ModeMenuPanel;

public class ModeMenuObserver implements Observer{
	private ModeMenuPanel view;
	
	public ModeMenuObserver(ModeMenuPanel view){
		this.view = view;
	}
	@Override
	public void update(Observable arg0, Object arg1) {
		// TODO Auto-generated method stub
		ModeMenu model = (ModeMenu)arg0;
		int button = model.getCursor().getY();
		
		
		this.view.getMode1().setBackground(Color.LIGHT_GRAY);
		switch(button){
		case(0):
			this.view.getMode1().setBackground(Color.GREEN);
		}
	}

}
