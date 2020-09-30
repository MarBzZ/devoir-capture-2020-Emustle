package vue;

import com.sun.media.jfxmedia.logging.Logger;

import controleur.ControleurPeriode;

public class VueAnnee extends Vue {

	protected ControleurPeriode controleur = null;
	protected static VueAnnee instance = null; 
	public static VueAnnee getInstance() {if(null==instance)instance = new VueAnnee();return VueAnnee.instance;}; 
	
	private VueAnnee() 
	{
		super("jour.fxml"); 
		super.controleur = this.controleur = new ControleurPeriode();
		Logger.logMsg(Logger.INFO, "new VueJour()");
	}
	
	public ControleurPeriode getControleur() {return this.controleur;}
}
