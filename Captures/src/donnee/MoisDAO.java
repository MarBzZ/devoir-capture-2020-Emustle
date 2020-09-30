package donnee;

import java.util.ArrayList;
import java.util.List;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import modele.Jour;
import modele.Mois;

public class MoisDAO {

	public static final String JOUR = "jour";
	private static MoisDAO instance;
	private final String fichier = "Mois.xml";
	private final String url = "";

	public List<Mois> getListe() {
		Document document = XmlDAO.getXmlParFichier(fichier);
		return paserDocumentEnListeMois(document);
	}
	
	public List<Mois> getListe(String url) {
		if (url != XmlDAO.URL) return null;
		return paserDocumentEnListeMois(XmlDAO.getXmlParUrl(this.url, XmlDAO.BALISE_FERMETURE));
	}
	
	private List<Mois> paserDocumentEnListeMois(Document document){
		if (document == null) return null;
		
		List<Mois> liste = new ArrayList<Mois>();
		
		NodeList elements = document.getElementsByTagName("precipitation");
		for (int i=0; i < elements.getLength(); i++) {
			Node element = elements.item(i);
			
			if (element.getNodeType() == Node.ELEMENT_NODE) {
				Mois mois = new Mois();
				NodeList champs = element.getChildNodes();
				for (int j=0; j < champs.getLength(); j++) {
					Node champ = champs.item(j);
					if (champ.getNodeType() == Node.ELEMENT_NODE) {
						Element champElement = (Element)champ;
						
						switch (champElement.getTagName()) {
							case JOUR :
								mois.setJour(Integer.parseInt(champElement.getTextContent()));
								break;
							case XmlDAO.VALEUR :
								mois.setValeur(Integer.parseInt(champElement.getTextContent()));
								break;
							case XmlDAO.MIN :
								mois.setMin(Integer.parseInt(champElement.getTextContent()));
								break;
							case XmlDAO.MAX :
								mois.setMax(Integer.parseInt(champElement.getTextContent()));
								break;
						}
					}
				}
				
				liste.add(mois);
			}
		}
		
		return liste;
	}
	
	public static MoisDAO getInstance() {
		if (instance == null)
			instance = new MoisDAO();
		
		return instance;
	}
}
