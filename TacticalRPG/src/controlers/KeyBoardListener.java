package controlers;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import Sound.soundManager;
import game.Game;

public class KeyBoardListener implements KeyListener{
	private Game model;
	private soundManager sound;
	
	public KeyBoardListener(Game model){
		this.model =  model;
		sound = new soundManager();
	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		switch(arg0.getKeyCode()){
		case(KeyEvent.VK_UP):
			sound.playH();
			this.model.getCurrentState().moveCursorUp();
			break;
		case(KeyEvent.VK_DOWN):
			sound.playH();
			this.model.getCurrentState().moveCursorDown();
			break;
		case(KeyEvent.VK_LEFT):
			sound.playH();
			this.model.getCurrentState().moveCursorLeft();
			break;
		case(KeyEvent.VK_RIGHT):
			sound.playH();
			this.model.getCurrentState().moveCursorRight();
			break;
		case(KeyEvent.VK_X):
			sound.playB();
			this.model.getCurrentState().doAction();
			break;
		case(KeyEvent.VK_C):
			sound.playR();
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
