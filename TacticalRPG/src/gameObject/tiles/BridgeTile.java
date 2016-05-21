package gameObject.tiles;

import gameObject.Tile;

public class BridgeTile extends Tile{

	public BridgeTile(int x, int y) {
		super(x, y, 0, 0, 0, 0, 0, 0, 0, 1, TypeTile.BRIDGE); //attack, attackMAgic defense defenseMagic precision dodge range consommation type););
		this.load("ressources/tiles/Bridge.png");
	}

	@Override
	public String getInfo() {
		// TODO Auto-generated method stub
		return "Bridge"+this.consomation;
	}
	
	public String toString(){
		if (this.character != null){
			return this.character.getIcone();
		} else {
			return "B";
		}
	}

}