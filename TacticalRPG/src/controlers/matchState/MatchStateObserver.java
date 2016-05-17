package controlers.matchState;

import java.util.Observable;
import java.util.Observer;

import gameStates.MatchState;
import gameStates.MatchStateConstant;
import view.matchState.MatchPanel;

public class MatchStateObserver implements Observer, MatchStateConstant{
	private MatchPanel view;
	
	public MatchStateObserver(MatchPanel view){
		this.view = view;
	}
	
	
	@Override
	public void update(Observable arg0, Object arg1) {
		// TODO Auto-generated method stub
		MatchState model = (MatchState)arg0;
		switch (model.getCurrentIntState()){
		case(INIT):
			this.view.init();
			this.view.drawBasicImage();
			break;
			
		case(IDLE):
			this.view.drawBasicImage();
			break;
			
		case(CHARACTERACTION):
			this.view.drawBasicImage();
			this.view.drawCharacterAction();
			break;
			
		case(ATTACK):
			this.view.drawBasicImage();
			this.view.drawAttack();
			break;
		
		case(MOVE):
			this.view.drawBasicImage();
			this.view.drawMove();
			break;
			
		case(DEFAULTACTION):
			this.view.drawBasicImage();
			this.view.drawDefaultAction();
			break;
	}
		this.view.repaint();
	}
	
}
