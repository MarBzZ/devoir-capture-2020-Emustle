package controleur;

import com.sun.media.jfxmedia.logging.Logger;

import vue.VueCapture;
import vue.VueCaptures;

public class ControleurCaptures extends Controleur{

	public ControleurCaptures()
	{
		Logger.logMsg(Logger.INFO, "new ControleurCaptures()");
	}

	public void actionOuvrirCapture(int id) {
		
		Logger.logMsg(Logger.INFO, "new actionOuvrirCapture()");
		VueCapture.getInstance().getControleur().actionOuvrirCapture(id);
		
	}


}
