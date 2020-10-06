package donnee;

import java.io.ByteArrayInputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringBufferInputStream;
import java.io.StringReader;
import java.io.UnsupportedEncodingException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

public class XmlDAO {

	public static final String URL = "http://51.79.55.148/service.precipitations";
	public static final String VALEUR = "valeur";
	public static final String MOYENNE = "moyenne";
	public static final String MIN = "min";
	public static final String MAX = "max";
	public static final String BALISE_FERMETURE = "</precipitations>";
	
	public void xmlDAO() {
	}
	
	public static Document getXmlParFichier(String fichier) {
        Document doc = null;
        try
        {
        	DocumentBuilder constructeur = DocumentBuilderFactory.newInstance().newDocumentBuilder(); 
        	doc = constructeur.parse(fichier);
        } 
        catch (Exception e) 
        {
            e.printStackTrace();
        }
        
        return doc;
	}
	
	@SuppressWarnings("deprecation")
	public static Document getXmlParUrl(String url, String baliseFermeture) {
		Document doc = null;
		try {
			URL urlDAO = new URL(url);
			InputStream flux = urlDAO.openConnection().getInputStream();
			Scanner lecteur = new Scanner(flux);
			
			lecteur.useDelimiter(baliseFermeture);
			String xml =  lecteur.next() + baliseFermeture;
			
			DocumentBuilder constructeur = DocumentBuilderFactory.newInstance().newDocumentBuilder();
			doc = constructeur.parse(new StringBufferInputStream(xml));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return doc;
	}
}
