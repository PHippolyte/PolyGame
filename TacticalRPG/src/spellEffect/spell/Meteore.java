package spellEffect.spell;

import gameObject.Character;
import gameObject.Hero;

public class Meteore extends spellEffect.Spell{

	public Meteore() {
		super(500, 6, 30);
		this.type = Type.DAMAGE;
		this.slashRange = 3;
		// TODO Auto-generated constructor stub
	}

	public void action(Character character, Hero caster) {
		// TODO Auto-generated method stub
		character.doDamage(this.damage);
		
	}
}
