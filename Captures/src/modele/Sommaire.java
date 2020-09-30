package modele;

public class Sommaire {
	private int moyenneJour;
	private int moyenneMois;
	private int moyenneAnnee;
	
	public Sommaire() {
		super();
	}
	
	public Sommaire(int moyenneJour, int moyenneMois, int moyenneAnnee) {
		super();
		this.moyenneJour = moyenneJour;
		this.moyenneMois = moyenneMois;
		this.moyenneAnnee = moyenneAnnee;
	}
	
	public int getMoyenneJour() {
		return moyenneJour;
	}
	public void setMoyenneJour(int moyenneJour) {
		this.moyenneJour = moyenneJour;
	}
	public int getMoyenneMois() {
		return moyenneMois;
	}
	public void setMoyenneMois(int moyenneMois) {
		this.moyenneMois = moyenneMois;
	}
	public int getMoyenneAnnee() {
		return moyenneAnnee;
	}
	public void setMoyenneAnnee(int moyenneAnnee) {
		this.moyenneAnnee = moyenneAnnee;
	}
	
	public String toString() {
		return "moyenneJour : " + this.moyenneJour + "  moyenneMois : " + this.moyenneMois + "  moyenneAnnee : " + this.moyenneAnnee;
	}
	
}
