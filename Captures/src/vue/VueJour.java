package vue;

import java.util.List;

import com.sun.media.jfxmedia.logging.Logger;

import controleur.ControleurPeriode;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import modele.Jour;
import modele.Mois;

public class VueJour extends Vue {

	protected ControleurPeriode controleur = null;
	protected static VueJour instance = null; 
	public static VueJour getInstance() {if(null==instance)instance = new VueJour();return VueJour.instance;}; 
	
	private VueJour() 
	{
		super("jour.fxml"); 
		super.controleur = this.controleur = new ControleurPeriode();
		Logger.logMsg(Logger.INFO, "new VueJour()");
	}
	
	public ControleurPeriode getControleur() {return this.controleur;}
	
	public void activerControles()
	{
		super.activerControles();
		
		Button actionAccueil = (Button) lookup("#btn-accueil");
		actionAccueil.setOnAction(new EventHandler<ActionEvent>() 
		{
            @Override public void handle(ActionEvent e) 
            {
            	Logger.logMsg(Logger.INFO, "Bouton Accueil Activer");
            	VueSommaire.getInstance().getControleur().actionOuvrirSommaire(VueSommaire.getInstance());
            }
        });
		
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
	
	public void afficherHeures(List<Jour> jours)
    {
        // Récupération de l'objet dans lequel afficher
        TableView tableau = (TableView)lookup("#tableau");

        // Association des champs de l'objet avec les colonnes du tableau
        TableColumn colonneHeure = (TableColumn) tableau.getColumns().get(0);
        TableColumn colonneValeur = (TableColumn) tableau.getColumns().get(1);
        TableColumn colonneMin = (TableColumn) tableau.getColumns().get(2);
        TableColumn colonneMax = (TableColumn) tableau.getColumns().get(3);
        colonneHeure.setCellValueFactory(new PropertyValueFactory<>("heure"));
        colonneValeur.setCellValueFactory(new PropertyValueFactory<>("moyenne"));
        colonneMin.setCellValueFactory(new PropertyValueFactory<>("min"));
        colonneMax.setCellValueFactory(new PropertyValueFactory<>("max"));

        // Ajout des données
        for(Jour jour : jours)
        {
            tableau.getItems().add(jour);
        }
    }
}
