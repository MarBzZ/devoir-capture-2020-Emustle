package vue;

import com.sun.media.jfxmedia.logging.Logger;

import controleur.ControleurPeriode;

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
}
