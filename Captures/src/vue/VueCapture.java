package vue;

import com.sun.media.jfxmedia.logging.Logger;

import controleur.ControleurCapture;

public class VueCapture extends Vue {

	protected ControleurCapture controleur = null;
	protected static VueCapture instance = null; 
	public static VueCapture getInstance() {if(null==instance)instance = new VueCapture();return VueCapture.instance;}; 
	
	private VueCapture() 
	{
		super("periode.fxml"); 
		super.controleur = this.controleur = new ControleurCapture();
		Logger.logMsg(Logger.INFO, "new VueCollection()");
	}
	
	public ControleurCapture getControleur() {return this.controleur;}
}
