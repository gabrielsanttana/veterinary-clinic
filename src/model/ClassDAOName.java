//package model;
//
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.logging.Level;
//import java.util.logging.Logger;
//
//public class ClassDAOName extends DAO {
//	  private static ClassDAOName instance;
//
//	    private ClassDAOName() {
//	        DAO.getConnection();
//	    }
//
//	    // Singleton
//	    public static ClassDAOName getInstance() {
//	        if (instance == null) {
//	            instance = new ClassDAOName();
//	        }
//	        return instance;
//	    }
//	    
//	    public boolean createTable() {
//	    	try {
//	            PreparedStatement stmt;
//	            stmt = DAO.getConnection().prepareStatement("CREATE TABLE IF NOT EXISTS varName( " + 
//	            		"                        id INTEGER PRIMARY KEY, " + 
//	            		"                        name  VARCHAR, " + 
//	            		"                        address VARCHAR, " + 
//	            		"                        phone VARCHAR, " + 
//	            		"                        cep VARCHAR) ");
//	            executeUpdate(stmt);
//	            
//	            return true;
//	        } catch (SQLException ex) {
//	            Logger.getLogger(ClassDAOName.class.getName()).log(Level.SEVERE, null, ex);
//	        }
//	    	
//	    	return false;
//	    }
//
//	// Partial CRUD    
//	    // Create
//	    public void addClassName(String name, String address, String email, String phone, String cep) {
//	        try {
//	            PreparedStatement stmt;
//	            stmt = DAO.getConnection().prepareStatement("INSERT INTO varName (name,address,cep,email,phone) VALUES (?,?,?,?,?)");
//	            stmt.setString(2, name);
//	            stmt.setString(3, address);
//	            stmt.setString(4, cep);
//	            stmt.setString(5, email);
//	            stmt.setString(6, phone);
//	            executeUpdate(stmt);
//	        } catch (SQLException ex) {
//	            Logger.getLogger(ClassDAOName.class.getName()).log(Level.SEVERE, null, ex);
//	        }
//	    }
//
//	    private ClassName buildObject(ResultSet rs) {
//	        ClassName varName = new ClassName();
//	        try {
//	            // int id, String nome, String endereco, String telefone, String cep
//	            varName = new ClassName(rs.getInt("id"), rs.getString("name"), rs.getString("address"), rs.getString("phone"), rs.getString("cep"), rs.getString("email"));
//	        } catch (SQLException e) {
//	            e.printStackTrace();
//	        }
//	        return varName;
//	    }
//
//	    // RetrieveAll
//	    public List<ClassName> getAllClassNames() {
//	        List<ClassName> varListName = new ArrayList<ClassName>();
//	        ResultSet rs = getResultSet("SELECT * FROM varName");
//	        try {
//	            while (rs.next()) {
//	                varListName.add(buildObject(rs));
//	            }
//	        } catch (SQLException e) {
//	            e.printStackTrace();
//	        }
//	        return varListName;
//	    }
//
//	    // RetrieveById
//	    public ClassName getClassNameById(int id) {
//	        ClassName varName = new ClassName();
//	        ResultSet rs = getResultSet("SELECT * FROM varName WHERE id = " + id);
//	        try {
//	            if (rs.next()) {
//	                varName = buildObject(rs);
//	            }
//	            rs.close();
//	        } catch (SQLException e) {
//	            e.printStackTrace();
//	        }
//	        return varName;
//	    }
//
//	    // RetrieveByName
//	    // Updade
//	    public void update(ClassName varName) {
//	        try {
//	            PreparedStatement stmt;
//	            stmt = DAO.getConnection().prepareStatement("UPDATE varName SET name=?, address=?, cep=?, email=?, phone=? WHERE id=?");
//	            stmt.setString(1, varName.getName());
//	            stmt.setString(2, varName.getAddress());
//	            stmt.setString(3, varName.getCep());
//	            stmt.setString(4, varName.getEmail());
//	            stmt.setString(5, varName.getPhone());
//	            stmt.setInt(6, varName.getId());
//	            executeUpdate(stmt);
//	        } catch (SQLException ex) {
//	            ex.printStackTrace();
//	        }
//	    }
//	        // Delete   
//	    public void deleteClassName(ClassName varName) {
//	        PreparedStatement stmt;
//	        try {
//	            stmt = DAO.getConnection().prepareStatement("DELETE FROM varName WHERE id = ?");
//	            stmt.setInt(1, varName.getId());
//	            executeUpdate(stmt);
//	        } catch (SQLException ex) {
//	            ex.printStackTrace();
//	        }
//	    }
//}
