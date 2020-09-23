package vue;

import java.util.List;

import com.sun.media.jfxmedia.logging.Logger;

import controleur.Controleur;
import controleur.ControleurPrincipale;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

public class VueMois extends Vue {

	protected ControleurPrincipale controleur = null;
	protected static VueMois instance = null; 
	public static VueMois getInstance() {if(null==instance)instance = new VueMois();return VueMois.instance;}; 
	
	private VueMois() 
	{
		super("statistiques-mois.fxml"); 
		super.controleur = this.controleur = new ControleurPrincipale();
		Logger.logMsg(Logger.INFO, "new VueMois()");
	}
	
	public Controleur getControleur() {return this.controleur;}
		
	
}
