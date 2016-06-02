package gameStates.matchWindows;


import game.Cursor;
import gameStates.MatchState;
import gameStates.MatchStateConstant;

public abstract class StateMatch implements MatchStateConstant{
	protected MatchState matchState;
	protected Cursor cursor;
	
	public StateMatch(MatchState matchState, Cursor cursor){
		this.matchState = matchState;
		this.cursor = cursor;
		this.initWindow();
	}
	
	public abstract void initWindow();
	public abstract void doAction();
	public abstract void cancel();
	
	public abstract void moveCursorUp();
	public abstract void moveCursorDown();
	public abstract void moveCursorRight();
	public abstract void moveCursorLeft();
}
