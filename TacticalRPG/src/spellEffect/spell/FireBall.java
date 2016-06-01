package spellEffect.spell;

import gameObject.Character;
import gameObject.Hero;
import spellEffect.Spell;


public class FireBall extends Spell{

	public FireBall() {
		super(100, 3, 6);
		this.type = Type.DAMAGE;
		this.slashRange = 0;
		// TODO Auto-generated constructor stub
	}

	public void action(Character character, Hero caster) {
		// TODO Auto-generated method stub
		character.doDamage(this.damage);
	}
}
