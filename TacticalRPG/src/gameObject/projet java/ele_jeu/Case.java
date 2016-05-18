package ele_jeu;

public class Case extends ObjetJeu{
	protected int conso;
	protected Type_terrain type;
	public int getConso() {
		return conso;
	}
	public void setConso(int conso) {
		this.conso = conso;
	}
	public Type_terrain getType() {
		return type;
	}
	public void setType(Type_terrain type) {
		this.type = type;
	}
}
