package map;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import gameObject.Character;
import gameObject.Tile;

public class Map {
	private int nrows;
	private int ncols;
	private Tile[][] map;
	private Generation generation;


	public Map(int x, int y){
		this.nrows = y;
		this.ncols = x;
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
	
	HashSet<Tile> getFourTile(Tile T){
		HashSet<Tile> fourTile = new HashSet<Tile>();
		int x = T.getX();
		int y = T.getY();
		
		if (x>0) fourTile.add(getTile(x-1,y));
		if (x<getNbCols()) fourTile.add(getTile(x+1,y));
		if (y>0) fourTile.add(getTile(x,y-1));
		if (y<getNbRows()) fourTile.add(getTile(x,y+1));
		
		return fourTile;
	}
	
	public Set<Tile> searchMoves(Character c){
		
		HashSet<Tile> moves = new HashSet<Tile>();
		HashMap<Tile, Integer> tabEnergy = new HashMap<Tile, Integer>();
		tabEnergy.put(getTile(c.getX(), c.getY()) ,c.getEnergy());
		moves.add(getTile(c.getX(), c.getY()));
		
		HashSet<Tile> fourmoves = new HashSet<Tile>();
		
		List<Tile> queue = new ArrayList<Tile>();
		
		queue.add(getTile(c.getX(), c.getY()));
		
		while (!(queue.isEmpty())){
			
			Tile T = queue.get(0);
			//System.out.println(T.getX() +", " +T.getY());
			int energy = tabEnergy.get(T);
			fourmoves = getFourTile(T);
			
			for(Tile Tfm: fourmoves){
				
				
				
				if ( Tfm.getConsomation() <= energy && !(moves.contains(Tfm)) ){
					System.out.println("FM: "+Tfm.getX() +", " +Tfm.getY());
					tabEnergy.put(Tfm, energy - Tfm.getConsomation());
					moves.add(Tfm);
					queue.add(Tfm);
				}	
				
			}
			System.out.println(" ");
			fourmoves.clear();
			queue.remove(0);
		}
		
		
		return moves;
	}
	

	public void moveCharacter(Character character, int x, int y){

//		Set<Tile> moves = new HashSet<Tile>();
//		moves = searchMoves(character);
//		
//		for( Tile T: moves){
//			System.out.println(T.getX() +" , " + T.getY());
//		}
		
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

	public Tile[] getAttackTiles(){
		//tous est a faire
		return null;
	}

	public Tile[] getMoveTiles(){
		//tous est a faire
		return null;
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
