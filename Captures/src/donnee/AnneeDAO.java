package donnee;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.sun.media.jfxmedia.logging.Logger;

import modele.Annee;
import modele.Mois;

public class AnneeDAO {

	public static final String MOIS = "mois";
	public static final String[] LISTEMOIS = {"Janvier", "Février",
											  "Mars", "Avril",
											  "Mai", "Juin",
											  "Juillet", "Août",
											  "Septembre", "Octobre",
											  "Novembre", "Décembre"
											 };
	private static AnneeDAO instance;
	private final String fichier = "Annee.xml";
	private final String formatUrl = "%s/annee-%d";
	

	/*public List<Annee> getListe() {
		Document document = XmlDAO.getXmlParFichier(fichier);
		return paserDocumentEnListeAnnee(document);
	}*/
	
	public List<Annee> getListe() {
		return paserDocumentEnListeAnnee(getDocumentParUrl());
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
		//int annee = LocalDateTime.now().getYear();
		
		//Date Fixe
		int annee = 2019;
		
		String url = String.format(this.formatUrl, XmlDAO.URL, annee);
		Logger.logMsg(Logger.INFO, "DAO request on : " + url);
		return XmlDAO.getXmlParUrl(url , XmlDAO.BALISE_FERMETURE);
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
								String mois = LISTEMOIS[Integer.parseInt(champElement.getTextContent())-1];
								annee.setMois(mois);
								break;
							case XmlDAO.MOYENNE :
								annee.setMoyenne(Float.parseFloat(champElement.getTextContent()));
								break;
							case XmlDAO.MIN :
								annee.setMin(Float.parseFloat(champElement.getTextContent()));
								break;
							case XmlDAO.MAX :
								annee.setMax(Float.parseFloat(champElement.getTextContent()));
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
