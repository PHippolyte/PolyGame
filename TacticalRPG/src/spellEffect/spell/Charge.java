package spellEffect.spell;

import gameObject.Character;

import java.util.List;

public class Charge extends spellEffect.Spell{

	public Charge() {
		super(150, 3, 3, TypeSpell.CHARGE);
		// TODO Auto-generated constructor stub
	}

	public void charge(List<Character> List){
		for(gameObject.Character character : List){
			character.doDamage(this.damage);
		}
	}
}