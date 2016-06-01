package spellEffect.effect;

import gameObject.Character;

public class LessActionEffect extends spellEffect.Effect{

	public LessActionEffect() {
		super(2);
		// TODO Auto-generated constructor stub
	}
	
	public void action(Character c){
		c.setNbAction(c.getNbAction()-1);
	}
	
	public void remise(Character c){
		c.setNbAction(c.getNbAction()+1);
	}
}