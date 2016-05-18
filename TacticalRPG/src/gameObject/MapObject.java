package gameObject;

public abstract class MapObject extends GameObject{
	//attributs des personnage a définir
		protected String name;
		protected int attack;
		protected int attackMagic;
		protected int defense;
		protected int defenseMagic;
		protected int precision;
		protected int precisionMagic;
		protected int dodge;
		protected int resistance;
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

		public int getAttackMagic() {
			return attackMagic;
		}

		public void setAttackMagic(int attackMagic) {
			this.attackMagic = attackMagic;
		}

		public int getDefenseMagic() {
			return defenseMagic;
		}

		public void setDefenseMagic(int defenseMagic) {
			this.defenseMagic = defenseMagic;
		}

		public int getPrecision() {
			return precision;
		}

		public void setPrecision(int precision) {
			this.precision = precision;
		}

		public int getPrecisionMagic() {
			return precisionMagic;
		}

		public void setPrecisionMagic(int precisionMagic) {
			this.precisionMagic = precisionMagic;
		}

		public int getDodge() {
			return dodge;
		}

		public void setDodge(int dodge) {
			this.dodge = dodge;
		}

		public int getResistance() {
			return resistance;
		}

		public void setResistance(int resistance) {
			this.resistance = resistance;
		}
}
