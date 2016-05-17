package gameObject;

public abstract class Hero extends Character{

	public Hero(){
		this.type = Type.HERO;
	}
	
	public Hero(int x, int y) {
		super(x, y);
		// TODO Auto-generated constructor stub
		this.type = Type.HERO;
	}
}
