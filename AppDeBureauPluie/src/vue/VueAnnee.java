package vue;

import com.sun.media.jfxmedia.logging.Logger;

import controleur.Controleur;
import controleur.ControleurPrincipale;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class VueAnnee extends Vue{

	protected static VueAnnee instance;
	public static VueAnnee getInstance() {if(null == instance) instance = new VueAnnee(); return instance;}
	protected ControleurPrincipale controleur;
	
	private VueAnnee() 
	{
		super("statistiques-annee.fxml");
		super.controleur = this.controleur = new ControleurPrincipale();
		Logger.logMsg(Logger.INFO, "new VueAnnee()");
	}
	
}
