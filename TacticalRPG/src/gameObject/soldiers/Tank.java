package gameObject.soldiers;

import gameObject.Soldier;

public class Tank extends Soldier {

	public Tank() {
		super(0, 0,  5, 0, 6, 4, 70, 0, 0, 30, 10, 5, 4, 1, 12, 0, TypeAttack.PHYSICAL);
		this.name = "Tank";
		this.icone = "t";
	}

	public Tank(int x, int y) {
		super(x, y,  5, 0, 6, 4, 70, 0, 0, 30, 10, 5, 4, 1, 12, 0, TypeAttack.PHYSICAL);
		this.name = "Tank";
		this.icone = "t";
	}

}
