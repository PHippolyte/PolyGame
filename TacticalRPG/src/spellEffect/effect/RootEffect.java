package spellEffect.effect;
import gameObject.Character;
public class RootEffect extends spellEffect.Effect{
	int energy;

	public RootEffect() {
		super(2);
		// TODO Auto-generated constructor stub
	}
	
	public void action(Character c){
		this.energy = c.getEnergy();
		c.setEnergy(0);
	}
	
	public void remise(Character c){
		c.setEnergy(energy);
	}
	
}