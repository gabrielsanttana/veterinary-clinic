package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SpeciesDAO extends DAO {
	  private static SpeciesDAO instance;

	    private SpeciesDAO() {
	        DAO.getConnection();
	    }

	    // Singleton
	    public static SpeciesDAO getInstance() {
	        if (instance == null) {
	            instance = new SpeciesDAO();
	        }
	        return instance;
	    }
	    
	    public boolean createTable() {
	    	try {
	            PreparedStatement stmt;
	            stmt = DAO.getConnection().prepareStatement("CREATE TABLE IF NOT EXISTS species( " + 
	            		"                        id INTEGER PRIMARY KEY, " + 
	            		"                        speciesName  VARCHAR)");
	            executeUpdate(stmt);
	            
	            return true;
	        } catch (SQLException ex) {
	            Logger.getLogger(SpeciesDAO.class.getName()).log(Level.SEVERE, null, ex);
	        }
	    	
	    	return false;
	    }

	// Partial CRUD    
	    // Create
	    public void addSpecies(String speciesName) {
	        try {
	            PreparedStatement stmt;
	            stmt = DAO.getConnection().prepareStatement("INSERT INTO species (speciesName) VALUES (?)");
	            stmt.setString(1, speciesName);
	            executeUpdate(stmt);
	        } catch (SQLException ex) {
	            Logger.getLogger(SpeciesDAO.class.getName()).log(Level.SEVERE, null, ex);
	        }
	    }

	    private Species buildObject(ResultSet rs) {
	        Species species = null;
	        try {
	            // int id, String nome, String endereco, String telefone, String cep
	            species = new Species(rs.getInt("id"), rs.getString("speciesName"));
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return species;
	    }

	    // RetrieveAll
	    public List<Species> getAllSpecies() {
	        List<Species> listSpecie = new ArrayList<Species>();
	        ResultSet rs = getResultSet("SELECT * FROM species");
	        try {
	            while (rs.next()) {
	                listSpecie.add(buildObject(rs));
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return listSpecie;
	    }

	    // RetrieveById
	    public Species getSpeciesById(int id) {
	        Species species = null;
	        ResultSet rs = getResultSet("SELECT * FROM species WHERE id = " + id);
	        try {
	            if (rs.next()) {
	                species = buildObject(rs);
	            }
	            rs.close();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return species;
	    }

	    // RetrieveByName
	    // Updade
	    public void update(Species species) {
	        try {
	            PreparedStatement stmt;
	            stmt = DAO.getConnection().prepareStatement("UPDATE species SET speciesName=? WHERE id=?");
	            stmt.setString(1, species.getspeciesName());
	            stmt.setInt(2, species.getId());
	            executeUpdate(stmt);
	        } catch (SQLException ex) {
	            ex.printStackTrace();
	        }
	    }
	        // Delete   
	    public void deleteSpecies(Species species) {
	        PreparedStatement stmt;
	        try {
	            stmt = DAO.getConnection().prepareStatement("DELETE FROM species WHERE id = ?");
	            stmt.setInt(1, species.getId());
	            executeUpdate(stmt);
	        } catch (SQLException ex) {
	            ex.printStackTrace();
	        }
	    }
}
