package modele;

public class Mois {

	private int jour;
	private int valeur;
	private int min;
	private int max;
	
	public Mois() {
		super();
	}
	
	public Mois(int jour, int valeur, int min, int max) {
		super();
		this.jour = jour;
		this.valeur = valeur;
		this.min = min;
		this.max = max;
	}
	
	public int getJour() {
		return jour;
	}
	public void setJour(int jour) {
		this.jour = jour;
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
		return "jour : " + this.jour + "  valeur : " + this.valeur + "  min : " + this.min + "  max : " + this.max;
	}
}
