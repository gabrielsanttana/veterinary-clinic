package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class VeterinaryDAO extends DAO {
    private static VeterinaryDAO instance;

    private VeterinaryDAO() {
        DAO.getConnection();
        createTable();
    }

    public static VeterinaryDAO getInstance(){
        if(instance == null) {
            instance = new VeterinaryDAO();
        }
        return instance;
    }
    public boolean createTable() {
    	try {
            PreparedStatement stmt;
            stmt = DAO.getConnection().prepareStatement("CREATE TABLE IF NOT EXISTS veterinary(" + 
            		"id INTEGER PRIMARY KEY, " + 
            		"name  VARCHAR, " + 
            		"address VARCHAR, " + 
            		"phone VARCHAR);");
            executeUpdate(stmt);
            
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(VeterinaryDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    	
    	return false;
    }

// Partial CRUD    
    // Create
    public void addVeterinary(String name, String address, String phone) {
        try {
            PreparedStatement stmt;
            Connection con = DAO.getConnection();
            stmt = con.prepareStatement("INSERT INTO veterinary (name,address,phone) VALUES (?,?,?);");
            stmt.setString(1, name);
            stmt.setString(2, address);
            stmt.setString(3, phone);
            executeUpdate(stmt);
        } catch (SQLException ex) {
            Logger.getLogger(VeterinaryDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private Veterinary buildObject(ResultSet rs) {
        Veterinary veterinary = null;
        try {
            // int id, String nome, String endereco, String telefone, String cep
            veterinary = new Veterinary(rs.getInt("id"), rs.getString("name"), rs.getString("address"), rs.getString("phone"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return veterinary;
    }

    // RetrieveAll
    public List<Veterinary> getAllVeterinary() {
        List<Veterinary> veterinaries = new ArrayList<Veterinary>();
        ResultSet rs = getResultSet("SELECT * FROM veterinary;");
        try {
            while (rs.next()) {
                veterinaries.add(buildObject(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return veterinaries;
    }

    // RetrieveById
    public Veterinary getVeterinaryById(int id) {
        Veterinary veterinary = null;
        ResultSet rs = getResultSet("SELECT * FROM veterinary WHERE id = " + id);
        try {
            if (rs.next()) {
                veterinary = buildObject(rs);
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return veterinary;
    }

    // RetrieveByName
    // Updade
    /*public void update(Client client) {
        try {
            PreparedStatement stmt;
            stmt = DAO.getConnection().prepareStatement("UPDATE client SET name=?, address=?, cep=?, email=?, phone=? WHERE id=?");
            stmt.setString(1, client.getName());
            stmt.setString(2, client.getAddress());
            stmt.setString(3, client.getCep());
            stmt.setString(4, client.getEmail());
            stmt.setString(5, client.getPhone());
            stmt.setInt(6, client.getId());
            executeUpdate(stmt);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
        // Delete   
    public void deleteClient(Client client) {
        PreparedStatement stmt;
        try {
            stmt = DAO.getConnection().prepareStatement("DELETE FROM client WHERE id = ?");
            stmt.setInt(1, client.getId());
            executeUpdate(stmt);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }*/

    
}