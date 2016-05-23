package gameStates.matchWindows;

import game.Cursor;
import gameStates.MatchState;
import gameObject.Character;

public class Idle extends StateMatch{

	public Idle(MatchState matchState, Cursor cursor) {
		super(matchState, cursor);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void initWindow() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doAction() {
		// TODO Auto-generated method stub
		Character c = this.matchState.getMatch().getMap().getTile(this.cursor.getX(), this.cursor.getY()).getCharacter();
		if (c != null){
			if (this.matchState.getMatch().getCurrentTeam().isAlly(c) && c.getDone() == false){
				this.matchState.getCharacterAction().setSelectedCharacter(c);
				this.matchState.getCharacterAction().initWindow();
				this.matchState.setCurrentState(CHARACTERACTION);
			} else {
				this.matchState.getDefaultAction().initWindow();
				this.matchState.setCurrentState(DEFAULTACTION);
			}
		} else {
			this.matchState.getDefaultAction().initWindow();
			this.matchState.setCurrentState(DEFAULTACTION);
		}
	}

	@Override
	public void cancel() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void moveCursorUp() {
		// TODO Auto-generated method stub
		if (this.cursor.getY() > 0){
			this.cursor.moveUp();
			if (this.cursor.getY() < this.matchState.getScreen().getY1()){
				this.matchState.getScreen().moveUp();
			}
		}
	}

	@Override
	public void moveCursorDown() {
		// TODO Auto-generated method stub
		if (this.cursor.getY() < this.matchState.getMatch().getMap().getNbRows()-1){
			this.cursor.moveDown();
			if (this.cursor.getY() > this.matchState.getScreen().getY2()){
				this.matchState.getScreen().moveDown();
			}
		}
	}

	@Override
	public void moveCursorRight() {
		// TODO Auto-generated method stub
		if (this.cursor.getX() < this.matchState.getMatch().getMap().getNbCols()-1){
			this.cursor.moveRight();
			if (this.cursor.getX() > this.matchState.getScreen().getX2()){
				this.matchState.getScreen().moveRight();
			}
		}
	}

	@Override
	public void moveCursorLeft() {
		// TODO Auto-generated method stub
		if (this.cursor.getX() > 0){
			this.cursor.moveLeft();
			if (this.cursor.getX() < this.matchState.getScreen().getX1()){
				this.matchState.getScreen().moveLeft();
			}
		}
	}
}
