package map;

import gameObject.Tile;
import gameObject.tiles.*;

public class Generation {
	
	public Tile[][] generate(int nx, int ny){
		Tile[][] map = new Tile[nx][ny];
		
		for (int i=0; i<nx; i++){
			for (int j=0; j<ny; j++){
				map[i][j] = new LandTile(i,j);
			}
		}
		for (int i=0; i<5; i++){
			map[i][10] = new RiverTile(10,i);
		}
		
		for (int i=0; i<10; i++){
			Tile newTile = new RiverTile(i,4);
			newTile.load("ressources/tiles/River2.png");
			map[4][i] = newTile;
		}
		Tile newTile = new RiverTile(10,4);
		newTile.load("ressources/tiles/River3.png");
		map[4][10] = newTile;
		
		for (int i=11; i<20; i++){
			for (int j=11; j<20; j++){
				map[i][j] = new ForestTile(j,i);
			}
		}
		
		return map;
	}
}
