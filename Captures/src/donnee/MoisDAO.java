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
import modele.Mois;

public class MoisDAO {

	public static final String JOUR = "jour";
	private static MoisDAO instance;
	private final String fichier = "Mois.xml";
	private final String formatUrl = "%s/annee-%d/mois-%d";

	/*public List<Mois> getListe() {
		Document document = XmlDAO.getXmlParFichier(fichier);
		return paserDocumentEnListeMois(document);
	}*/
	
	public List<Mois> getListe() {
		return paserDocumentEnListeMois(getDocumentParUrl());
	}
	
	public HashMap<String, Float> getStatistique(){
		HashMap<String, Float> statistique = new HashMap<String, Float>();
		Document document = getDocumentParUrl();
		
		NodeList elementsMin = document.getElementsByTagName("min");
		NodeList elementsMoyenne = document.getElementsByTagName("moyenne");
		NodeList elementsMax = document.getElementsByTagName("max");
		
		Element champMin = (Element) elementsMin.item(elementsMin.getLength() -1);
		Element champMoyenne = (Element) elementsMoyenne.item(elementsMoyenne.getLength() -1);
		Element champMax = (Element) elementsMax.item(elementsMax.getLength() -1);
		
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
		int mois = LocalDateTime.now().getMonthValue();*/
		
		//Date Fixe
		int annee = 2019;
		int mois = 12;
		
		String url = String.format(this.formatUrl, XmlDAO.URL, annee, mois);
		return XmlDAO.getXmlParUrl(url, XmlDAO.BALISE_FERMETURE);
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
							case XmlDAO.MOYENNE :
								mois.setMoyenne(Float.parseFloat(champElement.getTextContent()));
								break;
							case XmlDAO.MIN :
								mois.setMin(Float.parseFloat(champElement.getTextContent()));
								break;
							case XmlDAO.MAX :
								mois.setMax(Float.parseFloat(champElement.getTextContent()));
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
