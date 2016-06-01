package spellEffect.spell;

import java.util.List;

import gameObject.Character;
import gameObject.Hero;

public class PowerHeal extends spellEffect.Spell{

	public PowerHeal() {
		super(100, 5, 4);
		this.type = Type.HEAL;
		this.slashRange = 0;
		// TODO Auto-generated constructor stub
	}

	@Override
	public void action(Character character, Hero caster) {
		// TODO Auto-generated method stub
		character.heal(this.damage);
	}

}
