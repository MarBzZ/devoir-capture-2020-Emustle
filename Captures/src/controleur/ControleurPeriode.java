package controleur;

import com.sun.media.jfxmedia.logging.Logger;

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
		Navigateur.getInstance().afficherVue(vue);
	}

	public void actionOuvrirMois(VueMois vue) 
	{
		Navigateur.getInstance().afficherVue(vue);	
	}

	public void actionOuvrirAnnee(VueAnnee vue) 
	{
		Navigateur.getInstance().afficherVue(vue);
	}
}
