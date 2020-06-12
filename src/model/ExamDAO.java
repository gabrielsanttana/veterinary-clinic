package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ExamDAO extends DAO {
	  private static ExamDAO instance;

	    private ExamDAO() {
	        DAO.getConnection();
	    }

	    // Singleton
	    public static ExamDAO getInstance() {
	        if (instance == null) {
	            instance = new ExamDAO();
	        }
	        return instance;
	    }
	    
	    public boolean createTable() {
	    	try {
	            PreparedStatement stmt;
	            stmt = DAO.getConnection().prepareStatement("CREATE TABLE IF NOT EXISTS exam( " + 
	            		"                        id INTEGER PRIMARY KEY, " + 
	            		"                        examDesc  VARCHAR, " + 
	            		"                        FOREIGN KEY(consultId) REFERENCES consult(id) ) " );
	            executeUpdate(stmt);
	            
	            return true;
	        } catch (SQLException ex) {
	            Logger.getLogger(ExamDAO.class.getName()).log(Level.SEVERE, null, ex);
	        }
	    	
	    	return false;
	    }

	// Partial CRUD    
	    // Create
	    public void addExam(String examDesc, int consult) {
	        try {
	            PreparedStatement stmt;
	            stmt = DAO.getConnection().prepareStatement("INSERT INTO exam (examDesc,consultId) VALUES (?,?)");
	            stmt.setString(1, examDesc);
	            stmt.setInt(2, consult);
	            executeUpdate(stmt);
	        } catch (SQLException ex) {
	            Logger.getLogger(ExamDAO.class.getName()).log(Level.SEVERE, null, ex);
	        }
	    }

	    private Exam buildObject(ResultSet rs) {
	        Exam exam = new Exam();
	        try {
	            // int id, String nome, String endereco, String telefone, String cep
	        	Consult consult = ConsultDAO.getInstance().getConsultById(rs.getInt("consultId"));
	            exam = new Exam(rs.getInt("id"), rs.getString("examDesc"),consult);
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return exam;
	    }

	    // RetrieveAll
	    public List<Exam> getAllExams() {
	        List<Exam> listExam = new ArrayList<Exam>();
	        ResultSet rs = getResultSet("SELECT * FROM exam");
	        try {
	            while (rs.next()) {
	                listExam.add(buildObject(rs));
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return listExam;
	    }

	    // RetrieveById
	    public Exam getExamById(int id) {
	        Exam exam = null;
	        ResultSet rs = getResultSet("SELECT * FROM exam WHERE id = " + id);
	        try {
	            if (rs.next()) {
	                exam = buildObject(rs);
	            }
	            rs.close();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return exam;
	    }
	    
	    public List<Exam> getExamByConsultId(int consult){
	    	List<Exam> listExam = new ArrayList<Exam>();
	        ResultSet rs = getResultSet("SELECT * FROM exam WHERE consultId = " + consult);
	        try {
	            while (rs.next()) {
	    	        Exam exam = new Exam();
	                exam = buildObject(rs);
	                listExam.add(exam);
	            }
	            rs.close();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    	return listExam;
	    }

	    // RetrieveByName
	    // Updade
	    public void update(Exam exam) {
	        try {
	            PreparedStatement stmt;
	            stmt = DAO.getConnection().prepareStatement("UPDATE exam SET examDesc=?, consult=?  WHERE id=?");
	            stmt.setString(1, exam.getExamDesc());
	            stmt.setInt(2, exam.getConsult().getId());
	            stmt.setInt(3, exam.getId());
	            executeUpdate(stmt);
	        } catch (SQLException ex) {
	            ex.printStackTrace();
	        }
	    }
	        // Delete   
	    public void deleteExam(Exam exam) {
	        PreparedStatement stmt;
	        try {
	            stmt = DAO.getConnection().prepareStatement("DELETE FROM exam WHERE id = ?");
	            stmt.setInt(1, exam.getId());
	            executeUpdate(stmt);
	        } catch (SQLException ex) {
	            ex.printStackTrace();
	        }
	    }
}
