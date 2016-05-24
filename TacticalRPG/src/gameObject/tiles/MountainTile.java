package gameObject.tiles;

import gameObject.Tile;

public class MountainTile extends Tile{
	
	public MountainTile(int x, int y){
		super(x,y, 0, 0, 0, 0, 0, 0, 1, 3, TypeTile.MOUNTAIN); //attack, attackMAgic defense defenseMagic precision dodge range consommation type);
		this.load("ressources/tiles/Moutain.png");
	}
	
	public String getInfo(){
		return "Mountain, Consomation "+this.consomation;
	}
	
	public String toString(){
		if (this.character != null){
			return this.character.getIcone();
		} else {
			return "M";
		}
	}
}