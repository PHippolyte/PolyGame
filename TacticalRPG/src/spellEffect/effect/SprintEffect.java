package spellEffect.effect;
import gameObject.Character;
public class SprintEffect extends spellEffect.Effect{

	public SprintEffect() {
		super(2);
		// TODO Auto-generated constructor stub
	}
	
	public void action(Character c){
		c.setEnergy(c.getEnergy()+2);
	}
	
	public void remise(Character c){
		c.setEnergy(c.getEnergy()+2);
	}
	
}