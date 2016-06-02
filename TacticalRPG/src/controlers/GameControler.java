package controlers;


import game.Game;
import view.Window;

public class GameControler{
	private Game game;
	private Window window;
	
	//oberver des états du jeu
	private GameStateObserver stateObserver;
	//listener pour les touches claviers
	private KeyBoardListener keyListener;
	
	
	public GameControler(Game game){
		this.game = game;
		this.window = new Window();
		
		this.stateObserver = new GameStateObserver(this.window, this.game);
		this.keyListener = new KeyBoardListener(this.game);
		
		this.window.addKeyListener(this.keyListener);
		this.game.addObserver(this.stateObserver);
		this.window.pack();
	}
	
}
