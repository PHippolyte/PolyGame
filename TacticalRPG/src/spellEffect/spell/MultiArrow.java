package spellEffect.spell;

import gameObject.Character;
import gameObject.Hero;
public class MultiArrow extends spellEffect.Spell{

	public MultiArrow() {
		super(150, 3, 3);
		this.type = Type.DAMAGE;
		this.slashRange = 1;
		this.load("pluisdefleche.png");
		// TODO Auto-generated constructor stub
	}
	@Override
	public void action(Character character, Hero caster) {
		// TODO Auto-generated method stub
		character.doDamage(this.damage);
	}
}