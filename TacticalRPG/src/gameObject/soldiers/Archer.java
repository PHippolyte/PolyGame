package gameObject.soldiers;

import gameObject.Soldier;

public class Archer extends Soldier{

	public Archer(int x, int y) {
		super(x, y);
		// TODO Auto-generated constructor stub
		this.name = "Archer";
		this.attack = 5;
		this.defense = 2;
		this.agility = 6;
		this.energy = 5;
		this.range = 3;
		this.icone = "a";
	}
}
