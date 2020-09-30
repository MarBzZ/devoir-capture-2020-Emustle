package modele;

public class Annee {

	private String mois;
	private int valeur;
	private int min;
	private int max;

	public Annee() {
		super();
	}
	
	public Annee(String mois, int valeur, int min, int max) {
		super();
		this.mois = mois;
		this.valeur = valeur;
		this.min = min;
		this.max = max;
	}
	
	public String getMois() {
		return mois;
	}
	public void setMois(String mois) {
		this.mois = mois;
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
		return "mois : " + this.mois + "  valeur : " + this.valeur + "  min : " + this.min + "  max : " + this.max;
	}
}
