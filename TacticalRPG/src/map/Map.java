package map;

import gameObject.Character;
import gameObject.Tile;

public class Map {
	private int nrows;
	private int ncols;
	private Tile[][] map;
	private Generation generation;
	
	public Map(int x, int y){
		this.nrows = x;
		this.ncols = y;
		this.generation = new Generation();
		
		this.createMap();
	}
	
	public Tile getTile(int x, int y){
		return this.map[y][x];
	}
	
	public void setCharacterAtTile(Character character, int x, int y){
		this.getTile(x, y).setCharacter(character);
		character.setPosition(x,y);
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
		this.map = this.generation.generate(this.nrows, this.ncols);
	}
	
	public int getNbRows(){
		return this.nrows;
	}
	public int getNbCols(){
		return this.ncols;
	}
}
