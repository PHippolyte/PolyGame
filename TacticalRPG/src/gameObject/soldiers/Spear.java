package gameObject.soldiers;

import gameObject.Soldier;

public class Spear extends Soldier {

	public Spear() {
		super(0, 0,  7, 0, 5, 5, 75, 0, 10, 0, 20, 10, 5, 2, 10, 0, TypeAttack.PHYSICAL);
		this.name = "Spear";
		this.icone = "sp";
	}

	public Spear(int x, int y) {
		super(x, y,  7, 0, 5, 5, 75, 0, 10, 0, 20, 10, 5, 2, 10, 0, TypeAttack.PHYSICAL);
		this.name = "Spear";
		this.icone = "sp";
	}

}
