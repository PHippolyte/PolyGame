package spellEffect.spell;

import gameObject.Character;

import java.util.List;

public class Meteore extends spellEffect.Spell{

	public Meteore() {
		super(500, 6, 30);
		// TODO Auto-generated constructor stub
	}

	void Unstop(List<Character> List){
		for(gameObject.Character character : List){
			character.doDamage(this.damage);
		}
	}
}
