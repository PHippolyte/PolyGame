package spellEffect.spell;

import gameObject.Character;

import java.util.List;

public class MultiAttack extends spellEffect.Spell{

	public MultiAttack() {
		super(150, 4, 1);
		// TODO Auto-generated constructor stub
	}

	void multi(List<Character> List){
		for(gameObject.Character character : List){
			character.doDamage(this.damage);
		}
	}
}