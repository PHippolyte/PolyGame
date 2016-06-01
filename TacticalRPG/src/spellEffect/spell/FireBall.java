package spellEffect.spell;

import gameObject.Character;

import java.util.List;

public class FireBall extends spellEffect.Spell{

	public FireBall() {
		super(100, 3, 6);
		// TODO Auto-generated constructor stub
	}

	void FireDamage(List<Character> List){
		for(gameObject.Character character : List){
			character.doDamage(this.damage);
		}
	}
}
