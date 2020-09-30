package vue;
import java.util.List;

import com.sun.media.jfxmedia.logging.Logger;

import controleur.ControleurSommaire;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class VueSommaire extends Vue {

	protected ControleurSommaire controleur;
	protected static VueSommaire instance = null; 
	public static VueSommaire getInstance() {if(null==instance)instance = new VueSommaire();return VueSommaire.instance;}; 
	
	private VueSommaire() 
	{
		super("sommaire.fxml"); 
		super.controleur = this.controleur = new ControleurSommaire();
		Logger.logMsg(Logger.INFO, "new VueSommaire()");
	}
	
	public ControleurSommaire getControleur() {return this.controleur;}
	
	public void afficherSommaire(modele.Sommaire sommaire)
	{
			Logger.logMsg(Logger.INFO, "afficherSommaire()");
			Label moyenneJour = (Label)lookup("#moyenne-jour");
			Label moyenneMois = (Label)lookup("#moyenne-mois");
			Label moyenneAnnee = (Label)lookup("#moyenne-annee");
			moyenneJour.setText(sommaire.getMoyenneJour() + "mm");
			moyenneMois.setText(sommaire.getMoyenneMois() + "mm");
			moyenneAnnee.setText(sommaire.getMoyenneAnnee() + "mm");

	}
		
	public void activerControles()
	{
		super.activerControles();
		
		
		Button actionJour = (Button) lookup("#btn-jour");
		actionJour.setOnAction(new EventHandler<ActionEvent>() 
		{
            @Override public void handle(ActionEvent e) 
            {
            	Logger.logMsg(Logger.INFO, "Bouton Jour Activer");
            	VueJour.getInstance().getControleur().actionOuvrirJour(VueJour.getInstance());
            }
        });
		
		Button actionMois = (Button) lookup("#btn-mois");
		actionMois.setOnAction(new EventHandler<ActionEvent>() 
		{
            @Override public void handle(ActionEvent e) 
            {
            	Logger.logMsg(Logger.INFO, "Bouton Mois Activer");
            	VueMois.getInstance().getControleur().actionOuvrirMois(VueMois.getInstance());
            }
        });
		
		Button actionAnnee = (Button) lookup("#btn-annee");
		actionAnnee.setOnAction(new EventHandler<ActionEvent>() 
		{
            @Override public void handle(ActionEvent e) 
            {
            	Logger.logMsg(Logger.INFO, "Bouton Annee Activer");
            	VueAnnee.getInstance().getControleur().actionOuvrirAnnee(VueAnnee.getInstance());
            }
        });
		

	}
}
