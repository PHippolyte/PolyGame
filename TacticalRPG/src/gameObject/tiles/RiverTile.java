package gameObject.tiles;

import gameObject.Tile;

public class RiverTile extends Tile{

	public RiverTile(int x, int y) {
		super(x, y);
		this.load("ressources/tiles/River1.png");
		// TODO Auto-generated constructor stub
	}

	@Override
	public String getInfo() {
		// TODO Auto-generated method stub
		return "River";
	}

}
