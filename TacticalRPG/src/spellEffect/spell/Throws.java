package spellEffect.spell;

import gameObject.Character;

import java.util.List;

public class Throws extends spellEffect.Spell{

	public Throws() {
		super(60, 4, 2);
		// TODO Auto-generated constructor stub
	}

	void throwAttack(List<Character> List){
		for(gameObject.Character character : List){
			character.doDamage(this.damage);
		}
	}
}