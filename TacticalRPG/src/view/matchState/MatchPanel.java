package view.matchState;

import java.awt.Graphics;
import java.awt.Graphics2D;

import game.Cursor;
import gameStates.MatchState;
import gameStates.Screen;
import map.Map;
import view.GamePanel;

@SuppressWarnings("serial")
public class MatchPanel extends GamePanel{
	//vision sur l'état matchState pour récupérer les donnée du match dans la fonction paint
	private MatchState matchState;
	
	//booléan de répartition des affichages
	private boolean paintCursor;
	private boolean paintMap;
	private boolean paintCharacter;
	private boolean paintCharacterAction;
	private boolean paintAttack;
	private boolean paintMove;
	private boolean paintDefaultAction;
	
	//dimension des cases de l'écran
	private int tileWidth;
	private int tileHeight;
	
	//panel des fenetres affichable pendant la partie
	private CharacterActionPanel characterActionpanel;
	private DefaultActionPanel defaultActionpanel;
	
	public MatchPanel(MatchState m){
		this.matchState = m;
		this.paintCursor = false;
		this.paintMap = false;
		this.paintCharacter = false;
		this.paintCharacterAction = false;
		
		this.setLayout(null);
		
		//création des fenetres de la partie 
		this.characterActionpanel = new CharacterActionPanel(this.matchState.getCharacterAction());
		this.defaultActionpanel = new DefaultActionPanel(this.matchState.getDefaultAction());
	}
	
	
	//fonction d'affichage
	public void paint(Graphics g){
		Graphics2D g2 = (Graphics2D)g;
		Screen screen = this.matchState.getScreen();
		if (paintMap){
			//painting the map
			Map map = this.matchState.getMatch().getMap();
			for (int i=screen.getX1(); i <= screen.getX2(); i++){
				for (int j=screen.getY1(); j <= screen.getY2(); j++){
					g2.drawImage(map.getTile(i,j).getImage(),(i-screen.getX1())*this.tileWidth,(j-screen.getY1())*this.tileHeight, this);
				}
			}
			this.paintMap = false;
		}
		if (paintCharacter){
			//painting character
			gameObject.Character[] character = this.matchState.getMatch().getCharacters();
			for (gameObject.Character c : character){
				if (screen.isInScreen(c.getX(), c.getY())){
					g2.drawImage(c.getImage(),(c.getX()-screen.getX1())*this.tileWidth, (c.getY()-screen.getY1())*this.tileHeight, this);
				}
			}
			this.paintCharacter = false;
		}
		if (paintCursor){
			Cursor cursor = this.matchState.getCursor();
			g2.drawImage(cursor.getImage(),-2+(cursor.getX()-screen.getX1())*this.tileWidth,-2+(cursor.getY()-screen.getY1())*this.tileHeight, this);
			this.paintCursor = false;
		}
		if (paintCharacterAction){
			Cursor cursor = this.matchState.getCursor();
			this.characterActionpanel.moveWindow((cursor.getX()-screen.getX1()+1)*this.tileWidth,(cursor.getY()-screen.getY1())*this.tileHeight);
			this.characterActionpanel.paint(g2);
			this.paintCharacterAction = false;
		}
		if (paintDefaultAction){
			Cursor cursor = this.matchState.getCursor();
			this.defaultActionpanel.moveWindow((cursor.getX()-screen.getX1()+1)*this.tileWidth, (cursor.getY()-screen.getY1())*this.tileHeight);
			this.defaultActionpanel.paint(g2);
			this.paintDefaultAction = false;
		}
	}
	public void init(){
		this.tileWidth = this.getWidth()/this.matchState.getScreen().getWidth();
		this.tileHeight = this.getHeight()/this.matchState.getScreen().getHeight();
	}
	
	public void drawCharacterAction(){
		this.paintCharacterAction = true;
	}
	public void drawCursor(){
		this.paintCursor = true;
	}
	public void drawCharacter(){
		this.paintCharacter = true;
	}
	public void drawMap(){
		this.paintMap = true;
	}
	public void drawAttack(){
		this.paintAttack = true;
	}
	public void drawMove(){
		this.paintMove = true;
	}
	public void drawDefaultAction(){
		this.paintDefaultAction = true;
	}
	
	public void drawBasicImage(){
		this.drawCursor();
		this.drawCharacter();
		this.drawMap();
	}
	public void drawAll(){
		this.drawCharacter();
		this.drawCursor();
		this.drawMap();
		this.drawCharacterAction();
	}
	
}
