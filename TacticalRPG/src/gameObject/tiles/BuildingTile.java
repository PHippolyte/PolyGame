package gameObject.tiles;

import gameObject.Tile;

public class BuildingTile extends Tile {

	public BuildingTile(int x, int y) {
		super(x, y, 0, 0, 0, 0, 0, 0, 0, 1, TypeTile.BUILDING); //attack, attackMAgic defense defenseMagic precision dodge range consommation type
	}

	@Override
	public String getInfo() {
		// TODO Auto-generated method stub
		return "Building, Consomation "+this.consomation;
	}
	
	public String toString(){
		if (this.character != null){
			return this.character.getIcone();
		} else {
			return "B";
		}
	}

}
