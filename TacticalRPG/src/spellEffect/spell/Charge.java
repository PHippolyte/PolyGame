package spellEffect.spell;

import gameObject.Character;
import gameObject.Hero;
import spellEffect.Spell;


public class Charge extends Spell{

	public Charge() {
		super(150, 3, 3);
		this.type = Type.DAMAGE;
		this.slashRange = 1;
		// TODO Auto-generated constructor stub
	}


	@Override
	public void action(Character c, Hero caster) {
		// TODO Auto-generated method stub
		c.doDamage(this.damage);
		
	}
}