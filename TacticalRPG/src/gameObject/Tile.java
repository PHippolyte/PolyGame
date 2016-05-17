package gameObject;

public abstract class Tile extends MapObject{
	protected int consomation;
	protected Character character;
	
	public Tile(int x, int y) {
		super(x, y);
	}
	
	public int getConsomation(){
		return this.consomation;
	}
	
	public Character getCharacter(){
		return this.character;
	}
	public void setCharacter(Character character){
		this.character = character;
	}
	public void removeCharacter(){
		this.character = null;
	}
	public abstract String getInfo();
}
