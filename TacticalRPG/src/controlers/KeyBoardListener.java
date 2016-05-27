package controlers;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import game.Game;

public class KeyBoardListener implements KeyListener{
	private Game model;
	
	public KeyBoardListener(Game model){
		this.model =  model;
	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		switch(arg0.getKeyCode()){
		case(KeyEvent.VK_UP):
			this.model.getCurrentState().moveCursorUp();
			break;
		case(KeyEvent.VK_DOWN):
			this.model.getCurrentState().moveCursorDown();
			break;
		case(KeyEvent.VK_LEFT):
			this.model.getCurrentState().moveCursorLeft();
			break;
		case(KeyEvent.VK_RIGHT):
			this.model.getCurrentState().moveCursorRight();
			break;
		case(KeyEvent.VK_X):
			this.model.getCurrentState().doAction();
			break;
		case(KeyEvent.VK_C):
			this.model.getCurrentState().cancel();
			break;
		}
		
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
	}

}
