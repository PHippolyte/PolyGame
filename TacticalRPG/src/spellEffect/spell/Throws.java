package spellEffect.spell;

import gameObject.Character;

import java.util.List;

import spellEffect.Spell.TypeSpell;

public class Throws extends spellEffect.Spell{

	public Throws() {
		super(60, 4, 2, TypeSpell.THROWS);
		// TODO Auto-generated constructor stub
	}

	public void throwAttack(List<Character> List){
		for(gameObject.Character character : List){
			character.doDamage(this.damage);
		}
	}
}