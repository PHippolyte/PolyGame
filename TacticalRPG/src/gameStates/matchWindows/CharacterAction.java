package gameStates.matchWindows;

import game.Cursor;
import gameStates.MatchState;
import gameStates.MatchStateConstant;
import gameObject.Character;

public class CharacterAction extends StateMatch implements MatchStateConstant{
	private int nbButton; 
	private int currentButton;
	private Character selectedCharacter;
	
	
	public CharacterAction(MatchState matchState, Cursor cursor) {
		super(matchState, cursor);
		// TODO Auto-generated constructor stub
		this.nbButton = 4;
	}

	@Override
	public void initWindow() {
		// TODO Auto-generated method stub
		this.currentButton = 0;
	}
	
	public int getCurrentButton(){
		return this.currentButton;
	}
	
	public void setSelectedCharacter(Character character){
		this.selectedCharacter = character;
	}
	//fonction curseur
	@Override
	public void doAction() {
		// TODO Auto-generated method stub
		switch(this.currentButton){
		case(0):
			this.matchState.getAttackState().setSelectedCharacter(this.selectedCharacter);
			this.matchState.setCurrentState(ATTACK);
			break;
		case(1):
			//this.matchState.getHealState().setSelectedCharacter(this.selectedCharacter);
			//this.matchState.setCurrentState(HEAL);
			break;
		case(2):
			this.matchState.getMoveState().setSelectedCharacter(this.selectedCharacter);
			this.matchState.setCurrentState(MOVE);
			break;
		case(3):
			//this.selectedCharacter.moveDefense();
			this.matchState.setCurrentState(IDLE);
			break;
		}
	}

	@Override
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
	
	public String toString(){
		return "State : Character Actions, current button = "+this.currentButton;
	}
}
