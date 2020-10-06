package modele;

public class Mois {

	private int jour;
	private float moyenne;
	private float min;
	private float max;
	
	public Mois() {
		super();
	}
	
	public Mois(int jour, float moyenne, float min, float max) {
		super();
		this.jour = jour;
		this.moyenne = moyenne;
		this.min = min;
		this.max = max;
	}
	
	public int getJour() {
		return jour;
	}
	public void setJour(int jour) {
		this.jour = jour;
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
		return "jour : " + this.jour + "  moyenne : " + this.moyenne + "  min : " + this.min + "  max : " + this.max;
	}
}
