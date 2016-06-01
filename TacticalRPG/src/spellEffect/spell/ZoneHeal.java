package spellEffect.spell;


import gameObject.Character;
import gameObject.Hero;

public class ZoneHeal extends spellEffect.Spell{

	public ZoneHeal() {
		super(250, 2, 4);
		this.type = Type.HEAL;
		this.slashRange = 2;
		// TODO Auto-generated constructor stub
	}

	@Override
	public void action(Character character, Hero caster) {
		character.heal(damage);
		
	}
}