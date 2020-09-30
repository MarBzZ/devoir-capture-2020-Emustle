package donnee;

import java.util.ArrayList;
import java.util.List;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import modele.Annee;
import modele.Mois;

public class AnneeDAO {

	public static final String MOIS = "mois";
	private static AnneeDAO instance;
	private final String fichier = "Annee.xml";
	private final String url = "";

	public List<Annee> getListe() {
		Document document = XmlDAO.getXmlParFichier(fichier);
		return paserDocumentEnListeAnnee(document);
	}
	
	public List<Annee> getListe(String url) {
		if (url != XmlDAO.URL) return null;
		return paserDocumentEnListeAnnee(XmlDAO.getXmlParUrl(this.url, XmlDAO.BALISE_FERMETURE));
	}
	
	private List<Annee> paserDocumentEnListeAnnee(Document document){
		if (document == null) return null;
		
		List<Annee> liste = new ArrayList<Annee>();
		
		NodeList elements = document.getElementsByTagName("precipitation");
		for (int i=0; i < elements.getLength(); i++) {
			Node element = elements.item(i);
			
			if (element.getNodeType() == Node.ELEMENT_NODE) {
				Annee annee = new Annee();
				NodeList champs = element.getChildNodes();
				for (int j=0; j < champs.getLength(); j++) {
					Node champ = champs.item(j);
					if (champ.getNodeType() == Node.ELEMENT_NODE) {
						Element champElement = (Element)champ;
						
						switch (champElement.getTagName()) {
							case MOIS :
								annee.setMois(champElement.getTextContent());
								break;
							case XmlDAO.VALEUR :
								annee.setValeur(Integer.parseInt(champElement.getTextContent()));
								break;
							case XmlDAO.MIN :
								annee.setMin(Integer.parseInt(champElement.getTextContent()));
								break;
							case XmlDAO.MAX :
								annee.setMax(Integer.parseInt(champElement.getTextContent()));
								break;
						}
					}
				}
				
				liste.add(annee);
			}
		}
		
		return liste;
	}
	
	public static AnneeDAO getInstance() {
		if (instance == null)
			instance = new AnneeDAO();
		
		return instance;
	}
}
