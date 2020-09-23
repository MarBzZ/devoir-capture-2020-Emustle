package controleur;

import com.sun.media.jfxmedia.logging.Logger;

import donnee.PluieDAO;
import vue.Navigateur;
import vue.Vue;
import vue.VueJour;
import vue.VuePrincipale;

//import vue.Navigateur;
//import vue.*;

public class Controleur {
	
	public Controleur()
	{
		Logger.logMsg(Logger.INFO, "new Controleur()");
	}

	public static Vue selectionnerVuePrincipale()
	{
		return VuePrincipale.getInstance();	
	}
		
}
