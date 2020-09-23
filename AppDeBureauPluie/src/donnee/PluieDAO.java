package donnee;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


public class PluieDAO {

	public List<modele.Pluie> listerCollections()
	{
		Connection connection = BaseDeDonnees.getInstance().getConnection();
		
		List<modele.Pluie> listeCollections =  new ArrayList<modele.Pluie>();			
		Statement requeteListeCollections;
		try {
			requeteListeCollections = connection.createStatement();
			ResultSet curseurListeCollections = requeteListeCollections.executeQuery("SELECT * from collection");
			while(curseurListeCollections.next())
			{
				int id = curseurListeCollections.getInt("id");
				String nom = curseurListeCollections.getString("nom");
				modele.Pluie collection = new modele.Pluie();
				collection.setId(id);
				collection.setNom(nom);
				listeCollections.add(collection);
			}
		} catch (SQLException e) {
				e.printStackTrace();
		}
		
		return listeCollections;
	}

	public modele.Pluie detaillerCollection(int numero)
	{
		Connection connection = BaseDeDonnees.getInstance().getConnection();
		
		modele.Pluie collection =  new modele.Pluie();			
		PreparedStatement requeteCollection;
			try {
				requeteCollection = connection.prepareStatement("SELECT * from collection WHERE id = ?");
				requeteCollection.setInt(1, numero);
				
				ResultSet curseurCollection = requeteCollection.executeQuery();
				curseurCollection.next();
				int id = curseurCollection.getInt("id");
				String nom = curseurCollection.getString("nom");
				String description = curseurCollection.getString("description");
				collection.setId(id);
				collection.setNom(nom);
				collection.setDescription(description);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		
		return collection;
	}
	
}
