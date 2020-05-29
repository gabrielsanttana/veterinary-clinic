package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AnimalDAO extends DAO {

    private static AnimalDAO instance;

    private AnimalDAO() {
        DAO.getConnection();
        createTable();
    }

    // Singleton
    public static AnimalDAO getInstance() {
        if (instance == null) {
            instance = new AnimalDAO();
        }
        return instance;
    }
    
    public boolean createTable() {
    	try {
            PreparedStatement stmt;
            stmt = DAO.getConnection().prepareStatement("CREATE TABLE IF NOT EXISTS animal( \n" + 
            		"                        id INTEGER PRIMARY KEY, \n" + 
            		"                        animalName  VARCHAR,\n" + 
            		"                        animalAge INTEGER, \n" + 
            		"                        animalSex VARCHAR, \n" + 
            		"                        FOREIGN KEY(clientId) REFERENCES client(id))");
            executeUpdate(stmt);
            
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(AnimalDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    	
    	return false;
    }

// Partial CRUD    
    // Create
    public void addAnimal(String animalName, int animalAge, String animalSex, int clientId) {
        try {
            PreparedStatement stmt;
            stmt = DAO.getConnection().prepareStatement("INSERT INTO animal (animalName,animalAge,animalSex,clientId) VALUES (?,?,?,?)");
            stmt.setString(2, animalName);
            stmt.setInt(3, animalAge);
            stmt.setString(4, animalSex);
            stmt.setInt(5, clientId);
            executeUpdate(stmt);
        } catch (SQLException ex) {
            Logger.getLogger(AnimalDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private Animal buildObject(ResultSet rs) {
    	Animal animal = null;
    	Treatment[] treataments = new Treatment[0];
    	Species species = new Species();
        try {
            // int id, String nome, String endereco, String telefone, String cep
        	animal = new Animal(rs.getInt("id"), rs.getString("animalName"), rs.getInt("animalAge"), rs.getString("animalSex"), rs.getInt("clientId"), treataments, species);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return animal;
    }

    // RetrieveAll
    public List getAllAnimals() {
        List<Animal> animals = new ArrayList();
        ResultSet rs = getResultSet("SELECT * FROM animal");
        try {
            while (rs.next()) {
            	animals.add(buildObject(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return animals;
    }

    // RetrieveById
    // Os grupos devem implementar as modificacoes para permitir que um cliente seja
    // encontrado a partir de um id (inteiro).
    // Sugestao, ao inves de usar um List, usar um Map.
    public Animal getAnimalById(int id) {
        Animal animal = null;
        ResultSet rs = getResultSet("SELECT * FROM animal WHERE id = " + id);
        try {
            if (rs.next()) {
                animal = buildObject(rs);
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return animal;
    }
    
    public List<Animal> getAnimalByClient(int clientId) {
    	List<Animal> animals = new ArrayList();
        ResultSet rs = getResultSet("SELECT * FROM animal WHERE clientId = " + clientId);
        try {
            while (rs.next()) {
            	animals.add(buildObject(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return animals;
    }

    // RetrieveByName
    // Updade
//    public void update(Animal animal) {
//        try {
//            PreparedStatement stmt;
//            stmt = DAO.getConnection().prepareStatement("UPDATE animal SET name=?, address=?, cep=?, email=?, phone=? WHERE id=?");
//            stmt.setString(1, client.getName());
//            stmt.setString(2, client.getAddress());
//            stmt.setString(3, client.getCep());
//            stmt.setString(4, client.getEmail());
//            stmt.setString(5, client.getPhone());
//            stmt.setInt(6, client.getId());
//            executeUpdate(stmt);
//        } catch (SQLException ex) {
//            ex.printStackTrace();
//        }
//    }
//        // Delete   
//    public void deleteClient(Client client) {
//        PreparedStatement stmt;
//        try {
//            stmt = DAO.getConnection().prepareStatement("DELETE FROM client WHERE id = ?");
//            stmt.setInt(1, client.getId());
//            executeUpdate(stmt);
//        } catch (SQLException ex) {
//            ex.printStackTrace();
//        }
//    }

}
