package modele;

public class Annee {

	private String mois;
	private float moyenne;
	private float min;
	private float max;

	public Annee() {
		super();
	}
	
	public Annee(String mois, float moyenne, float min, float max) {
		super();
		this.mois = mois;
		this.moyenne = moyenne;
		this.min = min;
		this.max = max;
	}
	
	public String getMois() {
		return mois;
	}
	public void setMois(String mois) {
		this.mois = mois;
	}
	public float getMoyenne() {
		return moyenne;
	}
	public void setMoyenne(float moyenne) {
		this.moyenne = moyenne;
	}
	public float getMin() {
		return min;
	}
	public void setMin(float min) {
		this.min = min;
	}
	public float getMax() {
		return max;
	}
	public void setMax(float max) {
		this.max = max;
	}
	
	public String toString() {
		return "mois : " + this.mois + "  moyenne : " + this.moyenne + "  min : " + this.min + "  max : " + this.max;
	}
}
