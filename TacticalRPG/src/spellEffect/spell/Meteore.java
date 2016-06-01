package spellEffect.spell;

import gameObject.Character;

import java.util.List;

import spellEffect.Spell.TypeSpell;

public class Meteore extends spellEffect.Spell{

	public Meteore() {
		super(500, 6, 30, TypeSpell.METEORE);
		// TODO Auto-generated constructor stub
	}

	public void meteore(List<Character> List){
		for(gameObject.Character character : List){
			character.doDamage(this.damage);
		}
	}
}
