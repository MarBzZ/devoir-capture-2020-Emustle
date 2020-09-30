package donnee;

import java.util.ArrayList;
import java.util.List;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import modele.Jour;

public class JourDAO {

	private static JourDAO instance;
	private static final String HEURE = "heure";
	private final String fichier = "Jour.xml";
	private final String url = "";

	public List<Jour> getListe() {
		Document document = XmlDAO.getXmlParFichier(fichier);
		return paserDocumentEnListeJour(document);
	}
	
	public List<Jour> getListe(String url) {
		if (url != XmlDAO.URL) return null;
		return paserDocumentEnListeJour(XmlDAO.getXmlParUrl(this.url, XmlDAO.BALISE_FERMETURE));
	}
	
	private List<Jour> paserDocumentEnListeJour(Document document){
		if (document == null) return null;
		
		List<Jour> liste = new ArrayList<Jour>();
		
		NodeList elements = document.getElementsByTagName("precipitation");
		for (int i=0; i < elements.getLength(); i++) {
			Node element = elements.item(i);
			
			if (element.getNodeType() == Node.ELEMENT_NODE) {
				Jour jour = new Jour();
				NodeList champs = element.getChildNodes();
				for (int j=0; j < champs.getLength(); j++) {
					Node champ = champs.item(j);
					if (champ.getNodeType() == Node.ELEMENT_NODE) {
						Element champElement = (Element)champ;
						
						switch (champElement.getTagName()) {
							case HEURE :
								jour.setHeure(champElement.getTextContent());
								break;
							case XmlDAO.VALEUR :
								jour.setValeur(Integer.parseInt(champElement.getTextContent()));
								break;
							case XmlDAO.MIN :
								jour.setMin(Integer.parseInt(champElement.getTextContent()));
								break;
							case XmlDAO.MAX :
								jour.setMax(Integer.parseInt(champElement.getTextContent()));
								break;
						}
					}
				}
				
				liste.add(jour);
			}
		}
		
		return liste;
	}
	
	
	public static JourDAO getInstance() {
		if (instance == null)
			instance = new JourDAO();
		
		return instance;
	}
}
