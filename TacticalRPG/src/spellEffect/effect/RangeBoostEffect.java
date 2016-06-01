package spellEffect.effect;
import gameObject.Character;
public class RangeBoostEffect extends spellEffect.Effect{

	public RangeBoostEffect() {
		super(2);
		// TODO Auto-generated constructor stub
	}
	
	public void action(Character c){
		c.setRange(c.getRange()+2);
	}
	
	public void remise(Character c){
		c.setRange(c.getRange()-2);
	}
	
}