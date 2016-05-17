package controlers.matchState;

import javax.swing.JPanel;

import controlers.GameStateControler;
import gameStates.MatchState;
import view.matchState.MatchPanel;

public class MatchStateControler extends GameStateControler{
	private MatchPanel view;
	private MatchState model;
	
	private	MatchStateObserver observer;
	
	public MatchStateControler(MatchState model){
		this.model = model;
		this.view = new MatchPanel(this.model);
		
		this.observer = new MatchStateObserver(this.view);
		this.model.addObserver(this.observer);
	}

	public JPanel getView() {
		// TODO Auto-generated method stub
		return this.view;
	}
}
