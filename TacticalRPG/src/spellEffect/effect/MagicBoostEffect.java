package spellEffect.effect;

public class MagicBoostEffect extends spellEffect.Effect{

	public MagicBoostEffect(gameObject.Character character) {
		super(character, 2);
		// TODO Auto-generated constructor stub
	}
	
	public void boost(){
		this.character.setAttackMagic(this.character.getAttackMagic()+2);
	}
	
	public void remise(){
		this.character.setAttackMagic(this.character.getAttackMagic()-2);
	}
	
}