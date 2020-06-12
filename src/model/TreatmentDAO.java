package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.Date;

public class TreatmentDAO extends DAO {
	  private static TreatmentDAO instance;

	    private TreatmentDAO() {
	        DAO.getConnection();
	        createTable();
	    }

	    // Singleton
	    public static TreatmentDAO getInstance() {
	        if (instance == null) {
	            instance = new TreatmentDAO();
	        }
	        return instance;
	    }
	    
	    public boolean createTable() {
	    	try {
	            PreparedStatement stmt;
	            stmt = DAO.getConnection().prepareStatement("CREATE TABLE IF NOT EXISTS treatment( " + 
	            		"                        id INTEGER PRIMARY KEY, \n" + 
	            		"                        startDate  datetime ,\n" + 
	            		"                        endDate datetime , " + 
	            		"                        animalId INTEGER, " + 
	            		"                        FOREIGN KEY(animalId) REFERENCES animal(id) ) ");
	            executeUpdate(stmt);
	            
	            return true;
	        } catch (SQLException ex) {
	            Logger.getLogger(TreatmentDAO.class.getName()).log(Level.SEVERE, null, ex);
	        }
	    	
	    	return false;
	    }

	// Partial CRUD    
	    // Create
	    public void addTreatment(Date startDate, Date endDate, int animal) {
	        try {
	            PreparedStatement stmt;
	            stmt = DAO.getConnection().prepareStatement("INSERT INTO treatment (startDate,endDate,animalId) VALUES (?,?,?)");
	            stmt.setString(1, Util.DateToStringSQL(startDate));
	            stmt.setString(2, Util.DateToStringSQL(endDate));
	            stmt.setInt(3, animal);
	            executeUpdate(stmt);
	        } catch (SQLException ex) {
	            Logger.getLogger(TreatmentDAO.class.getName()).log(Level.SEVERE, null, ex);
	        }
	    }

	    private Treatment buildObject(ResultSet rs) {
	        Treatment treatment = new Treatment();
	        try {
	            // int id, String nome, String endereco, String telefone, String cep
	        	Animal animal = AnimalDAO.getInstance().getAnimalById(rs.getInt("animalId"));
	        	List<Consult> listConsult = ConsultDAO.getInstance().getConsultByTreatmentId(rs.getInt("id"));
	        	//rs.getInt("animalId")
	            treatment = new Treatment(rs.getInt("id"), rs.getDate("startDate"), rs.getDate("endDate"),listConsult,animal);
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return treatment;
	    }

	    // RetrieveAll
	    public List<Treatment> getAllTreatments() {
	        List<Treatment> listTreatment = new ArrayList<Treatment>();
	        ResultSet rs = getResultSet("SELECT * FROM treatment");
	        try {
	            while (rs.next()) {
	                listTreatment.add(buildObject(rs));
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return listTreatment;
	    }

	    // RetrieveById
	    public Treatment getTreatmentById(int id) {
	        Treatment treatment = null;
	        ResultSet rs = getResultSet("SELECT * FROM treatment WHERE id = " + id);
	        try {
	            if (rs.next()) {
	                treatment = buildObject(rs);
	            }
	            rs.close();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return treatment;
	    }
	    
	    public List<Treatment> getTreatmentByAnimalId(int animal){
	    	List<Treatment> listTreatment = new ArrayList<Treatment>();
	        ResultSet rs = getResultSet("SELECT * FROM treatment WHERE animalId = " + animal);
	        try {
	            while (rs.next()) {
	    	        Treatment treatment = new Treatment();
	                treatment = buildObject(rs);
	                listTreatment.add(treatment);
	            }
	            rs.close();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    	
	    	return listTreatment;
	    	
	    }

	    // RetrieveByName
	    // Updade
	    public void update(Treatment treatment) {
	        try {
	            PreparedStatement stmt;
	            stmt = DAO.getConnection().prepareStatement("UPDATE treatment SET startDate=?, endDate=? WHERE id=?");
	            stmt.setString(1, treatment.getStartDateSQL());
	            stmt.setString(2, treatment.getEndDateSQL());
	            stmt.setInt(3, treatment.getId());
	            executeUpdate(stmt);
	        } catch (SQLException ex) {
	            ex.printStackTrace();
	        }
	    }
	        // Delete   
	    public void deleteTreatment(Treatment treatment) {
	        PreparedStatement stmt;
	        try {
	            stmt = DAO.getConnection().prepareStatement("DELETE FROM treatment WHERE id = ?");
	            stmt.setInt(1, treatment.getId());
	            executeUpdate(stmt);
	        } catch (SQLException ex) {
	            ex.printStackTrace();
	        }
	    }
}
