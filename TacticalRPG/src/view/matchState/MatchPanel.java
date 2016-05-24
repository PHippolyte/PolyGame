package view.matchState;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.color.ColorSpace;
import java.awt.image.BufferedImage;
import java.awt.image.ColorConvertOp;
import java.awt.AlphaComposite;
import java.awt.Color;

import game.Cursor;
import gameObject.Tile;
import gameObject.Character;
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
		
		//AFFICHAGE DES CASES
		if (paintMap){
			//painting the map
			Map map = this.matchState.getMatch().getMap();
			for (int i=screen.getX1(); i <= screen.getX2(); i++){
				for (int j=screen.getY1(); j <= screen.getY2(); j++){
					g2.drawImage(map.getTile(i,j).getImage(),this.scaleX(i-screen.getX1()),this.scaleY(j-screen.getY1()), this);
				}
			}
			this.paintMap = false;
		}
		
		//AFFICHAGE DES MOUVEMENTS
		if (this.paintMove){
			for (Tile t : this.matchState.getMoveState().getMoves()){
				g2.setColor(Color.CYAN);
				g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER,(float) Math.min(0.5,1.0f)));
				g2.fillRect(this.scaleX(this.XtoScreen(t.getX(), screen))+2, this.scaleY(this.YtoScreen(t.getY(), screen))+2, tileWidth-4, tileHeight-4);
				g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER,(float) Math.min(1,1.0f)));
			}
			this.paintMove = false;
		}
		
		//AFFICHAGE DES CASES D'ATTAQUE
		if (this.paintAttack){
			for(Tile t : this.matchState.getAttackState().getAttack()){
				g2.setColor(Color.RED);
				g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER,(float) Math.min(0.6,1.0f)));
				g2.fillRect(this.scaleX(this.XtoScreen(t.getX(), screen))+2, this.scaleY(this.YtoScreen(t.getY(), screen))+2, tileWidth-4, tileHeight-4);
				g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER,(float) Math.min(1,1.0f)));
			}
			this.paintAttack = false;
		}
		
		
		//AFFICHAGE DES PERSONNAGES
		if (paintCharacter){
			//painting character
			gameObject.Character[] character = this.matchState.getMatch().getCharacters();
			for (gameObject.Character c : character){
				if (screen.isInScreen(c.getX(), c.getY())){
					//g2.fillRect(this.scaleX(this.XtoScreen(c.getX(), screen)), this.scaleY(this.YtoScreen(c.getY(), screen)), tileWidth, tileHeight);
					if (c.getDone()){ //grisement du personnage
						g2.drawImage(this.grayRender(c.getImage()),this.scaleX(this.XtoScreen(c.getX(), screen)), this.scaleY(c.getY()-screen.getY1()), this);
					} else {
						g2.drawImage(c.getImage(),this.scaleX(this.XtoScreen(c.getX(), screen)), this.scaleY(c.getY()-screen.getY1()), this);
					}
					this.paintLifeBar(g2, c, screen);
				}
			}
			this.paintCharacter = false;
		}
		
		//AFFICHAGE DU CURSEUR
		if (paintCursor){
			Cursor cursor = this.matchState.getCursor();
			g2.drawImage(cursor.getImage(),this.scaleX((this.XtoScreen(cursor.getX(), screen)))-2,this.scaleY(this.YtoScreen(cursor.getY(), screen))-2, this);
			this.paintCursor = false;
		}
		
		//AFFICHAGE DE LA FENETRE DES ACTIONS PERSONNAGE
		if (paintCharacterAction){
			Cursor cursor = this.matchState.getCursor();
			int aimedX = (cursor.getX()-screen.getX1()+2);
			int aimedY = (cursor.getY()-screen.getY1()-2);
			
			while (aimedX < 0) aimedX++;
			while (aimedY < 0) aimedY++;
			
			
			if (aimedX+1+this.deScaleX(this.characterActionpanel.getWidth()) > screen.getWidth()){
				while(aimedX+2+this.deScaleX(this.characterActionpanel.getWidth()) > this.XtoScreen(cursor.getX(), screen)) aimedX--;
			}
			if (aimedY+this.deScaleY(this.characterActionpanel.getHeight()) > screen.getHeight()){
				while(aimedY+1+this.deScaleY(this.characterActionpanel.getHeight()) > screen.getHeight()) aimedY--;
			}			
			
			this.characterActionpanel.moveWindow(this.scaleX(aimedX),this.scaleY(aimedY));
			this.characterActionpanel.paint(g2);
			this.paintCharacterAction = false;
		}
		
		//AFFICHAGE DES ACTIONS PAR DEFAUT 
		if (paintDefaultAction){
			Cursor cursor = this.matchState.getCursor();
			int aimedX = (cursor.getX()-screen.getX1()+2);
			int aimedY = (cursor.getY()-screen.getY1()-2);
			
			while (aimedX < 0) aimedX++;
			while (aimedY < 0) aimedY++;
			
			
			if (aimedX+1+this.deScaleX(this.defaultActionpanel.getWidth()) > screen.getWidth()){
				while(aimedX+2+this.deScaleX(this.defaultActionpanel.getWidth()) > this.XtoScreen(cursor.getX(), screen)) aimedX--;
			}
			if (aimedY+this.deScaleY(this.defaultActionpanel.getHeight()) > screen.getHeight()){
				while(aimedY+1+this.deScaleY(this.defaultActionpanel.getHeight()) > screen.getHeight()) aimedY--;
			}			
			
			this.defaultActionpanel.moveWindow(this.scaleX(aimedX),this.scaleY(aimedY));
			this.defaultActionpanel.paint(g2);
			this.paintDefaultAction = false;
		}
	}
	
	private void paintLifeBar(Graphics g, Character c, Screen s){
		g.setColor(Color.BLACK);
		g.fillRect(this.scaleX(this.XtoScreen(c.getX(), s))+1, this.scaleY(this.YtoScreen(c.getY(),s))+27, tileWidth-2, tileHeight-27);
		g.setColor(Color.GREEN);
		g.fillRect(this.scaleX(this.XtoScreen(c.getX(), s))+2, this.scaleY(this.YtoScreen(c.getY(),s))+28, (int) (tileWidth*((float)c.getHealth()/c.getMaxHealth())-4), tileHeight-29);
	}
	
	
	
	public void init(){
		this.tileWidth = this.getWidth()/this.matchState.getScreen().getWidth();
		this.tileHeight = this.getHeight()/this.matchState.getScreen().getHeight();
	}
	
	public int XtoScreen(int x,Screen screen){
		return x- screen.getX1();
	}
	
	public int YtoScreen(int y,Screen screen){
		return y- screen.getY1();
	}
	
	private int scaleX(int x){
		return x*this.tileWidth;
	}
	private int scaleY(int y){
		return y*this.tileHeight;
	}
	
	private int deScaleX(int x){
		return x/this.tileWidth;
	}
	
	private int deScaleY(int y){
		return y/this.tileHeight;
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
