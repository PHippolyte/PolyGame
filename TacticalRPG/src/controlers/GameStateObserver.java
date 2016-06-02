package controlers;

import java.util.HashMap;
import java.util.Observable;
import java.util.Observer;

import gameStates.GameStateConstant;
import controlers.heroMenu.HeroMenuControler;
import controlers.mainMenu.MainMenuControler;
import controlers.matchState.MatchStateControler;
import controlers.modeMenu.ModeMenuControler;
import controlers.saveMenu.SaveMenuControler;
import controlers.teamMenu.TeamMenuControler;
import game.Game;
import view.Window;

public class GameStateObserver implements Observer, GameStateConstant{
	private HashMap<Integer, GameStateControler> controlers;
	private Window view;
	private Game game;
	
	public GameStateObserver(Window view, Game game){
		this.game = game;
		this.view = view;
		this.controlers = new HashMap<Integer, GameStateControler>();
		
		//ajout des controleurs des etats du jeu
		this.controlers.put(MAINMENU, new MainMenuControler(this.game.getMainMenuState()));
		this.controlers.put(MODEMENU, new ModeMenuControler(this.game.getModeMenuState()));
		this.controlers.put(SAVEMENU, new SaveMenuControler(this.game.getSaveMenuState()));
		this.controlers.put(HEROMENU, new HeroMenuControler(this.game.getHeroMenuState()));
		this.controlers.put(TEAMMENU, new TeamMenuControler(this.game.getTeamMenuState()));
		this.controlers.put(MATCHSTATE, new MatchStateControler(this.game.getMatchMenuState()));
		
		//initialisation au menu Principal
		this.view.setScreen(this.controlers.get(MAINMENU).getView());
	}
	@Override
	public void update(Observable arg0, Object arg1) {
		// TODO Auto-generated method stub
		Game game = (Game)arg0;
		GameStateControler c = this.controlers.get(game.getCurrentIntState());
		c.init();
		c.updateObserver();
		this.view.changeScreen(c.getView());
	}
	
}
