package controleur;

import java.util.List;

import com.sun.media.jfxmedia.logging.Logger;

import donnee.AnneeDAO;
import donnee.JourDAO;
import donnee.MoisDAO;
import donnee.SommaireDAO;
import modele.Annee;
import modele.Jour;
import modele.Mois;
import modele.Sommaire;
import vue.VueJour;
import vue.VueSommaire;

public class ControleurSommaire extends Controleur{

	
	
	public ControleurSommaire()
	{
		Logger.logMsg(Logger.INFO, "new ControleurSommaire()");
		
		//TODO Remove
		testerLesDAO();
		//
	}

	/*public void actionOuvrirCapture(int id) {
		
		Logger.logMsg(Logger.INFO, "new actionOuvrirCapture()");
		VueCapture.getInstance().getControleur().actionOuvrirCapture(id);
		
	}*/
	
	
	//TODO remove
	//TEST DES DAOS
	
	private void testerLesDAO() {
		Logger.logMsg(Logger.INFO, "testerLesDAO => début");
		testerJourDAO();
		testerMoisDAO();
		testerAnneeDAO();
		Sommaire sommaire = SommaireDAO.getInstance().getSommaire();
		Logger.logMsg(Logger.INFO, sommaire.toString());
		Logger.logMsg(Logger.INFO, "testerLesDAO => fin");
	}
	
	private void testerJourDAO() {
		List<Jour> listejours = JourDAO.getInstance().getListe();
		for (Jour jour : listejours) {
			Logger.logMsg(Logger.INFO, jour.toString());
		}
	}
	private void testerMoisDAO() {
		List<Mois> listemois = MoisDAO.getInstance().getListe();
		for (Mois mois : listemois) {
			Logger.logMsg(Logger.INFO, mois.toString());
		}
	}
	private void testerAnneeDAO() {
		List<Annee> listeannee = AnneeDAO.getInstance().getListe();
		for (Annee annee : listeannee) {
			Logger.logMsg(Logger.INFO, annee.toString());
		}
	}
	//
}
