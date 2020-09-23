package vue;

import com.sun.media.jfxmedia.logging.Logger;

import controleur.Controleur;
import controleur.ControleurPrincipale;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;


public class VueJour extends Vue{

	protected static VueJour instance;
	public static VueJour getInstance() {if(null == instance) instance = new VueJour(); return instance;}
	protected ControleurPrincipale controleur;
	
	private VueJour() 
	{
		super("statistiques-jour.fxml");
		super.controleur = this.controleur = new ControleurPrincipale();
		Logger.logMsg(Logger.INFO, "new VueJour()");
	}
	
}
