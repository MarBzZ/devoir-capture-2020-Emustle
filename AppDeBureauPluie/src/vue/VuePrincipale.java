package vue;
import java.util.List;

import com.sun.media.jfxmedia.logging.Logger;

import controleur.ControleurPrincipale;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

public class VuePrincipale extends Vue {

	protected ControleurPrincipale controleur;
	protected static VuePrincipale instance = null; 
	public static VuePrincipale getInstance() {if(null==instance)instance = new VuePrincipale();return VuePrincipale.instance;}; 
	
	private VuePrincipale() 
	{
		super("menu.fxml"); 
		super.controleur = this.controleur = new ControleurPrincipale();
		Logger.logMsg(Logger.INFO, "new VuePrincipale()");
	}
		
	public void activerControles()
	{
		super.activerControles();
	}
		

}