package modele;

public class Jour {

	private String heure;
	private float moyenne;
	private float min;
	private float max;
	
	public Jour() {
		super();
	}
	
	public Jour(String heure, float moyenne, float min, float max) {
		super();
		this.heure = heure;
		this.moyenne = moyenne;
		this.min = min;
		this.max = max;
	}
	
	public String getHeure() {
		return heure;
	}
	public void setHeure(String heure) {
		this.heure = heure;
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
		return "heure : " + this.heure + "  moyenne : " + this.moyenne + "  min : " + this.min + "  max : " + this.max;
	}
}
