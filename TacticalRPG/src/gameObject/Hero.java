package gameObject;

import spellEffect.Spell;

public abstract class Hero extends Character{
	int mana;
	int manaMax;
	Spell spell1;
	Spell spell2;
	Spell spell3;
	Spell spell4;
	Spell[] spells;
	
	public Hero(){
		this.type = Type.HERO;
		this.spells = new Spell[4];
	}
	
	public Hero(int x, int y, int attack, int attackMagic, int defense, int defenseMagic, int precision, int precisionMagic, int dodge, int block, int resistance, int critique, int energy, int range, int health, int heal, TypeAttack typeAttack, int mana, Spell spell1, Spell spell2, Spell spell3, Spell spell4) {
		super(x, y, attack, attackMagic, defense, defenseMagic, precision, precisionMagic, dodge, block, resistance, critique, energy, range,health, heal, typeAttack);
		// TODO Auto-generated constructor stub
		this.type = Type.HERO;
		this.mana = mana;
		this.manaMax =mana;
		this.spell1 = spell1;
		this.spell2 = spell2;
		this.spell3 = spell3;
		this.spell4 = spell4;
		
		this.spells = new Spell[4];
		this.spells[0] = spell1;
		this.spells[1] = spell2;
		this.spells[2] = spell3;
		this.spells[3] = spell4;
	}
	
	public Spell getSpell(int i){
		return this.spells[i];
	}
	
	public int getNbSpells(){
		return this.spells.length;
	}
}
