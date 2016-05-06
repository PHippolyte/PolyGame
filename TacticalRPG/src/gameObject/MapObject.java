package gameObject;

public abstract class MapObject extends GameObject{
	//attributs des personnage a définir
		protected String name;
		protected int attack;
		protected int defense;
		protected int agility;
		protected String icone;
		
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

		public int getAgility() {
			return agility;
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

		public void setAgility(int agility) {
			this.agility = agility;
		}
		
		public String getIcone(){
			return this.icone;
		}

}
