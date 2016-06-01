package gameStates;

import java.util.HashMap;

import Sound.soundManager;
import game.Cursor;
import game.Game;
import game.Match;
import gameStates.matchWindows.*;

public class MatchState extends GameState implements MatchStateConstant{
	private Match match;
	private Screen screen;
	private int currentState;
	private boolean cancelsound; 
	
	private HashMap<Integer, StateMatch> states;
	
	public MatchState(Game game, Cursor cursor){
		super(game,cursor);
		this.cancelsound = false;
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
		
		if ((currentState == ATTACK || currentState == MOVE )&& state == IDLE){
			cancelsound = true;
		}
		
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
	
	public Heal getHealState(){
		return (Heal)this.states.get(HEAL);
	}
	//fonction de d�placement du curseur
	
	@Override
	public void doAction() {
		this.states.get(this.currentState).doAction();//on fait l'action demandé
		this.getMatch().getCurrentTeam().udpdate();//on met a jour l'équipe
		
		if (!cancelsound){
			this.getSoundManager().play("enter");
		}else cancelsound = false;
		
		if (this.match.getMode().isWon()){//si partie gagné
			System.out.println("Game Over");
			this.game.setState(MAINMENU);
			this.game.destroyMatch();
		}
		
		if (this.match.getCurrentTeam().isDone()){//si l'équipe a fini de joué
			this.match.getCurrentTeam().setTeamDone(false);
			this.match.setNextTeam();
		}
		
		this.setChanged();
		this.notifyObservers();
	}
	
	public void cancel(){
		getSoundManager().play("cancel");
		this.getCurrentState().cancel();
	}
	
	public void setCursorPosition(int x, int y){
		this.cursor.setPosition(x, y);
		if (!this.screen.isInScreen(x, y)){
			this.screen.tryCenter(x, y, this.match.getMap().getNbCols(), this.match.getMap().getNbRows());
		}
	}
	
	@Override
	public void moveCursorUp() {
		getSoundManager().play("cursor");
		this.getCurrentState().moveCursorUp();
		this.setChanged();
		this.notifyObservers();
	}

	@Override
	public void moveCursorDown() {
		getSoundManager().play("cursor");
		this.getCurrentState().moveCursorDown();
		this.setChanged();
		this.notifyObservers();
	}

	@Override
	public void moveCursorRight() {
		getSoundManager().play("cursor");
		this.getCurrentState().moveCursorRight();
		this.setChanged();
		this.notifyObservers();
	}

	@Override
	public void moveCursorLeft() {
		getSoundManager().play("cursor");
		this.getCurrentState().moveCursorLeft();
		this.setChanged();
		this.notifyObservers();
	}
}
