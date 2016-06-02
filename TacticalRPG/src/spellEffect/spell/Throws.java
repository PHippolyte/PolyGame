package spellEffect.spell;

import gameObject.Character;
import gameObject.Hero;

import java.util.List;

public class Throws extends spellEffect.Spell{

	public Throws() {
		super(60, 4, 2);
		this.type = Type.DAMAGE;
		// TODO Auto-generated constructor stub
		this.slashRange = 0;
	}

	@Override
	public void action(Character character, Hero caster) {
		character.doDamage(this.damage);
	}
}