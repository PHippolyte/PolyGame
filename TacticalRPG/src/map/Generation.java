package map;

import gameObject.Tile;
import gameObject.tiles.*;

public class Generation {
	
	public Tile[][] generate(int x, int y){
		Tile[][] map = new Tile[y][x];
		
		for (int i=0; i<x; i++){
			for (int j=0; j<y; j++){
				map[i][j] = new ForestTile(i,j);
			}
		}
		return map;
	}
}
