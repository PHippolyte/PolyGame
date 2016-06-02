package spellEffect.spell;

import gameObject.Character;
import gameObject.Hero;
import spellEffect.Spell;

public class LongAttack extends Spell {

	public LongAttack() {
		super(300, 10, 8);
		this.slashRange = 0;
		// TODO Auto-generated constructor stub
	}

	@Override
	public void action(Character character, Hero caster) {
		// TODO Auto-generated method stub
		int cx = Math.abs(caster.getX()-character.getX());
		int cy = Math.abs(caster.getY()-character.getY());
		int damage = this.damage+(cx+cy)/2;
		character.doDamage(damage);
	}
}
