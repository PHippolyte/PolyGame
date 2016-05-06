package main;

import controlers.GameControler;
import game.Game;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Game game = new Game();
		GameControler controler = new GameControler(game);
	}

}
