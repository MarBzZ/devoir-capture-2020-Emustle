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

	public Sommaire getSommaire() {
		Document document = XmlDAO.getXmlParFichier(fichier);
		return paserDocumentEnSommaire(document);
	}
	
	public Sommaire getSommaire(String url) {
		if (url != XmlDAO.URL) return null;
		return paserDocumentEnSommaire(XmlDAO.getXmlParUrl(this.url, BALISE_FERMETURE));
	}
	
	private Sommaire paserDocumentEnSommaire(Document document){
		if (document == null) return null;
		
		Sommaire sommaire = new Sommaire();
	
		NodeList elements = document.getElementsByTagName("sommaire");
		for (int i=0; i < elements.getLength(); i++) {
			Node element = elements.item(i);
			
			if (element.getNodeType() == Node.ELEMENT_NODE) {
				Element champElement = (Element)element;
				
				NodeList typeSommaires = element.getChildNodes();
				for (int j=0; j < typeSommaires.getLength(); j++) {
					Node typeSommaire = typeSommaires.item(j);
					if (typeSommaire.getNodeType() == Node.ELEMENT_NODE) {
						Element typeSommaireElement = (Element)typeSommaire;
						Element Elementvaleur = (Element)typeSommaireElement.getChildNodes().item(1);
						switch (typeSommaireElement.getTagName()) {
							case MoisDAO.JOUR :
								sommaire.setMoyenneJour(Integer.parseInt(Elementvaleur.getTextContent()));
								break;
							case AnneeDAO.MOIS :
								sommaire.setMoyenneMois(Integer.parseInt(Elementvaleur.getTextContent()));
								break;
							case ANNEE :
								sommaire.setMoyenneAnnee(Integer.parseInt(Elementvaleur.getTextContent()));
								break;
						}
						
					}
				}
			}
		}
		
		return sommaire;
	}
	
	public static SommaireDAO getInstance() {
		if (instance == null)
			instance = new SommaireDAO();
		
		return instance;
	}
}
