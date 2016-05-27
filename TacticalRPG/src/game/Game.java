package game;

import java.util.HashMap;
import java.util.Observable;

import Sound.soundManager;
import gameStates.GameState;
import gameStates.GameStateConstant;
import gameStates.MatchState;
import gameStates.menus.*;

public class Game extends Observable implements GameStateConstant{
	private int currentState;
	private HashMap<Integer, GameState> gameStates;
	private Cursor cursor;
	private Match match;
	private soundManager menuSound;
	
	public Game(){
		this.gameStates = new HashMap<Integer , GameState>();
		this.cursor = new Cursor(0,0);
		menuSound = new soundManager(2);
		this.initGame();
	}
	
	private void initGame(){
		this.gameStates.put(MAINMENU, new MainMenu(this,this.cursor));
		this.gameStates.put(MODEMENU, new ModeMenu(this,this.cursor));
		this.gameStates.put(SAVEMENU, new SaveMenu(this,this.cursor));
		this.gameStates.put(HEROMENU, new HeroMenu(this,this.cursor));
		this.gameStates.put(TEAMMENU, new TeamMenu(this,this.cursor));
		this.gameStates.put(MATCHSTATE, new MatchState(this, this.cursor));
		this.currentState = MAINMENU;
	}
	
	public void setState(int state){
		this.currentState = state;
		this.gameStates.get(this.currentState).initState();
		this.menuSound.play(0);
		this.setChanged();
		this.notifyObservers();
	}
	
	public GameState getCurrentState(){
		return this.gameStates.get(this.currentState);
	}
	
	public int getCurrentIntState(){
		return this.currentState;
	}
	
	public void initMatch(){
		this.match = new Match();
	}
	
	public void destroyMatch(){
		this.match = null;
	}
	
	public Match getMatch(){
		return this.match;
	}
	
	public void quit(){
		System.out.println("Exit Game");
		System.exit(0);
	}
	
	public MainMenu getMainMenuState(){
		return (MainMenu) this.gameStates.get(MAINMENU);
	}
	public ModeMenu getModeMenuState(){
		return (ModeMenu) this.gameStates.get(MODEMENU);
	}
	public SaveMenu getSaveMenuState(){
		return (SaveMenu) this.gameStates.get(SAVEMENU);
	}
	public HeroMenu getHeroMenuState(){
		return (HeroMenu) this.gameStates.get(HEROMENU);
	}
	public TeamMenu getTeamMenuState(){
		return (TeamMenu) this.gameStates.get(TEAMMENU);
	}
	public MatchState getMatchMenuState(){
		return (MatchState) this.gameStates.get(MATCHSTATE);
	}
}
