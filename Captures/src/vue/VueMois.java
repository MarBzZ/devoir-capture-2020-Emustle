package vue;

import com.sun.media.jfxmedia.logging.Logger;

import controleur.ControleurPeriode;

public class VueMois extends Vue {

	protected ControleurPeriode controleur = null;
	protected static VueMois instance = null; 
	public static VueMois getInstance() {if(null==instance)instance = new VueMois();return VueMois.instance;}; 
	
	private VueMois() 
	{
		super("jour.fxml"); 
		super.controleur = this.controleur = new ControleurPeriode();
		Logger.logMsg(Logger.INFO, "new VueJour()");
	}
	
	public ControleurPeriode getControleur() {return this.controleur;}
}
