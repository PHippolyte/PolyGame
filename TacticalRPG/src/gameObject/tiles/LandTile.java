package gameObject.tiles;

import gameObject.Tile;

public class LandTile extends Tile{

	public LandTile(int x, int y) {
		super(x, y, 0, 0, 0, 0, 0, 0, 0, 1, TypeTile.LAND); //attack, attackMAgic defense defenseMagic precision dodge range consommation type););
		this.load("ressources/tiles/Land.png");
		// TODO Auto-generated constructor stub
	}

	@Override
	public String getInfo() {
		// TODO Auto-generated method stub
		return "Land"+this.consomation;
	}
	
	public String toString(){
		if (this.character != null){
			return this.character.getIcone();
		} else {
			return "L";
		}
	}

}
