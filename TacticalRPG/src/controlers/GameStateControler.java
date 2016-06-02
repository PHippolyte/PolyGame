package controlers;

import view.GamePanel;

public abstract class GameStateControler {	
	protected KeyBoardListener keyBoard;
	
	public abstract GamePanel getView();
	public abstract void init();
	public abstract void updateObserver();
	
	
}
