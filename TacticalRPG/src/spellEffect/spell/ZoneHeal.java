package spellEffect.spell;

import java.util.List;

import spellEffect.Effect;
import spellEffect.Spell.TypeSpell;

public class ZoneHeal extends spellEffect.Spell{

	public ZoneHeal() {
		super(250, 2, 4, TypeSpell.ZONEHEAL);
		// TODO Auto-generated constructor stub
	}
	
	public void zoneHeal(List<gameObject.Character> List){
		for(gameObject.Character character : List){
			character.setHealth(damage);
		}
	}
}