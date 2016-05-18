package gameObject.soldiers;

import gameObject.Soldier;

public class Knight extends Soldier {

	public Knight() {
		super(0, 0,  8, 0, 5, 5, 80, 0, 0, 0, 20, 15, 8, 1, 10, 0, TypeAttack.PHYSICAL);
		this.name = "Knight";
		this.icone = "k";
	}

	public Knight(int x, int y) {
		super(x, y,  8, 0, 5, 5, 80, 0, 0, 0, 20, 15, 8, 1, 10, 0, TypeAttack.PHYSICAL);
		this.name = "Knight";
		this.icone = "k";
	}

}