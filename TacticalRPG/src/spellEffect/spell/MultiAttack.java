package spellEffect.spell;

import gameObject.Character;
import gameObject.Hero;

import java.util.List;


public class MultiAttack extends spellEffect.Spell{

	public MultiAttack() {
		super(150, 4, 1);
		this.slashRange = 1;
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void action(Character character, Hero caster) {
		// TODO Auto-generated method stub
		character.doDamage(this.damage);
		
	}
}