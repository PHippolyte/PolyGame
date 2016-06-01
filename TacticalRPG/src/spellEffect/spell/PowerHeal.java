package spellEffect.spell;

import java.util.List;

public class PowerHeal extends spellEffect.Spell{

	public PowerHeal() {
		super(100, 5, 4);
		// TODO Auto-generated constructor stub
	}

	void Zoneheal(List<gameObject.Character> List){
		for(gameObject.Character character : List){
			character.setHealth(damage);
		}
	}

}
