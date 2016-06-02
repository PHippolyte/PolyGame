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
			map[10][i] = new WaterTile(10,i);
		}
		
		for (int i=0; i<10; i++){
			Tile newTile = new WaterTile(i,4);
			newTile.load("ressources/tiles/River2.png");
			map[i][4] = newTile;
		}
		Tile newTile = new WaterTile(10,4);
		newTile.load("ressources/tiles/River3.png");
		map[10][4] = newTile;
		
		map[10][2] = new BridgeTile(10,2);
		
		Tile b = new BridgeTile(4,4);
		b.load("ressources/tiles/bridge2.png");
		map[4][4] = b;
		
		for (int i=11; i<20; i++){
			for (int j=11; j<20; j++){
				map[i][j] = new ForestTile(i,j);
			}
		}
		
		return map;
	}
}
