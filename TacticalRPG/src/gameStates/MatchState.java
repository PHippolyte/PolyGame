package gameStates;

import java.util.HashMap;

import game.Cursor;
import game.Game;
import game.Match;
import gameStates.matchWindows.*;

public class MatchState extends GameState implements MatchStateConstant{
	private Match match;
	private Screen screen;
	private int currentState;
	
	private HashMap<Integer, StateMatch> states;
	
	public MatchState(Game game, Cursor cursor){
		super(game,cursor);
		this.states = new HashMap<Integer, StateMatch>();
		
		this.screen = new Screen();
		this.states.put(IDLE, new Idle(this,this.cursor));
		this.states.put(CHARACTERACTION, new CharacterAction(this,this.cursor));
		this.states.put(ATTACK, new Attack(this,this.cursor));
		this.states.put(MOVE, new Move(this,this.cursor));
		this.states.put(DEFAULTACTION, new DefaultAction(this,this.cursor));
		this.states.put(HEAL, new Heal(this,this.cursor));
	}
	
	@Override
	public void initState() {
		// TODO Auto-generated method stub
		this.setCurrentState(INIT);
		this.cursor.setPosition(0, 0);
		this.match = this.game.getMatch();
		this.setCurrentState(IDLE);
	}
	
	public void setMatch(Match match){
		this.match = match;
	}
	
	public Match getMatch(){
		return this.match;
	}
	
	public Screen getScreen(){
		return this.screen;
	}
	
	public void setCurrentState(int state){
		this.currentState = state;
		this.setChanged();
		this.notifyObservers();
	}

	public StateMatch getCurrentState(){
		return this.states.get(this.currentState);
	}
	
	public int getCurrentIntState(){
		return this.currentState;
	}
	
	public CharacterAction getCharacterAction(){
		return (CharacterAction)this.states.get(CHARACTERACTION);
	}
	
	public Attack getAttackState(){
		return (Attack)this.states.get(ATTACK);
	}
	
	public Move getMoveState(){
		return (Move)this.states.get(MOVE);
	}
	
	public DefaultAction getDefaultAction(){
		return (DefaultAction)this.states.get(DEFAULTACTION);
	}
	//fonction de d�placement du curseur
	
	@Override
	public void doAction() {
		System.out.println(this.getCurrentState());
		System.out.println(this.cursor);
		this.match.getMap().printInfoTile(this.cursor.getX(), this.cursor.getY());
		
		this.states.get(this.currentState).doAction();
		
		System.out.println(this.getCurrentState());
		this.setChanged();
		this.notifyObservers();
	}
	
	public void cancel(){
		this.getCurrentState().cancel();
	}
	
	public void setCursorPosition(int x, int y){
		this.cursor.setPosition(x, y);
		this.screen.setPosition(x, y);
	}
	
	@Override
	public void moveCursorUp() {
		// TODO Auto-generated method stub
		this.getCurrentState().moveCursorUp();
		this.setChanged();
		this.notifyObservers();
	}

	@Override
	public void moveCursorDown() {
		// TODO Auto-generated method stub
		this.getCurrentState().moveCursorDown();
		this.setChanged();
		this.notifyObservers();
	}

	@Override
	public void moveCursorRight() {
		// TODO Auto-generated method stub
		this.getCurrentState().moveCursorRight();
		this.setChanged();
		this.notifyObservers();
	}

	@Override
	public void moveCursorLeft() {
		// TODO Auto-generated method stub
		this.getCurrentState().moveCursorLeft();
		this.setChanged();
		this.notifyObservers();
	}
}
