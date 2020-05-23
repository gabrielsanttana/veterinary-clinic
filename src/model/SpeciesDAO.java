package model;

import java.util.HashMap;
import java.util.Map;
import java.util.Observable;

public class SpeciesDAO extends Observable{
	
    private static SpeciesDAO instance;
    private Map<Integer,Species> listSpecies;
    private Integer id;
    
    private SpeciesDAO(){
    	listSpecies = new HashMap<Integer,Species>();
        id = 0;
    }
    
    // Singleton
    public static SpeciesDAO getInstance(){
       if (instance == null) {
            instance = new SpeciesDAO();
        }
        return instance;
    }

    
    
    // Partial CRUD    
    // Create
    public void addSpecies(String speciesName){
    	Species species = new Species(id,speciesName);
        listSpecies.put(id,species);
        id++;
        setChanged();
        notifyObservers(species);
    }
    
    // RetrieveAll
    public Map<Integer,Species> getAllSpecies(){        
        return listSpecies;
    }
    
    // RetrieveById
    public Species getSpeciesById(int id){
    	return listSpecies.get(id);
    }
    
    // RetrieveByName
    
    // Updade
    
    // Delete   
    public void deleteSpecies(Species species){
    	listSpecies.remove(species.getId());
    }
}
