package spellEffect.spell;

import gameObject.Character;

import java.util.List;

public class UnstopableAttack extends spellEffect.Spell{

	public UnstopableAttack() {
		super(60, 6, 1);
		// TODO Auto-generated constructor stub
	}

	void Unstop(List<Character> List){
		for(gameObject.Character character : List){
			character.doDamage(this.damage);
		}
	}
}
