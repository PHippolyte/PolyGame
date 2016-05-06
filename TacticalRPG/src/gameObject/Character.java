package gameObject;

public abstract class Character extends MapObject{
	protected int energy;
	protected int range;
	
	public Character(int x, int y) {
		super(x, y);
		// TODO Auto-generated constructor stub
	}
	
	public String toString(){
		return this.name+", ATT "+this.attack+", DEF "+this.defense+", AGI "+this.agility+", NRG "+this.energy+", RNG "+this.range;
	}

}
