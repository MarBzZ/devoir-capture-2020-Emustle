package donnee;

import java.util.ArrayList;
import java.util.List;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import modele.Annee;
import modele.Sommaire;

public class SommaireDAO {

	public static final String ANNEE = "annee";
	private static final String BALISE_FERMETURE = "</sommaires>";
	private static SommaireDAO instance;
	private final String fichier = "Sommaire.xml";
	private final String url = "";

	/*public Sommaire getSommaire() {
		Document document = XmlDAO.getXmlParFichier(fichier);
		return paserDocumentEnSommaire(document);
	}*/
	
	public Sommaire getSommaire() {
		Sommaire sommaire = new Sommaire(JourDAO.getInstance().getMoyenneSommaire(),
										 MoisDAO.getInstance().getMoyenneSommaire(),
										 AnneeDAO.getInstance().getMoyenneSommaire());
		return sommaire;
	}
	
	public static SommaireDAO getInstance() {
		if (instance == null)
			instance = new SommaireDAO();
		
		return instance;
	}
}
