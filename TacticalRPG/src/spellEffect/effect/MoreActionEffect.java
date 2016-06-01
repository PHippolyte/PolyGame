package spellEffect.effect;

public class MoreActionEffect extends spellEffect.Effect{

	public MoreActionEffect(gameObject.Character character) {
		super(character, 2);
		// TODO Auto-generated constructor stub
	}
	
	public void moreAction(){
		this.character.setNbAction(this.character.getNbAction()+1);
	}
	
	public void remise(){
		this.character.setNbAction(this.character.getNbAction()-1);
	}
}