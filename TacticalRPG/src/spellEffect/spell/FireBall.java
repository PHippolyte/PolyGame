package spellEffect.spell;

import gameObject.Character;

import java.util.List;

import spellEffect.Spell.TypeSpell;

public class FireBall extends spellEffect.Spell{

	public FireBall() {
		super(100, 3, 6, TypeSpell.FIREBALL);
		// TODO Auto-generated constructor stub
	}

	public void FireDamage(List<Character> List){
		for(gameObject.Character character : List){
			character.doDamage(this.damage);
		}
	}
}
