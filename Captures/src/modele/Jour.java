package modele;

public class Jour {

	private String heure;
	private int valeur;
	private int min;
	private int max;
	
	public Jour() {
		super();
	}
	
	public Jour(String heure, int valeur, int min, int max) {
		super();
		this.heure = heure;
		this.valeur = valeur;
		this.min = min;
		this.max = max;
	}
	
	public String getHeure() {
		return heure;
	}
	public void setHeure(String heure) {
		this.heure = heure;
	}
	public int getValeur() {
		return valeur;
	}
	public void setValeur(int valeur) {
		this.valeur = valeur;
	}
	public int getMin() {
		return min;
	}
	public void setMin(int min) {
		this.min = min;
	}
	public int getMax() {
		return max;
	}
	public void setMax(int max) {
		this.max = max;
	}
	
	public String toString() {
		return "heure : " + this.heure + "  valeur : " + this.valeur + "  min : " + this.min + "  max : " + this.max;
	}
}
