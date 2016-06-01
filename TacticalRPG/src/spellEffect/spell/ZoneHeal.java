package spellEffect.spell;

import java.util.List;

import spellEffect.Effect;

public class ZoneHeal extends spellEffect.Spell{

	public ZoneHeal() {
		super(250, 2, 4);
		// TODO Auto-generated constructor stub
	}
	
	void Zoneheal(List<gameObject.Character> List){
		for(gameObject.Character character : List){
			character.setHealth(damage);
		}
	}
}