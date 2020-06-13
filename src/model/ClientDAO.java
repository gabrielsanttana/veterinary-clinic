package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Plinio Vilela
 */
public class ClientDAO extends DAO {

    private static ClientDAO instance;

    private ClientDAO() {
        DAO.getConnection();
        createTable();
    }

    // Singleton
    public static ClientDAO getInstance() {
        if (instance == null) {
            instance = new ClientDAO();
        }
        return instance;
    }
    
    public boolean createTable() {
    	try {
            PreparedStatement stmt;
            stmt = DAO.getConnection().prepareStatement("CREATE TABLE IF NOT EXISTS client( \n" + 
            		"                        id INTEGER PRIMARY KEY, \n" + 
            		"                        name  VARCHAR,\n" + 
            		"                        address VARCHAR, \n" + 
            		"                        phone VARCHAR, \n" + 
            		"                        email VARCHAR, \n" + 
            		"                        cep VARCHAR)");
            executeUpdate(stmt);
            
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ClientDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    	
    	return false;
    }

// Partial CRUD    
    // Create
    public void addClient(String name, String address, String email, String phone, String cep) {
        try {
            PreparedStatement stmt;
            stmt = DAO.getConnection().prepareStatement("INSERT INTO client (name,address,cep,email,phone) VALUES (?,?,?,?,?)");
            stmt.setString(1, name);
            stmt.setString(2, address);
            stmt.setString(3, cep);
            stmt.setString(4, email);
            stmt.setString(5, phone);
            executeUpdate(stmt);
        } catch (SQLException ex) {
            Logger.getLogger(ClientDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private Client buildObject(ResultSet rs) {
        Client client = new Client();
        try {
            // int id, String nome, String endereco, String telefone, String cep
            client = new Client(rs.getInt("id"), rs.getString("name"), rs.getString("address"), rs.getString("phone"), rs.getString("cep"), rs.getString("email"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return client;
    }

    // RetrieveAll
    public List<Client> getAllClients() {
        List<Client> clients = new ArrayList<Client>();
        ResultSet rs = getResultSet("SELECT * FROM client");
        try {
            while (rs.next()) {
                clients.add(buildObject(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return clients;
    }

    // RetrieveById
    // Os grupos devem implementar as modificacoes para permitir que um cliente seja
    // encontrado a partir de um id (inteiro).
    // Sugestao, ao inves de usar um List, usar um Map.
    public Client getClientById(int id) {
        Client client = new Client();
        ResultSet rs = getResultSet("SELECT * FROM client WHERE id = " + id);
        try {
            if (rs.next()) {
                client = buildObject(rs);
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return client;
    }

    // RetrieveByName
    // Updade
    public void update(Client client) {
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
    }

}