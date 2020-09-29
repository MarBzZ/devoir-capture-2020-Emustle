package vue;
import java.util.List;

import com.sun.media.jfxmedia.logging.Logger;

import controleur.ControleurCaptures;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

public class VueCaptures extends Vue {

	protected ControleurCaptures controleur;
	protected static VueCaptures instance = null; 
	public static VueCaptures getInstance() {if(null==instance)instance = new VueCaptures();return VueCaptures.instance;}; 
	
	private VueCaptures() 
	{
		super("captures.fxml"); 
		super.controleur = this.controleur = new ControleurCaptures();
		Logger.logMsg(Logger.INFO, "new VueCaptures()");
	}
	
	public ControleurCaptures getControleur() {return this.controleur;}
	
	public void afficherCaptures(List<modele.Precipitation> precipitations)
	{
		int position = 1;
		for(modele.Precipitation precipitation : precipitations)
		{
			Button libelle = (Button)lookup("#btn-" + position);
			//System.out.println(precipitation.getNom());
			//libelle.setText(precipitation.getNom());
			//libelle.setId(precipitation.getId()+""); // l'id est changé mais on n'a plus besoin de recuperer l'objet
			
			libelle.setOnAction(new EventHandler<ActionEvent>() 
			{
	            @Override public void handle(ActionEvent e) 
	            {
	            	Logger.logMsg(Logger.INFO, "Bouton Collection active");
	            	Button bouton = (Button)e.getSource();
	            	controleur.actionOuvrirCapture(Integer.parseInt(bouton.getId()));
	            }
	        });

			position++;
			if(position > 4) break;
			}
		}/*
		
	public void activerControles()
	{
		super.activerControles();
		
		/*
		Button actionCalculatrice = (Button) lookup("#action-calculatrice");
		actionCalculatrice.setOnAction(new EventHandler<ActionEvent>() 
		{
            @Override public void handle(ActionEvent e) 
            {
            	Logger.logMsg(Logger.INFO, "Bouton Calculatrice activÃ©");
            	controleur.notifierEvenement(ActionNavigation.CALCULATRICE);
            }
        });
		*/

	}

