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
            stmt = DAO.getConnection().prepareStatement("CREATE TABLE IF NOT EXISTS animal( " + 
            		"                        id INTEGER PRIMARY KEY, " + 
            		"                        animalName  VARCHAR, " + 
            		"                        animalAge INTEGER, " + 
            		"                        animalSex VARCHAR, " + 
            		"                        speciesId INTEGER, " + 
            		"                        clientId INTEGER, " + 
            		"                        FOREIGN KEY(speciesId) REFERENCES species(id), " +
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
    	
        try {
            // int id, String nome, String endereco, String telefone, String cep
        	List<Treatment> treataments = TreatmentDAO.getInstance().getTreatmentByAnimalId(rs.getInt("id"));
        	Species species = SpeciesDAO.getInstance().getSpeciesById(rs.getInt("speciesId"));
            Client client = ClientDAO.getInstance().getClientById(rs.getInt("clientId"));
        	
        	animal = new Animal(rs.getInt("id"), rs.getString("animalName"), rs.getInt("animalAge"), rs.getString("animalSex"), client, treataments, species);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return animal;
    }

    // RetrieveAll
    public List<Animal> getAllAnimals() {
        List<Animal> animals = new ArrayList<Animal>();
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
        Animal animal = new Animal();
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
    	List<Animal> animals = new ArrayList<Animal>();
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
    public void update(Animal animal) {
        try {
            PreparedStatement stmt;
            stmt = DAO.getConnection().prepareStatement("UPDATE animal SET animalName=?, animalAge=?, animalSex=?, clientId=?, species=? WHERE id=?");
            stmt.setString(1, animal.getAnimalName());
            stmt.setInt(2, animal.getAnimalAge());
            stmt.setString(3, animal.getAnimalSex());
            stmt.setInt(4, animal.getClient().getId());
            stmt.setInt(5, animal.getSpecies().getId());
            stmt.setInt(6, animal.getId());
            executeUpdate(stmt);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
        // Delete   
    public void deleteAnimal(Animal animal) {
        PreparedStatement stmt;
        try {
            stmt = DAO.getConnection().prepareStatement("DELETE FROM animel WHERE id = ?");
            stmt.setInt(1, animal.getId());
            executeUpdate(stmt);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

}
