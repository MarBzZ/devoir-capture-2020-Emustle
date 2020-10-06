package controleur;

import com.sun.media.jfxmedia.logging.Logger;

import donnee.AnneeDAO;
import donnee.JourDAO;
import donnee.MoisDAO;
import vue.Navigateur;
import vue.VueAnnee;
import vue.VueJour;
import vue.VueMois;

public class ControleurPeriode extends Controleur
{
	
	public ControleurPeriode()
	{
		Logger.logMsg(Logger.INFO, "new ControleurPeriode()");
	}
	
	public void actionOuvrirJour(VueJour vue)
	{
		JourDAO jourDAO = new JourDAO();
		vue.afficherHeures(jourDAO.getListe());
		Navigateur.getInstance().afficherVue(vue);
	}

	public void actionOuvrirMois(VueMois vue) 
	{
		MoisDAO moisDAO = new MoisDAO();
		vue.afficherJours(moisDAO.getListe());
		Navigateur.getInstance().afficherVue(vue);	
	}

	public void actionOuvrirAnnee(VueAnnee vue) 
	{
		AnneeDAO anneeDAO = new AnneeDAO();
		vue.afficherMois(anneeDAO.getListe());
		Navigateur.getInstance().afficherVue(vue);
	}
}
