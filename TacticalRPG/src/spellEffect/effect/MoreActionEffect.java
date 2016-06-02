package spellEffect.effect;
import gameObject.Character;
public class MoreActionEffect extends spellEffect.Effect{

	public MoreActionEffect() {
		super(2);
		// TODO Auto-generated constructor stub
	}
	
	public void action(Character c){
		c.setNbAction(c.getNbAction()+1);
	}
	
	public void remise(Character c){
		c.setNbAction(c.getNbAction()-1);
	}
}