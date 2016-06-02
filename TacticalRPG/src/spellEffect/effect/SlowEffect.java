package spellEffect.effect;
import gameObject.Character;
public class SlowEffect extends spellEffect.Effect{

	public SlowEffect() {
		super(2);
		// TODO Auto-generated constructor stub
	}
	
	public void action(Character c){
		c.setEnergy(c.getEnergy()-2);
	}
	
	public void remise(Character c){
		c.setEnergy(c.getEnergy()+2);
	}
	
}