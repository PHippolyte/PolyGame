package spellEffect.spell;

import gameObject.Character;

import java.util.List;

import spellEffect.Spell.TypeSpell;

public class UnstopableAttack extends spellEffect.Spell{

	public UnstopableAttack() {
		super(60, 6, 1, TypeSpell.UNSTOPABLEATTACK);
		// TODO Auto-generated constructor stub
	}

	public void unStop(List<Character> List){
		for(gameObject.Character character : List){
			character.doDamage(this.damage);
		}
	}
}
