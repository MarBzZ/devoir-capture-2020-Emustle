package controleur;

import com.sun.media.jfxmedia.logging.Logger;

import donnee.SommaireDAO;
import vue.Vue;
import vue.VueJour;
import vue.VueSommaire;

//import vue.Navigateur;
//import vue.*;

public class Controleur {

	public static Vue selectionnerVuePrincipale()
	{	
		Logger.logMsg(Logger.INFO, "new SelectionnerVuePrincipale()");
		SommaireDAO sommaireDAO = new SommaireDAO();
		VueSommaire.getInstance().afficherSommaire(sommaireDAO.getInstance().getSommaire());
		return VueSommaire.getInstance();
		
	}
		
}
