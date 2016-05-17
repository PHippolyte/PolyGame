package gameStates.matchWindows;

import game.Cursor;
import gameStates.MatchState;

public class DefaultAction extends StateMatch{
	private int nbButton;
	private int currentButton;
	
	public DefaultAction(MatchState matchState, Cursor cursor) {
		super(matchState, cursor);
		// TODO Auto-generated constructor stub
		this.nbButton = 2;
		this.currentButton = 0;
	}

	@Override
	public void initWindow() {
		// TODO Auto-generated method stub
		//this.cursor.setPosition(0, 0);
		
	}
	
	public int getCurrentButton(){
		return this.currentButton;
	}

	@Override
	public void doAction() {
		// TODO Auto-generated method stub
		
	}

	public void cancel() {
		// TODO Auto-generated method stub
		this.matchState.setCurrentState(IDLE);
		
	}

	@Override
	public void moveCursorUp() {
		if (this.currentButton > 0){
			this.currentButton--;
		} else {
			this.currentButton = this.nbButton-1;
		}
	}


	@Override
	public void moveCursorDown() {
		// TODO Auto-generated method stub
		if (this.currentButton < this.nbButton-1){
			this.currentButton++;
		} else {
			this.currentButton = 0;
		}
		System.out.println(this.getCurrentButton());
	}


	@Override
	public void moveCursorRight() {
		// TODO Auto-generated method stub
		this.moveCursorDown();
	}


	@Override
	public void moveCursorLeft() {
		// TODO Auto-generated method stub
		this.moveCursorUp();
	}

}
