package donnee;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
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
	private final String formatUrl = "%s/annee-%d/mois-%d/jour-%d";

	/*public List<Jour> getListe() {
		Document document = XmlDAO.getXmlParFichier(fichier);
		return paserDocumentEnListeJour(document);
	}*/
	
	public List<Jour> getListe() {
		return paserDocumentEnListeJour(getDocumentParUrl());
	}
	
	public HashMap<String, Float> getStatistique(){
		HashMap<String, Float> statistique = new HashMap<String, Float>();
		Element champMin = (Element)(getDocumentParUrl().getElementsByTagName("min")).item(1);
		Element champMoyenne = (Element)(getDocumentParUrl().getElementsByTagName("moyenne")).item(1);
		Element champMax = (Element)(getDocumentParUrl().getElementsByTagName("max")).item(1);
		
		statistique.put("min", Float.parseFloat(champMin.getTextContent()));
		statistique.put("moyenne", Float.parseFloat(champMoyenne.getTextContent()));
		statistique.put("max", Float.parseFloat(champMax.getTextContent()));

		return statistique;
	}
	
	public float getMoyenneSommaire() {
		Element champMoyenne = (Element)(getDocumentParUrl().getElementsByTagName("moyenne")).item(1);
		return Float.parseFloat(champMoyenne.getTextContent());
	}
	
	private Document getDocumentParUrl() {
		//Date automatique
		/*int annee = LocalDateTime.now().getYear();
		int mois = LocalDateTime.now().getMonthValue();
		int jour = LocalDateTime.now().getDayOfMonth();*/
		
		//Date Fixe
		int annee = 2019;
		int mois = 12;
		int jour = 23;
		
		String url = String.format(this.formatUrl, XmlDAO.URL, annee, mois, jour);
		return XmlDAO.getXmlParUrl(url, XmlDAO.BALISE_FERMETURE);
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
								jour.setHeure(String.format("%s:00",champElement.getTextContent()));
								break;
							case XmlDAO.MOYENNE :
								jour.setMoyenne(Float.parseFloat(champElement.getTextContent()));
								break;
							case XmlDAO.MIN :
								jour.setMin(Float.parseFloat(champElement.getTextContent()));
								break;
							case XmlDAO.MAX :
								jour.setMax(Float.parseFloat(champElement.getTextContent()));
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
