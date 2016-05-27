package map;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

import gameObject.Character;
import gameObject.Tile;
import gameObject.Tile.TypeTile;

public class Map {
	private int nrows;
	private int ncols;
	private Tile[][] map;
	private Generation generation;
	private MapGenerator mapGen;


	public Map(int x, int y){
		this.nrows = y;
		this.ncols = x;
		
		this.generation = new Generation();
		this.mapGen = new MapGenerator(x);
		
		this.createMap();
	}

	public Tile getTile(int x, int y){
		return this.map[x][y];
	}

	public void setCharacterAtTile(Character character, int x, int y){
		this.getTile(x, y).setCharacter(character);
		character.setPosition(x,y);
	}
	
	
	public HashSet<Tile> getFourTile(Tile T){
		HashSet<Tile> fourTile = new HashSet<Tile>();
		int x = T.getX();
		int y = T.getY();
		
		if (x>0) fourTile.add(this.getTile(x-1,y));
		if (x<getNbCols()) fourTile.add(this.getTile(x+1,y));
		if (y>0) fourTile.add(this.getTile(x,y-1));
		if (y<getNbRows()) fourTile.add(this.getTile(x,y+1));
		
		return fourTile;
	}
	
	public HashSet<Tile> searchMoves(Character c){
		
		HashSet<Tile> moves = new HashSet<Tile>();
		HashMap<Tile, Integer> tabEnergy = new HashMap<Tile, Integer>();
		
		tabEnergy.put(getTile(c.getX(), c.getY()) ,c.getEnergy());
		moves.add(getTile(c.getX(), c.getY()));

		HashSet<Tile> fourmoves = new HashSet<Tile>();
		List<Tile> queue = new ArrayList<Tile>();
		
		queue.add(getTile(c.getX(), c.getY()));
		
		while (!(queue.isEmpty())){
			
			Tile T = queue.get(0);
			int energy = tabEnergy.get(T);
			fourmoves = getFourTile(T);
			
			for(Tile Tfm: fourmoves){
				if ( Tfm.getConsomation() <= energy && !(moves.contains(Tfm)) && (Tfm.getCharacter() == null || c.getTeam().isAlly(Tfm.getCharacter()))){
					tabEnergy.put(Tfm, energy - Tfm.getConsomation());
					moves.add(Tfm);
					queue.add(Tfm);
				} else if (moves.contains(Tfm) && (tabEnergy.get(Tfm) < (energy-Tfm.getConsomation()))){
					tabEnergy.remove(Tfm);
					tabEnergy.put(Tfm, energy - Tfm.getConsomation());
				}
			}
			fourmoves.clear();
			queue.remove(0);
		}
		return moves;
	}
	

	public void moveCharacter(Character character, int x, int y){
		
		character.getSoundManager().play(1);
		this.getTile(character.getX(), character.getY()).setCharacter(null);
		this.setCharacterAtTile(character, x, y);

	}

	public void clearCharacter(){
		for (int i=0; i<this.ncols;i++){
			for (int j=0; j<this.nrows; j++){
				this.getTile(i, j).setCharacter(null);
			}
		}
	}

	public HashSet<Tile> getAttackTiles(Character c){
		HashSet<Tile> attackTile = new HashSet<Tile>();
		HashSet<Tile> fourTile = new HashSet<Tile>();
		int charaX = c.getX();
		int charaY = c.getY();
		int tileRange;
		
		int range = c.getRange();
		List<Tile> queue = new ArrayList<Tile>();
		queue.add(getTile(c.getX(), c.getY()));
		
		while (!(queue.isEmpty())){

			Tile T = queue.get(0);
			fourTile = getFourTile(T);
			for (Tile Tfm: fourTile){
				
				tileRange = Math.abs(Tfm.getX()-charaX) + Math.abs(Tfm.getY()-charaY);
				if (tileRange<=range && !(attackTile.contains(Tfm))){
					queue.add(Tfm);
					attackTile.add(Tfm);
				}
			}
			fourTile.clear();
			queue.remove(0);			
		}
		attackTile.remove(this.getTile(c.getX(), c.getY()));
		return attackTile;
	}


	public void printMap(){
		String str = "";
		for (Tile[] row : map){
			for (Tile tile : row){
				str += " "+tile;
			}
			str += "\n";
		}
		System.out.println(str);
	}
	public void printInfoTile(int x, int y){
		Tile tile = getTile(x,y);
		System.out.println(tile.getInfo()+"\n"+tile.getCharacter());

	}


	public void createMap(){
		//this.map = this.generation.generate(this.ncols, this.nrows);
		this.map = this.mapGen.getMap();
		this.loadSprites();
	}

	public int getNbRows(){
		return this.nrows;
	}
	public int getNbCols(){
		return this.ncols;
	}
	
	
	//FONCTION DE CHARGEMENT DES SPRITES
	private void loadSprites(){
		for (int x=0; x<this.ncols; x++){
			for (int y=0; y<this.nrows; y++){
				Tile tile = this.getTile(x, y);
				
				
				switch(tile.getTypeTile()){
				case WATER:
					int valueW = valueWater(x, y);
					switch(valueW){
					case 0: case 1: case 2: case 3: case 4: case 6: case 8: case 9: case 12:
						tile.load("ressources/tiles/water"+valueW+"_"+valueWaterDiag(x,y,valueW)+".png");
						break;
					default:
						tile.load("ressources/tiles/water"+valueW+".png");
					}
					break;
				case BRIDGE:
					if (y > 0 && this.getTile(x, y-1).getTypeTile() != TypeTile.WATER && this.getTile(x, y-1).getTypeTile() != TypeTile.BRIDGE){
						tile.load("ressources/tiles/bridge2.png");
					}
					break;
				default:
					break;
				}
			}
		}
	}
	
	private int valueWater(int x,int y){
		int value = 0;
		
		if (y > 0 && this.getTile(x, y-1).getTypeTile() != TypeTile.WATER && this.getTile(x, y-1).getTypeTile() != TypeTile.BRIDGE) value += 1;
		if (x < this.ncols-1 && this.getTile(x+1, y).getTypeTile() != TypeTile.WATER && this.getTile(x+1, y).getTypeTile() != TypeTile.BRIDGE) value += 2;
		if (y < this.nrows-1 && this.getTile(x, y+1).getTypeTile() != TypeTile.WATER && this.getTile(x, y+1).getTypeTile() != TypeTile.BRIDGE) value += 4;
		if (x > 0 && this.getTile(x-1, y).getTypeTile() != TypeTile.WATER && this.getTile(x-1, y).getTypeTile() != TypeTile.BRIDGE) value += 8;
		
		return value;
	}
	
	private int valueWaterDiag(int x, int y, int v){
		int value = 0;
		
		if ((v&9)==0 && y > 0 && x > 0 && this.getTile(x-1, y-1).getTypeTile() != TypeTile.WATER) value += 1;
		if ((v&3)==0 && y > 0 && x < this.ncols-1 && this.getTile(x+1, y-1).getTypeTile() != TypeTile.WATER) value += 2;
		if ((v&6)==0 && y < this.nrows-1 && x < this.ncols-1 && this.getTile(x+1, y+1).getTypeTile() != TypeTile.WATER) value += 4;
		if ((v&12)==0 && y < this.nrows-1 && x > 0 && this.getTile(x-1, y+1).getTypeTile() != TypeTile.WATER) value += 8;
		return value;
	}
}
