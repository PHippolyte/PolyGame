package gameStates.matchWindows;

import game.Cursor;
import gameStates.MatchState;
import gameObject.Character;

public class Move extends StateMatch{
	private Character selectedCharacter;
	
	public Move(MatchState matchState, Cursor cursor) {
		super(matchState, cursor);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void initWindow() {
		// TODO Auto-generated method stub
	}
	
	public void setSelectedCharacter(Character character){
		this.selectedCharacter = character;
	}

	@Override
	public void doAction() {
		// TODO Auto-generated method stub
		if (this.matchState.getMatch().getMap().getTile(this.cursor.getX(), this.cursor.getY()).getCharacter() == null){
			this.matchState.getMatch().getMap().moveCharacter(this.selectedCharacter, this.cursor.getX(),this.cursor.getY());
			this.matchState.setCurrentState(IDLE);
		} else {
			System.out.println("Opération impossible");
		}
	}

	@Override
	public void cancel() {
		// TODO Auto-generated method stub
		this.matchState.setCurrentState(CHARACTERACTION);
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
