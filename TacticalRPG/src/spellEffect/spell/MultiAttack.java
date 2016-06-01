package spellEffect.spell;

import gameObject.Character;

import java.util.List;

import spellEffect.Spell.TypeSpell;

public class MultiAttack extends spellEffect.Spell{

	public MultiAttack() {
		super(150, 4, 1, TypeSpell.MULTIATTACK);
		// TODO Auto-generated constructor stub
	}

	public void multiA(List<Character> List){
		for(gameObject.Character character : List){
			character.doDamage(this.damage);
		}
	}
}