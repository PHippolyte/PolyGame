package gameObject;

public abstract class Hero extends Character{

	public Hero(){
		this.type = Type.HERO;
	}
	
	public Hero(int x, int y, int attack, int attackMagic, int defense, int defenseMagic, int precision, int precisionMagic, int dodge, int block, int resistance, int critique, int energy, int range, int health, int heal, TypeAttack typeAttack) {
		super(x, y, attack, attackMagic, defense, defenseMagic, precision, precisionMagic, dodge, block, resistance, critique, energy, range,health, heal, typeAttack);
		// TODO Auto-generated constructor stub
		this.type = Type.HERO;
	}
}
