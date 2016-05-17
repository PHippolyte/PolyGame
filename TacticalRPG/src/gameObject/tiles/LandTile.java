package gameObject.tiles;

import gameObject.Tile;

public class LandTile extends Tile{

	public LandTile(int x, int y) {
		super(x, y);
		this.load("ressources/tiles/Land.png");
		// TODO Auto-generated constructor stub
		this.consomation = 1;
	}

	@Override
	public String getInfo() {
		// TODO Auto-generated method stub
		return "Land"+this.consomation;
	}

}
