package modele;

public class Sommaire {
	private float moyenneJour;
	private float moyenneMois;
	private float moyenneAnnee;
	
	public Sommaire() {
		super();
	}
	
	public Sommaire(float moyenneJour, float moyenneMois, float moyenneAnnee) {
		super();
		this.moyenneJour = moyenneJour;
		this.moyenneMois = moyenneMois;
		this.moyenneAnnee = moyenneAnnee;
	}
	
	public float getMoyenneJour() {
		return moyenneJour;
	}
	public void setMoyenneJour(float moyenneJour) {
		this.moyenneJour = moyenneJour;
	}
	public float getMoyenneMois() {
		return moyenneMois;
	}
	public void setMoyenneMois(float moyenneMois) {
		this.moyenneMois = moyenneMois;
	}
	public float getMoyenneAnnee() {
		return moyenneAnnee;
	}
	public void setMoyenneAnnee(float moyenneAnnee) {
		this.moyenneAnnee = moyenneAnnee;
	}
	
	public String toString() {
		return "moyenneJour : " + this.moyenneJour + "  moyenneMois : " + this.moyenneMois + "  moyenneAnnee : " + this.moyenneAnnee;
	}
	
}
