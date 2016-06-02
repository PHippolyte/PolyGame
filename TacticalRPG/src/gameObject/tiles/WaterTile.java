package gameObject.tiles;

import gameObject.Tile;

public class WaterTile extends Tile {

	public WaterTile(int x, int y) {
		super(x, y, 0, 0, 0, 0, 0, 0, 0, 50, TypeTile.WATER); //attack, attackMAgic defense defenseMagic precision dodge range consommation type
		this.load("ressources/tiles/water0.png");
	}

	@Override
	public String getInfo() {
		// TODO Auto-generated method stub
		return "Water, Consomation "+this.consomation;
	}
	
	public String toString(){
		if (this.character != null){
			return this.character.getIcone();
		} else {
			return "W";
		}
	}

}