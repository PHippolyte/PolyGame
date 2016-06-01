package spellEffect.spell;

import gameObject.Character;

import java.util.List;

import spellEffect.Spell.TypeSpell;

public class MultiArrow extends spellEffect.Spell{

	public MultiArrow() {
		super(150, 3, 3, TypeSpell.MULTIARROW);
		// TODO Auto-generated constructor stub
	}

	public void multi(List<Character> List){
		for(gameObject.Character character : List){
			character.doDamage(this.damage);
		}
	}
}