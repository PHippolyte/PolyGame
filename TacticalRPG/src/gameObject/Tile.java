package gameObject;

public abstract class Tile extends MapObject{
	public enum TypeTile {WATER, BUILDING, BRIDGE, MOUNTAIN, FOREST, LAND}
	
	protected int consomation;
	protected Character character;
	protected TypeTile typeTile;
	
	public Tile(int x, int y, int attack, int attackMagic, int defense, int defenseMagic, int precision, int dodge, int range, int consomation, TypeTile typeTile){
		super(x, y);
		this.attack = attack;
		this.attackMagic = attackMagic;
		this.defense = defense;
		this.defenseMagic = defenseMagic;
		this.precision = precision;
		this.dodge = dodge;
		this.range = range;
		this.typeTile = typeTile;
		this.consomation = consomation;
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

	public TypeTile getTypeTile() {
		return typeTile;
	}
}
