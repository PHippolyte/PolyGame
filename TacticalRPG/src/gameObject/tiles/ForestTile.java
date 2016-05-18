package gameObject.tiles;

import gameObject.Tile;

public class ForestTile extends Tile{
	
	public ForestTile(int x, int y){
		super(x,y, 0, 0, 0, 0, 0, 0, 0, 2, TypeTile.FOREST); //attack, attackMAgic defense defenseMagic precision dodge range consommation type);
		this.load("ressources/tiles/Forest.png");
	}
	
	public String getInfo(){
		return "Forest, Consomation "+this.consomation;
	}
	
	public String toString(){
		if (this.character != null){
			return this.character.getIcone();
		} else {
			return "F";
		}
	}
}
