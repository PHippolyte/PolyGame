package gameObject.tiles;

import gameObject.Tile;

public class ForestTile extends Tile{
	
	public ForestTile(int x, int y){
		super(x,y);
		this.consomation = 2;
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
