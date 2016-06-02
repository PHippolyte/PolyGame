package spellEffect.effect;

import gameObject.Character;

public class DodgeBoostEffect extends spellEffect.Effect{

	public DodgeBoostEffect() {
		super(2);
		// TODO Auto-generated constructor stub
	}
	
	public void action(Character c){
		c.setDodge(c.getDodge()+2);
	}
	
	public void remise(Character c){
		c.setDodge(c.getDodge()-2);
	}
	
}