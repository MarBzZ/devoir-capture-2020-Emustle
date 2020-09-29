package controleur;

import com.sun.media.jfxmedia.logging.Logger;

import vue.Navigateur;

public class ControleurCapture extends Controleur
{
	
	public ControleurCapture()
	{
		Logger.logMsg(Logger.INFO, "new ControleurCapture()");
	}
	
	public void actionOuvrirCapture(int numero)
	{
		/*Logger.logMsg(Logger.INFO, "new actionOuvrirCollection()");
		this.collection = collectionDAO.detaillerCollection(numero);
		VueCollection.getInstance().afficherCollection(this.collection);
		this.oeuvres = oeuvreDAO.listerOeuvres(numero);
		VueCollection.getInstance().afficherOeuvres(this.oeuvres);
		Navigateur.getInstance().afficherVue(VueCollection.getInstance());*/
	}
}
