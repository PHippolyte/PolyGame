package gameObject;

public abstract class MapObject extends GameObject{
	//attributs des personnage a définir
		protected String name;
		protected int attack;
		protected int defense;
		protected int precision;
		protected int range;
		protected String icone;
		
		public MapObject(){
			super();
		}
		
		public MapObject(int x, int y) {
			super(x, y);
			// TODO Auto-generated constructor stub
		}
		
		public String getName() {
			return name;
		}

		public int getAttack() {
			return attack;
		}

		public int getDefense() {
			return defense;
		}

		public void setNom(String name) {
			this.name = name;
		}

		public void setAttack(int attack) {
			this.attack = attack;
		}

		public void setDefense(int defense) {
			this.defense = defense;
		}
		
		public String getIcone(){
			return this.icone;
		}
}
