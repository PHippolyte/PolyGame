package ele_jeu;

public abstract class ObjetJeu {
	//protected int x;
	//protected int y;
	protected int att;
	protected int def;
	protected int esq;
	protected int pre;
	protected int porte;
	
	public int getAtt() {
		return att;
	}
	public void setAtt(int att) {
		this.att = att;
	}
	public int getDef() {
		return def;
	}
	public void setDef(int def) {
		this.def = def;
	}
	public int getEsq() {
		return esq;
	}
	public void setEsq(int esq) {
		this.esq = esq;
	}
	public int getPre() {
		return pre;
	}
	public void setPre(int pre) {
		this.pre = pre;
	}
	public int getPorte() {
		return porte;
	}
	public void setPorte(int porte) {
		this.porte = porte;
	}
}
