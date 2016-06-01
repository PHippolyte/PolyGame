package spellEffect;

import java.util.List;

public abstract class Spell {
	protected int manaCost;
	protected int damage;
	protected int range;
	
	public Spell(int cost, int damage, int range){
		this.manaCost = cost;
		this.damage =damage;
		this.range = range;
	}

	public int getManaCost() {
		return manaCost;
	}
	
	public double getDamage() {
		return damage;
	}

}
