package spellEffect.effect;
import gameObject.Character;
public class MagicBoostEffect extends spellEffect.Effect{

	public MagicBoostEffect() {
		super(2);
		// TODO Auto-generated constructor stub
	}
	
	public void action(Character c){
		c.setAttackMagic(c.getAttackMagic()+2);
	}
	
	public void remise(Character c){
		c.setAttackMagic(c.getAttackMagic()-2);
	}
	
}