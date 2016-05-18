package gameObject.soldiers;

import gameObject.Soldier;

public class Archer extends Soldier{

	public Archer(){
		super();
	}
	
	
	public Archer(int x, int y) {
		super(x, y, 9, 0, 4, 5, 70, 0, 10, 0, 10, 10, 6, 3, 10, 0, TypeAttack.PHYSICAL);
		this.load("ressources/Heros/Lyndis.png");
		this.name = "Archer";
		this.icone = "a";
	}
	
}
