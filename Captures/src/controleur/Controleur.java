package controleur;

import modele.PrecipitationDAO;
import vue.Vue;
import vue.VueCaptures;

//import vue.Navigateur;
//import vue.*;

public class Controleur {

	public static Vue selectionnerVuePrincipale()
	{	
		PrecipitationDAO precipitationDAO = new PrecipitationDAO();
		VueCaptures.getInstance().afficherCaptures(precipitationDAO.listerCaptures());
		return VueCaptures.getInstance();
	}
		
}
