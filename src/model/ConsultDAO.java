package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConsultDAO extends DAO {
	  private static ConsultDAO instance;

	    private ConsultDAO() {
	        DAO.getConnection();
	        createTable();
	    }

	    // Singleton
	    public static ConsultDAO getInstance() {
	        if (instance == null) {
	            instance = new ConsultDAO();
	        }
	        return instance;
	    }
	    
	    public boolean createTable() {
	    	try {
	            PreparedStatement stmt;
	            stmt = DAO.getConnection().prepareStatement("CREATE TABLE IF NOT EXISTS consult( " + 
	            		"                        id INTEGER PRIMARY KEY, " + 
	            		"                        consultDate  datetime, " + 
	            		"                        historic VARCHAR, " + 
	            		"                        treatmentId INTEGER, " + 
	            		"                        veterinaryId INTEGER, " + 
	            		"                        FOREIGN KEY(treatmentId) REFERENCES treatment(id), " + 
	            		"                        FOREIGN KEY(veterinaryId) REFERENCES veterinary(id) )"); 
	            executeUpdate(stmt);
	            
	            return true;
	        } catch (SQLException ex) {
	            Logger.getLogger(ConsultDAO.class.getName()).log(Level.SEVERE, null, ex);
	        }
	    	
	    	return false;
	    }

	// Partial CRUD    
	    // Create
	    public void addConsult(Date consultDate, String historic, int treatment, int veterinary) {
	        try {
	            PreparedStatement stmt;
	            stmt = DAO.getConnection().prepareStatement("INSERT INTO consult (consultDate,historic,treatmentId,veterinaryId) VALUES (?,?,?,?)");
	            stmt.setString(1, Util.DateToStringSQL(consultDate));
	            stmt.setString(2, historic);
	            stmt.setInt(3, treatment);
	            stmt.setInt(4, veterinary);
	            executeUpdate(stmt);
	        } catch (SQLException ex) {
	            Logger.getLogger(ConsultDAO.class.getName()).log(Level.SEVERE, null, ex);
	        }
	    }

	    private Consult buildObject(ResultSet rs) {
	        Consult consult = new Consult();
	        try {
	            // int id, String nome, String endereco, String telefone, String cep

	        	Treatment treatment = TreatmentDAO.getInstance().getTreatmentById(rs.getInt("treatmentId"));
	    	    Veterinary veterinary = VeterinaryDAO.getInstance().getVeterinaryById(rs.getInt("veterinaryId"));
	    	    List<Exam> listExam = new ArrayList<Exam>();
//	    	    List<Exam> listExam = ExamDAO.getInstance().getExamByConsultId(rs.getInt("id"));
	    	    Date consultDate = Util.StringToDate(rs.getString("consultDate"));
	            consult = new Consult(rs.getInt("id"), consultDate , rs.getString("historic"),treatment,veterinary,listExam);
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return consult;
	    }

	    // RetrieveAll
	    public List<Consult> getAllConsults() {
	        List<Consult> listConsult = new ArrayList<Consult>();
	        ResultSet rs = getResultSet("SELECT * FROM consult");
	        try {
	            while (rs.next()) {
	                listConsult.add(buildObject(rs));
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return listConsult;
	    }

	    // RetrieveById
	    public Consult getConsultById(int id) {
	        Consult consult = new Consult();
	        ResultSet rs = getResultSet("SELECT * FROM consult WHERE id = " + id);
	        try {
	            if (rs.next()) {
	                consult = buildObject(rs);
	            }
	            rs.close();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return consult;
	    }
	    
	    public List<Consult> getConsultByTreatmentId(int treatment){
	    	List<Consult> listConsult = new ArrayList<Consult>();
	        ResultSet rs = getResultSet("SELECT * FROM consult WHERE treatmentId = " + treatment);
	        try {
	            while (rs.next()) {
	    	        Consult consult = new Consult();
	                consult = buildObject(rs);
	                listConsult.add(consult);
	            }
	            rs.close();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    	return listConsult;
	    }
	    
	    public List<Consult> getConsultByVeterinaryId(int veterinary){
	    	List<Consult> listConsult = new ArrayList<Consult>();
	        ResultSet rs = getResultSet("SELECT * FROM consult WHERE veterinaryId = " + veterinary);
	        try {
	            while (rs.next()) {
	    	        Consult consult = new Consult();
	                consult = buildObject(rs);
	                listConsult.add(consult);
	            }
	            rs.close();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    	return listConsult;
	    }

	    // RetrieveByName
	    // Updade
	    public void update(Consult consult) {
	        try {
	            PreparedStatement stmt;
	            stmt = DAO.getConnection().prepareStatement("UPDATE consult SET consultDate=?, historic=?, treatmentId=?, veterinaryId=? WHERE id=?");
	            stmt.setString(1, Util.DateToStringSQL(consult.getConsultDate()));
	            stmt.setString(2, consult.getHistoric());
	            stmt.setInt(3, consult.getTreatment().getId());
	            stmt.setInt(4, consult.getVeterinary().getId());
	            stmt.setInt(5, consult.getId());
	            executeUpdate(stmt);
	        } catch (SQLException ex) {
	            ex.printStackTrace();
	        }
	    }
	        // Delete   
	    public void deleteConsult(Consult consult) {
	        PreparedStatement stmt;
	        try {
	            stmt = DAO.getConnection().prepareStatement("DELETE FROM consult WHERE id = ?");
	            stmt.setInt(1, consult.getId());
	            executeUpdate(stmt);
	        } catch (SQLException ex) {
	            ex.printStackTrace();
	        }
	    }
}
