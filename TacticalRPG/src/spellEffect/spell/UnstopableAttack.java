package spellEffect.spell;

import gameObject.Character;
import gameObject.Hero;

import java.util.List;

public class UnstopableAttack extends spellEffect.Spell{

	public UnstopableAttack() {
		super(60, 6, 1);
		this.type = Type.DAMAGE;
		this.slashRange = 0;
		// TODO Auto-generated constructor stub
	}

	@Override
	public void action(Character character, Hero caster) {
		character.doDamage(this.damage);
	}
}
