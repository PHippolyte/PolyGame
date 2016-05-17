package gameObject;

public abstract class Soldier extends Character{

	public Soldier(){
		super();
		this.type = Type.SOLDIER;
	}
	
	public Soldier(int x, int y) {
		super(x, y);
		// TODO Auto-generated constructor stub
		this.type = Type.SOLDIER;
	}

}
